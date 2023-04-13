package hoa.can.code.ez;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/longest-palindrome/
public class LongestPalindrome {
    public int solve(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int count = 0;
        int odd = 0;
        if(s.length() == 0) return 0;

        for(int i = 0; i < s.length() ; i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                map.put(c , map.get(c) + 1);
            }
            else map.put(c,1);
        }

        for(int frequency : map.values()){
            if(frequency % 2 == 0){
                count += frequency;
            } else{
                //if(frequency > odd) odd = frequency;
                count += frequency -1;
                odd =1;
            }
        }
        return count + odd;
    }

    public int solve2(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Map<Character, Integer> freqMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }

        int length = 0;
        boolean hasOddFreq = false;
        for (int freq : freqMap.values()) {
            if (freq % 2 == 0) {
                length += freq;
            } else {
                length += freq - 1;
                hasOddFreq = true;
            }
        }

        if (hasOddFreq) {
            length++;
        }

        return length;
    }
}
