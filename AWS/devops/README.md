## Associate new code commit with Approval template
On Codecommit repo creation, associate the repo with Approval rule.
https://jam.awsevents.com/campaigns/aws-jam-journey-devops/jamjourneydevopsre/challenges/codecommit-pullrequest-control

### Lambda
```
import boto3
from botocore.exceptions import ClientError
import json
client = boto3.client('codecommit')
def lambda_handler(event, context):
    print(event)
    try:
        client.associate_approval_rule_template_with_repository(approvalRuleTemplateName='PROD_APPROVAL_TEMPLATE'repositoryName=event['detail']['requestParameters']['repositoryName'])
    except ClientError as err:
        print("Unexpected error in associating approval flow template with repository %s" % err)

```

### EventBridge Rule
ApprovalFlowEventTriggerForNewRepo

#### Sample Event
```
{
  "version": "0",
  "id": "01234567-0123-0123-0123-012345678901",
  "detail-type": "CodeCommit Repository State Change",
  "source": "aws.codecommit",
  "account": "123456789012",
  "time": "2017-06-12T10:23:43Z",
  "region": "us-east-1",
  "resources": ["arn:aws:codecommit:us-east-1:123456789012:myRepo"],
  "detail": {
    "event": "referenceCreated",
    "repositoryName": "myRepo",
    "repositoryId": "12345678-1234-5678-abcd-12345678abcd",
    "referenceType": "tag",
    "referenceName": "myTag",
    "referenceFullName": "refs/tags/myTag",
    "commitId": "3e5983EXAMPLE"
  }
}
```

#### Input Transformer
##### Input Path
```
{
  "id": "$.id",
  "detail-type": "$.detail-type",
  "source": "$.source",
  "repo": "$.detail.repositoryName",
  "eventTime": "$.time"
}
```

##### Template

```
{
  "version": "0",
   "id": "<id>",
   "detail-type": "<detail-type>",
   "source":"<source>",
   "detail": {
         "eventTime": "<eventTime>",
         "eventSource": "codecommit.amazonaws.com",
         "eventName": "CreateRepository",
         "requestParameters": {
            "repositoryName": "<repo>"
         },
         "eventType": "AwsApiCall"
     }
}
```

```
{
 "version": "0",
 "id": "36eb8523-97d0-4518-b33d-ee3579ff19f0",
 "detail-type": "AWS API Call via CloudTrail",
 "source": "aws.codecommit",
 "detail": {
         "eventTime": "2016-02-20T01:09:13Z",
         "eventSource": "codecommit.amazonaws.com",
         "eventName": "CreateRepository",
         "requestParameters": {
            "repositoryName": ""
         },
         "eventType": "AwsApiCall"
     }
 }
```


to switch to ec2-user
```
sudo su ec2-user
```