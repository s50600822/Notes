BUILD_JDK='11.0.14.10.1-amzn'
RUN_JDK='17.0.2.8.1-amzn'

sdk use java $BUILD_JDK && javac Test.java
sdk use java $RUN_JDK && java -cp nashorn-core-15.4.jar:asm-9.1.jar:. Test

# eg
# sdk use java 11.0.14.10.1-amzn && javac Test.java
# sdk use java 17.0.2.8.1-amzn && java -cp nashorn-core-15.4.jar:asm-9.1.jar:. Test
