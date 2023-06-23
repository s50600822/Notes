## 1: Create Your Slack Account
First, you will need to create a Slack account so your bot can interact with it. You can do this prior to starting the lab to save time. If you already have a Slack account that you plan to use for this lab you can skip to the next Section.

In a new browser tab, go to https://slack.com/get-started#/createnew.

Enter your email address, then choose Continue.

Check your email, and use the confirmation code to confirm your account.

Choose Create a Workspace.

For What’s the name of your company or team?, enter your company name, then choose Next.

If asked, Let’s find the people you work with most, choose Skip this step.

For What’s a project your team is working on?, enter a project name, then choose Next.

For Who do you email most about …, choose skip this step.

Choose Skip Step.

Choose your channel on the left.




## 2: Configure Incoming WebHooks For Slack
Sign into your  Slack account if you haven’t already.

In the navigation menu on the left, choose Browse Slack.

Choose Apps.

In the Search  box, type 

Incoming WebHooks

Under Incoming WebHooks, choose Add.

Choose Add to Slack.

Choose the Post to channel drop-down  and select #general.

Choose Add Incoming WebHooks integration.

Copy the Webhook URL to a text editor.

You will need this later.

Scroll to the bottom, then choose Save Settings.

Leave this browser tab/window open, you will return to it later.


Task 3: Create and Subscribe to an SNS Topic
In this task, you will create an SNS topic and subscribe to the topic using your email address.

Amazon Simple Notification Service (SNS) is a flexible, fully managed pub/sub messaging and mobile notifications service for coordinating the delivery of messages to subscribing endpoints and clients. With SNS you can fan-out messages to a large number of subscribers, including distributed systems and services, and mobile devices. It is easy to set up, operate, and reliably send notifications to all your endpoints – at any scale. You can get started using SNS in a matter of minutes using the AWS Management Console, AWS Command Line Interface, or using the AWS SDK with just three simple APIs. SNS eliminates the complexity and overhead associated with managing and operating dedicated messaging software and infrastructure.

At the top of the page, in the unified search bar, search for and choose Simple Notification Service.

In the left navigation pane, choose the three line bars.

Choose Topics.

Choose Create topic

In the Create topic window, configure:

Type: Standard
Name: slacknews
Display name: slacknews
Choose Create topic
Choose Create subscription then configure:
Protocol: Email
Endpoint: Enter your email address
Create subscription
Check your email for the slacknews confirmation email.
It might take a few minutes for you to receive an email.

Choose the Confirm subscription link in the slacknews email to confirm the subscription.


Task 4: Create a Lambda Function
AWS Lambda lets you run code without provisioning or managing servers. You pay only for the compute time you consume - there is no charge when your code is not running. With Lambda, you can run code for virtually any type of application or backend service - all with zero administration. Just upload your code and Lambda takes care of everything required to run and scale your code with high availability. You can set up your code to automatically trigger from other AWS services or call it directly from any web or mobile app.

In this task, you will create a Lambda function from a blueprint that posts notifications to Slack, based on your SNS topic.

At the top of the page, in the unified search bar, search for and choose Lambda.

Choose Create function

Choose Use a blueprint.

 Blueprints are sample configurations of event sources and Lambda functions that do minimal processing for you, then customize it as needed. When you create a new AWS Lambda function, you can use a blueprint that best aligns with your scenario. There are several Slack bot blueprints available, including functions that handle a Slack slash command and echo details back to the user, and an Amazon SNS trigger that sends CloudWatch alarm notifications to Slack.

In the Select blueprint section, enter and choose 

Send CloudWatch alarm notifications via SNS
Then configure:

Function name: 

Slackfunction
Execution role: Use an existing role
Existing role: lambda-role
This role was pre-created for you as part of the lab setup.

Scroll down to the SNS trigger section, then configure:
SNS topic: slacknews
In the Environment variables section (at the bottom), enter these values:
slackChannel: Enter the channel name you defined earlier, which was: 

#general
kmsEncryptedHookUrl: Enter the Integration Webhook you copied to your text editor earlier in the lab
 You can normally encrypt the URL for added security, but it is not necessary for this lab.

Choose Create function.

In the Function code section below, select lambda_fucntion.py and delete all of the code in the code window.

Copy the Python code below and paste it into the Lambda code window.

```
import boto3
import json
import logging
import os

from base64 import b64decode
from urllib.request import Request, urlopen
from urllib.error import URLError, HTTPError

HOOK_URL = os.environ['kmsEncryptedHookUrl']
SLACK_CHANNEL = os.environ['slackChannel']

logger = logging.getLogger()
logger.setLevel(logging.INFO)

def lambda_handler(event, context):
    logger.info("Event: " + str(event))
    message = event['Records'][0]['Sns']['Message']
    logger.info("Message: " + str(message))

    alarm_name = message['AlarmName']
    new_state = message['NewStateValue']
    reason = message['NewStateReason']

    slack_message = {
        'channel': SLACK_CHANNEL,
        'text': "%s state is now %s: %s" % (alarm_name, new_state, reason)
    }

    req = Request(HOOK_URL, json.dumps(slack_message).encode('utf-8'))
    try:
        response = urlopen(req)
        response.read()
        logger.info("Message posted to %s", slack_message['channel'])
    except HTTPError as e:
        logger.error("Request failed: %d %s", e.code, e.reason)
    except URLError as e:
        logger.error("Server connection failed: %s", e.reason)
```


## 5: Test your Lambda function
In this task, you test the Lambda function.

Choose the Test tab.

n the Test event section, configure:

Event name: 

SlackEvent
Template: Search for and select: 

SNS Topic Notification
Delete all of the code in the window.

Copy the JSON code snipit below into the code window.


```
{
  "Records": [
    {
      "EventVersion": "1.0",
      "EventSubscriptionArn": "arn:aws:sns:EXAMPLE",
      "EventSource": "aws:sns",
      "Sns": {
        "SignatureVersion": "1",
        "Timestamp": "1970-01-01T00:00:00.000Z",
        "Signature": "EXAMPLE",
        "SigningCertUrl": "EXAMPLE",
        "MessageId": "95df01b4-ee98-5cb9-9903-4c221d41eb5e",
        "Message": {
          "AlarmName": "SlackAlarm",
          "NewStateValue": "OK",
          "NewStateReason":"Threshold Crossed: 1 datapoint (0.0) was not greater than or equal to the threshold (1.0)."
        },
        "MessageAttributes": {
          "Test": {
            "Type": "String",
            "Value": "TestString"
          },
          "TestBinary": {
            "Type": "Binary",
            "Value": "TestBinary"
          }
        },
        "Type": "Notification",
        "UnsubscribeUrl": "EXAMPLE",
        "TopicArn": "arn:aws:sns:EXAMPLE",
        "Subject": "TestInvoke"
      }
    }
  ]
}

```

Look at the code that you just pasted into the window.
You can see that “AlarmName” in the JSON code is “SlackAlarm”. You will create this alarm in the next part of the lab.

Choose `Save`
 Sample output:

 The test event SlackEvent was successfully saved.

Choose `Test`
You should see  Execution results: succeeded (log)


## 6: Create a CloudWatch Alarm
In this task you will create a CloudWatch alarm to notify your SNS topic when the alarm is triggered.

Amazon CloudWatch is a monitoring service for AWS cloud resources and the applications you run on AWS. You can use Amazon CloudWatch to collect and track metrics, collect and monitor log files, set alarms, and automatically react to changes in your AWS resources. Amazon CloudWatch can monitor AWS resources such as Amazon EC2 instances, Amazon DynamoDB tables, and Amazon RDS DB instances, as well as custom metrics generated by your applications and services, and any log files your applications generate. You can use Amazon CloudWatch to gain system-wide visibility into resource utilization, application performance, and operational health. You can use these insights to react and keep your application running smoothly.

At the top of the page, in the unified search bar, search for and choose CloudWatch.

In left navigation pane, choose Alarms and then All Alarms.

Select Create alarm.

Choose Select metric

Under Metrics, select `Lambda`.

Select `Across All Functions`.

Select  `Errors`.

Choose `Select metric`

Under Specify metric and conditions, configure:

Statistic: `Sum`
Period: `1 Minute`
Scroll down to the Conditions section, configure:
Whenever Error is… select  `Greater/Equal`
than: enter `1`
Choose `Next`

For Notification, configure:

Alarm state trigger: choose  `OK`
Choose  `Select an existing SNS topic`
Send a notification to: select `slacknews`
Choose `Next`

Alarm name enter `SlackAlarm`

Alarm Description enter `SlackAlarm`

Choose Next

Choose Create alarm


## 7: Test your chat bot
In this task, you test the Lambda funtion and validate a message is sent through the chat bot to your slack account.

At the top of the page, in the unified search bar, search for and choose Lambda.

Choose Slackfunction.

Choose Test

View the log messages.

An SNS notification has been sent to your email address and your chat bot has posted the notification in your Slack Channel.
Return to the web browser tab/window with Slack. Load 

https://<your-team-domain>.slack.com/messages
 then select your channel to see the notifications.

 --------
![congrat](./congrat.jpeg "Noice")
