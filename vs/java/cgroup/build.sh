#javac CgroupConfigPrinter.java
javac -source 1.8 -target 1.8  CgroupConfigPrinter.java
jar cvfm application.jar manifest.txt CgroupConfigPrinter.class

#test it on host
java -jar application.jar