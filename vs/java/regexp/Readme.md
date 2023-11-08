
### 8.332.08.1-amzn, java 11.0.16-amzn, java 17.0.8-amzn, java 21-graalce
```
sdk use java 8.332.08.1-amzn
javac Reg.java && java Reg
time: false [22197 ms]

sdk use java 11.0.16-amzn
javac Reg.java && java Reg
time: false [5 ms]


sdk use java 17.0.8-amzn
javac Reg.java && java Reg
time: false [2 ms]


sdk use java 21-graalce
javac Reg.java && java Reg
time: false [0 ms]

```

### 21 Amaz vs 21 Graal native (nanosec scale)

```
Using java version 21-amzn in this shell.
[2295042 ns]
[2043833 ns]
[2035208 ns]
[2039458 ns]
[2123292 ns]
[2206541 ns]

graalvm native
[115458 ns]
[140333 ns]
[101666 ns]
[122791 ns]
[116959 ns]
[177125 ns]
[119584 ns]
```

### ref
https://kean.blog/post/regex-matcher
https://kean.blog/post/regex-matcher
https://algs4.cs.princeton.edu/54regexp/
https://querix.com/go/lycia/Content/06_reference/4gl/regular_expressions/regex_algorithms.htm
https://sedgewick.io/wp-content/uploads/2022/04/Algs20-RegularExpressions.pdf