```bash
docker build -t s50600822/memory-usage:node .

k apply -f mserver.yaml

k apply -f wasted.yml

```

it should be killed by container runtime (containerd), then k8s comes and replaced the status with Crashbackloop (the OOMKilled status will be replaced with Crashbackloop ).
If no other monitoring were there to record the OOM moment and nobody sees when it happens, like below(last until K8S perform the check and replaced status = Crashbackloop):
```bash
NAME                                       READY   STATUS      RESTARTS      AGE
memory-usage-deployment-7d787c4d74-krs4n   0/1     OOMKilled   1 (10s ago)   39s
```
it may not be obvious why the pod is in Crashbackloop state since there is no k8s event to record the observation of OOMKilled(refer to k8s code below).

clean up
```bash
k delete deployment memory-usage-deployment -n musage
```



https://github.com/kubernetes/kubernetes/commit/4e20a8f52bcce054459f4df537c12e889a02b86c

https://github.com/kubernetes/kubernetes/blob/3ec6a387955b1240ad6d795663513f1ee12ceaec/pkg/kubelet/kuberuntime/helpers.go#L159