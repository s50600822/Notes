import json
import boto3
import time

sts_client = boto3.client('sts')
error_msg = ''

def lambda_handler(event, context):

    # PASS IN THE VARIABLES BELOW HOWEVER YOU SEE FIT
    mgmt_acct_id = 'your_mgmt_acct_id'
    member_acct_ids = ['account_id_1', 'account_id_2', 'account_id_3']

    global error_msg
    error_msg = ''

    for member_acct_id in member_acct_ids:
        sts_result = get_assume_role_creds(member_acct_id)
        if sts_result != '':
            ACCESS_KEY = sts_result['Credentials']['AccessKeyId']
            SECRET_KEY = sts_result['Credentials']['SecretAccessKey']
            SESSION_TOKEN = sts_result['Credentials']['SessionToken']
            okayToProceed = create_IAM_Role_For_CWE(ACCESS_KEY, SECRET_KEY, SESSION_TOKEN, mgmt_acct_id, member_acct_id)
            if okayToProceed:
                create_CWE_in_member_account(ACCESS_KEY, SECRET_KEY, SESSION_TOKEN, mgmt_acct_id, member_acct_id)
    
    if error_msg != '':
        print('\nError Report:\n' + error_msg)
    
    return 'done.'
        

def get_assume_role_creds(member_acct_id):
    
    try:
        global error_msg
        
        return sts_client.assume_role(
            RoleArn = 'arn:aws:iam::' + member_acct_id + ':role/CloudAdmin',
            RoleSessionName = 'sts_role_to_member_account'
        )

    except Exception as e:
        error_msg = error_msg + member_acct_id + ' - ' + str(e) + '\n'
        return ''


def create_IAM_Role_For_CWE(ACCESS_KEY, SECRET_KEY, SESSION_TOKEN, mgmt_acct_id, member_acct_id):
    
    try:
        global error_msg
        role_name = 'Allows_AWS_RISK_to_Invoke_Event_Bus'

        iam_client = boto3.client('iam',
            aws_access_key_id=ACCESS_KEY,
            aws_secret_access_key=SECRET_KEY,
            aws_session_token=SESSION_TOKEN,
        )

        trust_policy = {
            'Version': '2012-10-17',
            'Statement': [
                {
                    'Effect': 'Allow',
                    'Principal': {
                    'Service': 'events.amazonaws.com'
                },
                'Action': 'sts:AssumeRole'
                }
            ]
        }
            
        response = iam_client.create_role(
            RoleName = role_name,
            AssumeRolePolicyDocument = json.dumps(trust_policy),
            Description = 'Role to allow AWS Events service to send events to event bus in management account.'
            #Tags=[
            #    {
            #        'Key': 'string',
            #        'Value': 'string'
            #    },
            #]
        )
        #print(response)

        
        perm_policy = {
            'Version': '2012-10-17',
            'Statement': {
                'Action': 'events:PutEvents',
                'Resource': 'arn:aws:events:us-east-1:' + mgmt_acct_id + ':event-bus/default',
                'Effect': 'Allow'
            }
        }

        response = iam_client.put_role_policy(
            RoleName = role_name,
            PolicyName = 'Allows_AWS_RISK_to_send_events_to_mgmt_acct',
            PolicyDocument = json.dumps(perm_policy)
        )
        #print(response)

        return True
    
    except Exception as e:
        error_msg = error_msg + member_acct_id + ' - ' + str(e) + '\n'
        return False



def create_CWE_in_member_account(ACCESS_KEY, SECRET_KEY, SESSION_TOKEN, mgmt_acct_id, member_acct_id):
    
    try:
        global error_msg
        rule_name = 'Send_AWS_RISK_Events_To_Management_Account'

        events_client = boto3.client('events',
            aws_access_key_id=ACCESS_KEY,
            aws_secret_access_key=SECRET_KEY,
            aws_session_token=SESSION_TOKEN,
        )

        event_pattern = {
			"source": [
				"aws.health"
			],
			"detail-type": [
				"AWS Health Event"
			],
			"detail": {
				"service": [
					"RISK"
				]
			}
		}

        response = events_client.put_rule(
            Name = rule_name,
            EventPattern = json.dumps(event_pattern),
            Description = 'Send AWS RISK events to default event bus in management account.',
            State = 'ENABLED'
            #EventBusName = 'default'
            #Tags=[
            #    {
            #        'Key': 'string',
            #        'Value': 'string'
            #    },
            #],
            )
        #print(response)
        
        
        response = events_client.put_targets(
        Rule = rule_name,
        EventBusName='default',
        Targets=[
            {
                'Id': mgmt_acct_id,
                'Arn': 'arn:aws:events:us-east-1:' + mgmt_acct_id + ':event-bus/default',
                'RoleArn': 'arn:aws:iam::' + member_acct_id + ':role/Allows_AWS_RISK_to_Invoke_Event_Bus',
            }
            ]
        )
        #print(response)
    
        print(member_acct_id + ' - succeeded')
    
    except Exception as e:
        error_msg = error_msg + member_acct_id + ' - ' + str(e) + '\n'
        print (member_acct_id + ' - failed')

