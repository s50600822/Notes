package hoa.can.code.ez;

import java.util.List;

//https://www.hackerrank.com/challenges/the-birthday-bar/problem?isFullScreen=true
public class BirthdayBar {
    public static int birthday(List<Integer> s, int d, int m)
    {
        int sum = 0;
        int count = 0;
        for (int i = 0; i < s.size(); i++){
            sum += s.get(i);
            if (i > m - 1){
                sum -= s.get(i-m);
            }
            if (sum == d && i > m - 2) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(birthday(List.of(1, 2, 1, 3, 2),3,2));
    }
}
