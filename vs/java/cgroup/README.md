With
```bash
docker run --rm --cpus=2  ....
```

Inside the container, CPU limit can be checked by
```bash
cat /sys/fs/cgroup/cpu.max
200000 100000
```

`cpu.max` is a file within the cgroup filesystem (/sys/fs/cgroup) that specifies the maximum CPU quota and period for the cgroup. For example here:

- The first value `200000` represents the CPU quota, measured in microseconds. This value indicates the maximum amount of CPU time that the cgroup is allowed to use within a specific period.

- The second value `100000` represents the CPU period, also measured in microseconds. This value defines the duration of the period during which the CPU quota is enforced.



This show the bug in JDK 8 where jvm doesn't respect cgroup limit(JDK 8 vs JDK 21):
```bash
# BAD, notice CPU -> 10 and system mem=7940 MB, contrary to the limits we give the container
 ./runWithDockerJ8.sh
Available Processor Count: 10
Available Memory (Total): 245 MB
Available Memory (Free): 242 MB
Maximum Memory (Allocated): 245 MB
Total System Memory: 7940 MB

# GOOD, since JDK 11
./runWithDocker.sh
Available Processor Count: 2
Available Memory (Total): 247 MB
Available Memory (Free): 242 MB
Maximum Memory (Allocated): 247 MB
Total System Memory: 512 MB
```


# try all if curious
```bash
# BAD 
docker run --rm --cpus=2 --memory=512m --name jvm_cgroup_demo_openjdk8 -v .:/app openjdk:8  java -Xmx256m -Xms256m  -jar /app/application.jar
docker run --rm --cpus=2 --memory=512m --name jvm_cgroup_demo_openjdk9 -v .:/app openjdk:9  java -Xmx256m -Xms256m  -jar /app/application.jar
docker run --rm --cpus=2 --memory=512m --name jvm_cgroup_demo_openjdk10 -v .:/app openjdk:10  java -Xmx256m -Xms256m  -jar /app/application.jar
# GOOD
docker run --rm --cpus=2 --memory=512m --name jvm_cgroup_demo_openjdk11 -v .:/app openjdk:11  java -Xmx256m -Xms256m  -jar /app/application.jar
docker run --rm --cpus=2 --memory=512m --name jvm_cgroup_demo_openjdk16 -v .:/app openjdk:16  java -Xmx256m -Xms256m  -jar /app/application.jar
docker run --rm --cpus=2 --memory=512m --name jvm_cgroup_demo_openjdk17 -v .:/app openjdk:17  java -Xmx256m -Xms256m  -jar /app/application.jar
docker run --rm --cpus=2 --memory=512m --name jvm_cgroup_demo_openjdk21 -v .:/app openjdk:21  java -Xmx256m -Xms256m  -jar /app/application.jar
```