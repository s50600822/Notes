import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {
  public static void main(String[] args) {
    int index = 0;
    String random = "";
    while (!StdIn.isEmpty()) {
      String word = StdIn.readString();
      if (StdRandom.bernoulli(1.0 / (index + 1.0))) {
        random = word;
      }
      index++;
    }
    StdOut.println(random);
  }
}