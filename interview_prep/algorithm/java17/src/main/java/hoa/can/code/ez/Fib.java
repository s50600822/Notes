package hoa.can.code.ez;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Fib {
    private int last=0, next =1;
    public IntStream stream(){
       return IntStream.generate(()->{
        int tmp = last;
        last = next;
        next = tmp + next;
        return tmp;
       });
       
    }

    public int fib(int n){
        stream()
        .limit(n)
        .forEachOrdered(System.out::println);
        java.util.List<Integer> fibs = new Fib().stream()
        .limit(n)
        .boxed()
        .collect(Collectors.toList());  
        return fibs.get(fibs.size()-1);       
    }
}