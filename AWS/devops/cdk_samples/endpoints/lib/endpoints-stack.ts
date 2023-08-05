import * as cdk from 'aws-cdk-lib';
import * as ec2 from 'aws-cdk-lib/aws-ec2';
import { Construct } from 'constructs';

const VPC = process.env.DEF_VPC_ID || '';
const SN = process.env.DEF_SUBNET_ID || '';
const REGION = process.env.REGION || '';
const ACC_ID = process.env.ACC_ID || '';

export class EndpointsStack extends cdk.Stack {
  constructor(scope: Construct, id: string, props?: cdk.StackProps) {
    super(scope, id, props);
    console.log('VPC 👉', VPC);
    console.log('SN 👉', SN);
    console.log('REGION 👉', REGION);
    console.log('ACC_ID 👉', ACC_ID);
    const vpc = ec2.Vpc.fromLookup(this, VPC, {
      vpcId: VPC,
      isDefault: true,
      region: REGION,
      ownerAccountId: ACC_ID
    });

    const sg = ec2.SecurityGroup.fromSecurityGroupId(this, 'SG', VPC);
    /*
    const privateSubnets = vpc.selectSubnets({
      subnetType: ec2.SubnetType.PUBLIC,
    });
    */

    const sf =  ec2.SubnetFilter.byIds([SN]);
    const selectedSubnets = vpc.selectSubnets({
      subnetFilters: [sf],
    });

    const vpceEC2 = vpc.addInterfaceEndpoint('vpce-ec2', {
      service: ec2.InterfaceVpcEndpointAwsService.EC2,
      lookupSupportedAzs: true,
      open: true,
      privateDnsEnabled: true,
      subnets:selectedSubnets
    });

    const vpceSSM = vpc.addInterfaceEndpoint('vpce-ssm', {
      service: ec2.InterfaceVpcEndpointAwsService.SSM,
      lookupSupportedAzs: true,
      open: true,
      privateDnsEnabled: true,
      subnets:selectedSubnets
    });

    const vpceSSMC = vpc.addInterfaceEndpoint('vpce-ssc', {
      service: ec2.InterfaceVpcEndpointAwsService.SSM_CONTACTS,
      lookupSupportedAzs: true,
      open: true,
      privateDnsEnabled: true,
      subnets:selectedSubnets
    });

    const vpceSSMM = vpc.addInterfaceEndpoint('vpce-ssmm', {
      service: ec2.InterfaceVpcEndpointAwsService.SSM_MESSAGES,
      lookupSupportedAzs: true,
      open: true,
      privateDnsEnabled: true,
      subnets:selectedSubnets
    });

    const vpceSSMI = vpc.addInterfaceEndpoint('vpce-ssmi', {
      service: ec2.InterfaceVpcEndpointAwsService.SSM_INCIDENTS,
      lookupSupportedAzs: true,
      open: true,
      privateDnsEnabled: true,
      subnets:selectedSubnets
    });
  }
}
