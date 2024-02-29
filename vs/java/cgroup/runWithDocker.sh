docker run --rm --cpus=2 --memory=256m --name jvm_cgroup_demo_openjdk21 -v .:/app openjdk:21  java -Xmx256m -Xms256m  -jar /app/application.jar
