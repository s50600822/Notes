import * as cdk from 'aws-cdk-lib';
import * as lambda from 'aws-cdk-lib/aws-lambda';
import * as secretsmanager from 'aws-cdk-lib/aws-secretsmanager';
import * as iam from 'aws-cdk-lib/aws-iam';

export class HelloCdkStack extends cdk.Stack {
  constructor(scope: cdk.App, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    const hello = new lambda.Function(this, 'HelloHandler', {
      runtime: lambda.Runtime.NODEJS_16_X,    // execution environment
      code: lambda.Code.fromAsset('lambda'),  // code loaded from "lambda" directory
      handler: 'hello.handler'                // file is "hello", function is "handler"
    });

    const secret = new secretsmanager.Secret(this, 'FamilySec', {
      secretName: 'Nflx',
      generateSecretString: {
        secretStringTemplate: JSON.stringify({ username: 'myNetFlixUser' }),
        generateStringKey: 'netflixPass',
        excludePunctuation: true,
      },
    });

    const role = new iam.Role(this, 'Family', {
      assumedBy: new iam.AccountRootPrincipal(),
    });

    secret.grantRead(role); 
    secret.grantWrite(role);

  }
}