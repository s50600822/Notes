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