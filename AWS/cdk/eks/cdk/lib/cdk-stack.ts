import * as cdk from 'aws-cdk-lib';
import { Construct } from 'constructs';
import * as eks from 'aws-cdk-lib/aws-eks';

export class CdkStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);

    const cluster = new eks.Cluster(this, 'hello-eks', {
          version: eks.KubernetesVersion.V1_24,
          albController: {
            version: eks.AlbControllerVersion.V2_4_1
          },
        });
  }
}
