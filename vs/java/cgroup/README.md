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

# GOOD, since JDK 11.  Also mentioned in https://kubernetes.io/docs/concepts/architecture/cgroups/
./runWithDocker.sh
Available Processor Count: 2
Available Memory (Total): 247 MB
Available Memory (Free): 242 MB
Maximum Memory (Allocated): 247 MB
Total System Memory: 512 MB
```


### Try all JDK versions if curious
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

while openjdk stop publishing jdk 8 images after
```bash
docker run --rm --cpus=2 --memory=512m --name jvm_cgroup_demo_openjdk9  -v .:/app openjdk:8  java -version
openjdk version "1.8.0_342"
OpenJDK Runtime Environment (build 1.8.0_342-b07)
OpenJDK 64-Bit Server VM (build 25.342-b07, mixed mode)
```

Fixes continues to be ported into jdk8 later builds and distributor like Amazon continue to publish new imgs with fixes
```bash
# BAD still
docker run --rm --cpus=2 --memory=512m --name amazoncorretto8u352 -v .:/app amazoncorretto:8u352 java -Xmx256m -Xms256m  -jar /app/application.jar
docker run --rm --cpus=2 --memory=512m --name amazoncorretto8u362 -v .:/app amazoncorretto:8u362  java -Xmx256m -Xms256m  -jar /app/application.jar

# GOOD
docker run --rm --cpus=2 --memory=512m --name amazoncorretto8u372 -v .:/app amazoncorretto:8u372  java -Xmx256m -Xms256m  -jar /app/application.jar
docker run --rm --cpus=2 --memory=512m --name amazoncorretto8u382 -v .:/app amazoncorretto:8u382  java -Xmx256m -Xms256m  -jar /app/application.jar
docker run --rm --cpus=2 --memory=512m --name amazoncorretto8u402 -v .:/app amazoncorretto:8u402  java -Xmx256m -Xms256m  -jar /app/application.jar
```


## Other languages
### golang
```go
//sys.go
package main

import (
	"fmt"
	"runtime"

	"github.com/shirou/gopsutil/mem"
)

func main() {
	availableProcessors := runtime.NumCPU()
	fmt.Println("Available Processor Count:", availableProcessors)
	memInfo, err := mem.VirtualMemory()
	if err != nil {
		panic(err)
	}
	totalMemoryMB := memInfo.Total / 1024 / 1024
	freeMemoryMB := memInfo.Free / 1024 / 1024
	fmt.Println("Available Memory (Total):", totalMemoryMB, "MB")
	fmt.Println("Available Memory (Free):", freeMemoryMB, "MB")
}


```

to build

```bash
go mod init sys
go get github.com/shirou/gopsutil/mem
go build sys.go
go run sys.go
Available Processor Count: 10
Available Memory (Total): 32768 MB
Available Memory (Free): 142 MB
```


does not honor cgroup, notice that `Available Processor Count` and `Available Memory` are exactly like running directly on host/node. The same actually goes for `Available Memory`, it slightly fluctuates around that value when you run again and again on the host or inside the container.
```bash
docker run --cpus=2 --memory=512m --rm -v .:/app -w /app golang:1.22.0  go build && go run sys.go

go: downloading github.com/shirou/gopsutil v3.21.11+incompatible
go: downloading golang.org/x/sys v0.17.0
Available Processor Count: 10
Available Memory (Total): 32768 MB
Available Memory (Free): 199 MB
```


### Node
```javascript
// sys.js
const os = require('os');

const availableProcessors = os.cpus().length;
console.log("Available Processor Count: " + availableProcessors);

const totalMemoryMB = Math.round(os.totalmem() / (1024 * 1024));
const freeMemoryMB = Math.round(os.freemem() / (1024 * 1024));
console.log("Available Memory (Total): " + totalMemoryMB + " MB");
console.log("Available Memory (Free): " + freeMemoryMB + " MB");


const totalSystemMemoryMB = Math.round(os.totalmem() / (1024 * 1024));
console.log("Total System Memory: " + totalSystemMemoryMB + " MB");

```

does not honor cgroup
```bash
docker run --rm --cpus=2 --memory=512m -v ./:/usr/src/app -w /usr/src/app node:21.6.2-slim node sys.js

Available Processor Count: 10
Available Memory (Total): 7941 MB
Available Memory (Free): 5927 MB
Total System Memory: 7941 MB
```


### Csharp
```c#
using System;
using System.IO;

namespace App {
    class Program {
        static void Main(string[] args) {
            PrintSystemInfo();
        }

        static void PrintSystemInfo() {
            Console.WriteLine("System Information:");
            Console.WriteLine("-------------------");

            Console.WriteLine("CPU:");
            int coreCount = Environment.ProcessorCount;
            Console.WriteLine($"  Number of Cores: {coreCount}");

            Console.WriteLine("\nMemory:");
            if (File.Exists("/proc/meminfo")) {
                string[] lines = File.ReadAllLines("/proc/meminfo");
                foreach (string line in lines) {
                    string[] parts = line.Split(':');
                    if (parts.Length == 2) {
                        string name = parts[0].Trim();
                        string value = parts[1].Trim();

                        if (name == "MemTotal" || name == "MemFree") {
                            long memoryKiB = long.Parse(value.Split(' ')[0]);
                            double memoryMiB = memoryKiB / 1024.0;
                            Console.WriteLine($"  {name}: {memoryMiB:F2} MiB");
                        }
                    }
                }
            } else {
                Console.WriteLine("Memory information retrieval is not supported on this platform.");
            }
        }
    }
}

```

test
```bash
docker run --cpus=2 --memory=512m  s50600822/cgroupcheck:csharp

System Information:
-------------------
CPU:
  Number of Cores: 2

Memory:
  MemTotal: 7841.18 MiB
  MemFree: 5416.21 MiB
```

### See also

https://github.com/s50600822/Notes/wiki/Cgroup

https://kubernetes.io/docs/concepts/architecture/cgroups/

https://github.com/containerd/cgroups

https://github.com/KimMachineGun/automemlimit

https://github.com/google/cadvisor

https://github.com/kubernetes/kubernetes/commit/4e20a8f52bcce054459f4df537c12e889a02b86c
