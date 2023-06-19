### setup project
install [yq](https://github.com/mikefarah/yq)
install [cdk](https://github.com/aws/aws-cdk)
install [cdk8s](https://github.com/cdk8s-team/cdk8s)


```
npm install -g cdk8s-cli
mkdir cdk && cd cdk

#bin/cdk.ts is entrypoint
#lib/cdk-stack.ts is where most of the code will be
```

### adding eks:
```
import * as eks from 'aws-cdk-lib/aws-eks';

const cluster = new eks.Cluster(this, 'hello-eks', {
      version: eks.KubernetesVersion.V1_24,
      albController: {
        version: eks.AlbControllerVersion.V2_4_1
      },
    });
```

resources can be listed by: `cat node_modules/aws-cdk/lib/api/bootstrap/bootstrap-template.yaml | yq '.Resources[].Type'`



```
cdk bootstrap
cat cdk.out/CdkStack.template.json | jq '.Resources[]|select(.Type=="AWS::EKS::Nodegroup")'
cdk deploy

```

inspect cluster
```
aws eks update-kubeconfig --name ... --region ...
```


### DEPLOY APP
#### create an app
```
mkdir cdk8s-app && cd cdk8s-app
cdk8s init typescript-app

```

#### some coding
```
//main.ts
import { Construct } from 'constructs';
import { App, Chart, ChartProps } from 'cdk8s';
import { KubeDeployment, KubeService, IntOrString } from "./imports/k8s";

export class MyChart extends Chart {
  constructor(scope: Construct, id: string, props: ChartProps = { }) {
    super(scope, id, props);

    // define resources here

  }
}

const app = new App();
new MyChart(app, 'hello');
app.synth();
```


#### build
```
npm run compile && cdk8s synth
```

#### dep
`kubectl apply -f dist/cdk8s-app.k8s.yaml`


#### check
`kubectl get service | awk '/cdk8s/ { print $4 }'`