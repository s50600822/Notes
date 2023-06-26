import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {

    public static void main(String[] args) {

        // I'm ignoring null, len after split != 2 and other bs!
        // bite me!
        String in = StdIn.readLine();
        String[] names = in.split(" ");
        StdOut.println(String.format("Hello %s and %s.", names[0], names[1]));
        StdOut.println(String.format("Goodbye %s and %s.", names[1], names[0]));
    }

}
