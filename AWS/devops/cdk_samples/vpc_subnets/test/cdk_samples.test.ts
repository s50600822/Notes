import { Capture, Match, Template } from "aws-cdk-lib/assertions";
import * as cdk from "aws-cdk-lib";
import { CdkSamplesStack } from "../lib/cdk_samples-stack";

describe("StateMachineStack", () => {
  test("synthesizes the way we expect", () => {
    const app = new cdk.App();
    // Create the StateMachineStack.
    const stateMachineStack = new CdkSamplesStack(app, "StateMachineStack", {
      //vpc: vpc
    });

    // Prepare the stack for assertions.
    const template = Template.fromStack(stateMachineStack);}
  )}
);