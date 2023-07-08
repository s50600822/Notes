import json
import boto3
import os

from urllib.request import Request, urlopen
from urllib.error import URLError, HTTPError

# Slack integration
SEND_SLACK_MESSAGE = False
SLACK_CHANNEL = ''
HOOK_URL = ''
 
sns_client = boto3.client('sns')
sts_client = boto3.client('sts')

def lambda_handler(event, context):
  
  # preserve event info for future reference
  print(event)

  exposed_credentials = ''
  account_id = event['account']
  access_keys = ','.join(event['resources'])

  for access_key in event['resources']:
    if len(access_key) == 20:
      service_client = get_service_client('iam', account_id)
      if service_client != '':
        username = get_username_from_key(service_client, access_key)
        exposed_credentials = exposed_credentials +  '\nUsername: ' + username + '\nAccess Key: ' + access_key
        send_notifications(event, account_id, exposed_credentials, SEND_SLACK_MESSAGE)
        disable_access_key(service_client, username, access_key)
        #delete_access_key(service_client, username, access_key)
        #delete_IAM_user(service_client, username)
        #customize other actions to suit your needs
    else:
      send_notifications(event, account_id, exposed_credentials, SEND_SLACK_MESSAGE)

  return 'Done.'


def send_notifications(event, account_id, exposed_credentials, SEND_SLACK_MESSAGE):

  try:

    event_time = event['time']
    event_type = event['detail']['eventTypeCode']

    # format JSON message to suit your need
    email_json_message = {
      'eventType' : event_type,
      'event_time' : event_time,
      'account_id' : account_id,
      'credentials' : exposed_credentials
    }
  
    sms_message = 'Event Type: ' + event_type + \
      '\nEvent Time: ' + event_time + \
      '\nAccount ID: ' + account_id + exposed_credentials

    email_message = 'Account compromise detected.' \
      '\nAccount ID: ' + account_id + '\n' + exposed_credentials
  
    # DON'T FORGET TO CHANGE THE TOPIC ARN BELOW
    response = sns_client.publish(
      Subject = 'Credential Exposed',
      Message = json.dumps({
        'default': json.dumps(email_json_message),
        'sms': sms_message,
        'email': email_message
      }),
      TopicArn = 'arn:aws:sns:us-east-1:mgmt_acct_id_goes_here:SecurityAlert',
      MessageStructure = 'json')

    print('SNS: Notification sent.')

    if SEND_SLACK_MESSAGE == True:
      send_Slack_Message(sms_message)

  except Exception as e:
    print('Error occurred: ' + str(e))


def send_Slack_Message(sms_message):
  try:
      
    slack_message = {
      'channel': SLACK_CHANNEL,
      'Content': 'Account compromise issue detected.\n' + sms_message
    }
       
    req = Request(HOOK_URL, json.dumps(slack_message).encode('utf-8'))
    
    response = urlopen(req)
    response.read()
    print('SLACK: Message posted to {0}'.format(SLACK_CHANNEL))

  except HTTPError as e:
    print('SLACK: Request failed: {0} {1}'.format(e.code, e.reason))
  except URLError as e:
    print('SLACK: Server connection failed: {0}'.format(e.reason))


def get_service_client(service_name, member_acct_id):
    
    try:
        
        # CHANGE THE ROLE NAME IN MEMBER ACCOUNTS HERE
        assume_role_creds = sts_client.assume_role(
            RoleArn = 'arn:aws:iam::' + member_acct_id + ':role/CloudAdmin',
            RoleSessionName = 'sts_role_to_member_account'
        )

        # create service client using the assumed role credentials
        return boto3.client(service_name,
          aws_access_key_id = assume_role_creds['Credentials']['AccessKeyId'],
          aws_secret_access_key = assume_role_creds['Credentials']['SecretAccessKey'],
          aws_session_token = assume_role_creds['Credentials']['SessionToken']
        )
    
    except Exception as e:
        print('Error occurred: ' + str(e))
        return ''


def get_username_from_key(service_client, access_key_id):
 
  try:

    response = service_client.get_access_key_last_used(
      AccessKeyId=access_key_id
    )
  except Exception as e:
    print('Unable to retrieve username')
    print(e)
    # return empty if user doesn't exist
    return ''
  return response['UserName']


# This will only disable exposed key(s)
def disable_access_key(service_client, username, access_key_id):
  
  try:

    response = service_client.update_access_key(
      UserName = username,
      AccessKeyId = access_key_id,
      Status = 'Inactive'
    )
    print('Access key disabled: ' + access_key_id)

  except Exception as e:
    print('Unable to disable access key')
    print(e)


def delete_access_key(service_client, username, access_key_id):
  
  try:

    response = service_client.delete_access_key(
      UserName = username,
      AccessKeyId = access_key_id
    )
    print('Access key deleted: ' + access_key_id)

  except Exception as e:
    print('Unable to delete access key')
    print(e)


def delete_IAM_user(service_client, username):
  
  try:

    # Need to perform the following steps first
    # Password ( DeleteLoginProfile )
    # Access keys ( DeleteAccessKey )
    # Signing certificate ( DeleteSigningCertificate )
    # SSH public key ( DeleteSSHPublicKey )
    # Git credentials ( DeleteServiceSpecificCredential )
    # Multi-factor authentication (MFA) device ( DeactivateMFADevice , DeleteVirtualMFADevice )
    # Inline policies ( DeleteUserPolicy )
    # Attached managed policies ( DetachUserPolicy )
    # Group memberships ( RemoveUserFromGroup )
      
    #response = service_client.delete_user(UserName = username)
    print('IAM user deleted: ' + username)

  except Exception as e:
    print('Unable to delete IAM user')
    print(e)
