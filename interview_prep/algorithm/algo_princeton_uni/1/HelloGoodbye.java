import edu.princeton.cs.algs4.StdOut;

public class HelloGoodbye {

    public static void main(String[] args) {

        // I'm ignoring null, len after split != 2 and other bs!
        // bite me!
        // String in = StdIn.readLine();
        // String[] names = in.split(" ");
        StdOut.println(String.format("Hello %s and %s.", args[0], args[1]));
        StdOut.println(String.format("Goodbye %s and %s.", args[1], args[0]));
    }

}
