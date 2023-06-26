import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;


public class RandomWord {
    public static  void main(String[] args) {
        String in = StdIn.readLine();
        String[] words = in.split(" ");    
        String res = words[0];
        
        for(int i=1; i< words.length; i++){
            if(StdRandom.bernoulli(1/i)){
                res = words[i];
            }
        }    
        StdOut.println(res);
    }    
}