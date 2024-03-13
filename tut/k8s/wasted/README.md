```bash
docker build -t s50600822/memory-usage:node .

k apply -f mserver.yaml

k apply -f wasted.yml

```

it should be killed by container runtime (containerd), then k8s comes and replaced the status with Crashbackloop (the OOMKilled status will be replaced with Crashbackloop ).
If no other monitoring were there to record the OOM moment and nobody sees when it happens, k8s will attempt to restart it and erase the fact it was OOMKilled:
```bash
kubectl get pods -w

NAME                                       READY   STATUS    RESTARTS   AGE
memory-usage-deployment-7d787c4d74-9qbxt   1/1     Running   0          31s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     OOMKilled   0          43s
memory-usage-deployment-7d787c4d74-9qbxt   1/1     Running     1 (1s ago)   44s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     OOMKilled   1 (87s ago)   2m10s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     CrashLoopBackOff   1 (16s ago)   2m26s
memory-usage-deployment-7d787c4d74-9qbxt   1/1     Running            2 (17s ago)   2m27s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     OOMKilled          2 (64s ago)   3m14s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     CrashLoopBackOff   2 (14s ago)   3m27s
memory-usage-deployment-7d787c4d74-9qbxt   1/1     Running            3 (25s ago)   3m38s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     OOMKilled          3 (66s ago)   4m19s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     CrashLoopBackOff   3 (15s ago)   4m33s
memory-usage-deployment-7d787c4d74-9qbxt   1/1     Running            4 (51s ago)   5m9s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     OOMKilled          4 (55s ago)   5m13s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     CrashLoopBackOff   4 (14s ago)   5m27s
memory-usage-deployment-7d787c4d74-9qbxt   1/1     Running            5 (92s ago)   6m45s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     OOMKilled          5 (2m11s ago)   7m24s
memory-usage-deployment-7d787c4d74-9qbxt   0/1     CrashLoopBackOff   5 (12s ago)     7m35s
memory-usage-deployment-7d787c4d74-9qbxt   1/1     Running            6 (2m45s ago)   10m
```
it may not be obvious why the pod is in Crashbackloop state since there is no k8s event to record the observation of OOMKilled(refer to k8s code below). The status visible here because:
- this is a watch command
- the cycle of OOM is short, a few min, because the app and deployment cfg do this on purpose

```bash
kubectl get events --sort-by='{.lastTimestamp}'

LAST SEEN   TYPE      REASON              OBJECT                                          MESSAGE
14m         Normal    Scheduled           pod/memory-usage-deployment-7d787c4d74-qwzhv    Successfully assigned musage/memory-usage-deployment-7d787c4d74-qwzhv to docker-desktop
9m8s        Normal    Scheduled           pod/memory-usage-deployment-7d787c4d74-9qbxt    Successfully assigned musage/memory-usage-deployment-7d787c4d74-9qbxt to docker-desktop
14m         Normal    ScalingReplicaSet   deployment/memory-usage-deployment              Scaled up replica set memory-usage-deployment-7d787c4d74 to 1
14m         Normal    SuccessfulCreate    replicaset/memory-usage-deployment-7d787c4d74   Created pod: memory-usage-deployment-7d787c4d74-qwzhv
11m         Warning   BackOff             pod/memory-usage-deployment-7d787c4d74-qwzhv    Back-off restarting failed container memory-usage-container in pod memory-usage-deployment-7d787c4d74-qwzhv_musage(09ad31ca-7e4a-43a0-bc67-37bd7e7fd9f4)
10m         Normal    Pulled              pod/memory-usage-deployment-7d787c4d74-qwzhv    Container image "s50600822/memory-usage:node" already present on machine
10m         Normal    Created             pod/memory-usage-deployment-7d787c4d74-qwzhv    Created container memory-usage-container
10m         Normal    Started             pod/memory-usage-deployment-7d787c4d74-qwzhv    Started container memory-usage-container
9m41s       Normal    Killing             pod/memory-usage-deployment-7d787c4d74-qwzhv    Stopping container memory-usage-container
9m8s        Normal    SuccessfulCreate    replicaset/memory-usage-deployment-7d787c4d74   Created pod: memory-usage-deployment-7d787c4d74-9qbxt
9m8s        Normal    ScalingReplicaSet   deployment/memory-usage-deployment              Scaled up replica set memory-usage-deployment-7d787c4d74 to 1
3m59s       Normal    Started             pod/memory-usage-deployment-7d787c4d74-9qbxt    Started container memory-usage-container
3m59s       Normal    Created             pod/memory-usage-deployment-7d787c4d74-9qbxt    Created container memory-usage-container
3m59s       Normal    Pulled              pod/memory-usage-deployment-7d787c4d74-9qbxt    Container image "s50600822/memory-usage:node" already present on machine
3m19s       Warning   BackOff             pod/memory-usage-deployment-7d787c4d74-9qbxt    Back-off restarting failed container memory-usage-container in pod memory-usage-deployment-7d787c4d74-9qbxt_musage(16206b48-d677-4371-a01d-7d4b9af68af8)
```

clean up
```bash
k delete deployment memory-usage-deployment -n musage
```



https://github.com/kubernetes/kubernetes/commit/4e20a8f52bcce054459f4df537c12e889a02b86c

https://github.com/kubernetes/kubernetes/blob/3ec6a387955b1240ad6d795663513f1ee12ceaec/pkg/kubelet/kuberuntime/helpers.go#L159