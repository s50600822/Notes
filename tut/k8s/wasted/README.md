```bash
docker build -t s50600822/memory-usage:node .

k apply -f mserver.yaml

k apply -f wasted.yml

```

it should be killed and an attempt to restart will occur, then CrashLoopBackOff
```bash
NAME                                       READY   STATUS      RESTARTS      AGE
memory-usage-deployment-7d787c4d74-krs4n   0/1     OOMKilled   1 (10s ago)   39s
```


clean up
```bash
k delete deployment memory-usage-deployment -n musage
```



https://github.com/kubernetes/kubernetes/commit/4e20a8f52bcce054459f4df537c12e889a02b86c
