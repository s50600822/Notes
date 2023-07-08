Author: Brian Dao
Email: briandao@amazon.com
Description: This solution is used to detect & automatically mitigate account compromise
issues at scale.



- Management_Account_Template.json: This is the CloudFormation template to be deployed on
the management account (an account used to process security events). This template will
create a Lambda function using inline code (inline code limits Lambda function to 4096 
character so there's a separate function to address this limit).  The Lambda function sends 
notification & disable the IAM access key out of the box if an exposed key is found.  You 
will need to modify the function if you want it to take other actions.  If you deploy this 
template then skip the one below as they are similar. This template creates the following 
resources:
  - An SNS Topic + subscription endpoint
  - Permission for CW Event Bus to receive events from member accounts
  - A Lambda function + permission (update Lambda execution role/permissions as appropriate)
  - An IAM Role for use by CWE
  - A CWE Rule to send events to Lambda



- Management_Account_Template_with_Zipped_Lambda.json: This is similar to the one above; 
however, it's using S3 to deploy the function to get around the character limit imposed by 
inline code as mentioned above.  If you deploy this template then skip the one above and you 
must manually perform the following steps before deployment:
  - Create an SNS Topic (or use existing one)
  - Subscribe endpoints to the topic
  - Update the Lambda function with the SNS Topic ARN
  - Zip & upload Lambda code to S3
  - Update template with bucket/key name



- Member_Account_Template.json: This is the CloudFormation template to be deploy in member 
accounts.  If you have an existing account onboarding process then add this template to it 
otherwise use the Python script below. This template creates the following resources:
  - IAM Role for use with CWE Rule
  - CWE rule to send AWS RISK events to Management Account.



- Add_CWE_Rule_To_Member_Account.py: This script will help you create IAM Role & CWE rule 
in existing member accounts (similar to the Member_Account_Template.json above; however, it 
can handle large number of accounts). You will need to supply a Management Account ID & a 
list of member accounts.  Modify and use it however you see fit.  Keep a log of success/failure 
executions so you know which account is done and which one needs to be looked at.  

SUGGESTION: Modify this script to take a list of accounts ids, tie it to API GW.  That way,
you can automate the process of adding new accounts by calling API GW .  Then this can be 
used to add CWE rule to existing accounts as well.  Otherwise, modify the script to read 
from a file containing account ids.  If used with Lambda, be sure to increase Lambda Timeout
value and give it a high enough value to process all accounts in the list.



- Lambda_Process_AWS_RISK_Events.py: This is the Lambda code that processes the events.  
For the most part, it's similar to the one deployed by the CFN template but has a bit more 
flexibility as it doesn't have 4096 character limit.  You can manually modify this one and 
update the one deploy by the template.  Update this function to suit your need.  Out of the
box, it only does notification and disable the access key if one is found.


- Test_Event.json: This is the test event pattern for CWE. Use the content of this file to 
Create test event for the Lambda function.  Don't forget to update the Account ID & 
Resources keys before configuring test event.


SLACK integration:
To integration the solution with Slack, update the SEND_SLACK_MESSAGE variable to True and 
specify the channel as well as the URL for Slack.

SEND_SLACK_MESSAGE = True
SLACK_CHANNEL = 'your-slack-channel'
HOOK_URL = 'your-web-hook-url'


NOTE: Don't forget to update DeletionPolicy in the CFN templates.