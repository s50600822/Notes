#!/usr/bin/env node
import * as cdk from 'aws-cdk-lib';
import { CdkSamplesStack } from '../lib/cdk_samples-stack';

const app = new cdk.App();
new CdkSamplesStack(app, 'CdkSamplesStack');
