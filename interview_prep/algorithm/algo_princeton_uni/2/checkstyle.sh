# Replace tab with space
# sed 's/\t/     /g'  Percolation.java > Percolation.java
# sed 's/\t/     /g'  PercolationStats.java > PercolationStats.java

java -jar checkstyle-10.12.1-all.jar -c google_checks.xml *.java