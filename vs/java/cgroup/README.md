With
```bash
docker run --rm --cpus=2  ....
```

This show the bug in JDK 8 where jvm doesn't respect cgroup limit(JDK 8 vs JDK 21):
```bash
# BAD
 ./runWithDockerJ8.sh
Available Processor Count: 10
Available Memory (Total): 245 MB
Available Memory (Free): 242 MB
Maximum Memory (Allocated): 245 MB

# GOOD
./runWithDocker.sh
Available Processor Count: 2
Available Memory (Total): 247 MB
Available Memory (Free): 242 MB
Maximum Memory (Allocated): 247 MB
```