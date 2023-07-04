# https://coursera.cs.princeton.edu/algs4/assignments/percolation/specification.php

javac -cp .:algs4.jar Percolation.java
javac -cp .:algs4.jar PercolationStats.java

# Submit a .zip file containing only Submit only Percolation.java (using the weighted quick-union algorithm from WeightedQuickUnionUF) and PercolationStats.java. We will supply algs4.jar. Your submission may not call library functions except those in StdIn, StdOut, StdRandom, StdStats, WeightedQuickUnionUF, and java.lang.
zip "percolation_$(date +%Y%m%d%H%M%S).zip" Percolation.java PercolationStats.java