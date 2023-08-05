import { Duration, Stack, StackProps } from 'aws-cdk-lib';
import * as ec2 from 'aws-cdk-lib/aws-ec2';
import { Construct } from 'constructs';



function addEC2s(vpc: ec2.Vpc, construct: Construct){
  const instanceProps: ec2.InstanceProps = {
    vpc,
    instanceType: new ec2.InstanceType('t2.micro'),
    machineImage: new ec2.AmazonLinuxImage()
  };

  new ec2.Instance(construct, 'EC2InSemiPrivateSubnet1', {
    ...instanceProps,
    vpcSubnets: { subnetType: ec2.SubnetType.PRIVATE_WITH_EGRESS }
  });

  new ec2.Instance(construct, 'EC2InPrivateSubnet1', {
    ...instanceProps,
    vpcSubnets: { subnetType: ec2.SubnetType.PRIVATE_ISOLATED }
  });

  new ec2.Instance(construct, 'EC2InPublicSubnet1', {
    ...instanceProps,
    vpcSubnets: { subnetType: ec2.SubnetType.PUBLIC }
  });
}

export class CdkSamplesStack extends Stack {
  constructor(scope: Construct, id: string, props?: StackProps) {
    super(scope, id, props);

    const vpc = new ec2.Vpc(this, 'my-awesome-vpc', {
      ipAddresses: ec2.IpAddresses.cidr('10.0.0.0/16'),
      natGateways: 1,
      maxAzs: 3,
      subnetConfiguration: [
        {
          name: 'semi-private-subnet-1',
          subnetType: ec2.SubnetType.PRIVATE_WITH_EGRESS,
          cidrMask: 24,
        },
        {
          name: 'public-subnet-1',
          subnetType: ec2.SubnetType.PUBLIC,
          cidrMask: 24,
        },
        {
          name: 'private-subnet-1',
          subnetType: ec2.SubnetType.PRIVATE_ISOLATED,
          cidrMask: 28,
        },
      ],
    });
    addEC2s(vpc, this);
  }
}
