package hoa.can.code.ez;
import java.io.*;
import java.util.*;

/**
 *  https://www.hackerrank.com/challenges/apple-and-orange/problem
 *  why start is s and end is t?
 */
public class AppleAndOrange {
    public static void countApplesAndOranges(
        int s, 
        int t, 
        int a, 
        int b, 
        List<Integer> apples, 
        List<Integer> oranges) {
        //System.out.println(countF(s, t, a, apples));
        //System.out.println(countF(s, t, b, oranges));
    }

    public static long countF(        
        int s, 
        int t, 
        int idx, 
        List<Integer> f){
        long c =  f.stream()
        .map( pos -> (idx + pos))
        .filter(pos -> pos >= s && pos <= t)
        .count();
        return c;
    }
}
