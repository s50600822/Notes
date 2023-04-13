package hoa.can.code.diff;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindAllAnagramsInAString {
    public List<Integer> findAnagrams4(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] count = new int[128];
        int required = p.length();

        for (final char c : p.toCharArray())
            ++count[c];

        for (int l = 0, r = 0; r < s.length(); ++r) {
            if (--count[s.charAt(r)] >= 0){
                --required;
            }
            while (required == 0) {
                if (r - l + 1 == p.length()){
                    ans.add(l);
                }
                if (++count[s.charAt(l++)] > 0){
                    ++required;
                }
            }
        }

        return ans;
    }
    public List<Integer> findAnagrams(String s, String p) {
        if(s == null || s.isBlank() || p == null || p.isEmpty()){
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();

        int[] freq = new int[26];
        for(char c: p.toCharArray()){
            freq[c-'a']++;
        }


        int left = 0, right =0, count = p.length();

        while(right< s.length()){
            int rightBound = s.charAt(right) - 'a';
            if(freq[rightBound] >= 1){
                count --;
            }
            freq[rightBound]--;
            right++;
            if(count == 0){
                res.add(left);
            }
            if(right - left ==p.length()){
                if(freq[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                freq[s.charAt(left)-'a']++;
                left++;
            }
        }
        return res;
    }
    public List<Integer> findAnagrams6(String s, String p) {
        if(s == null || s.isBlank() || p == null || p.isEmpty()){
            return Collections.emptyList();
        }
        List<Integer> res = new ArrayList<>();

        int[] freq = new int[26];
        for(char c: p.toCharArray()){
            freq[c-'a']++;
        }


        int left = 0, right =0, count = p.length();

        while(right< s.length()){
            int rightBound = s.charAt(right) - 'a';
            if(freq[rightBound] >= 1){
                count --;
            }
            freq[rightBound]--;
            right++;
            if(count == 0){
                res.add(left);
            }
            if(right - left ==p.length()){
                if(freq[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                freq[s.charAt(left)-'a']++;
                left++;
            }
        }
        return res;
    }
    public List<Integer> findAnagrams2(String s, String p) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0) {
            return result;
        }

        // Create a frequency map of characters in pattern string p
        int[] freq = new int[26];
        for(char c : p.toCharArray()) {
            freq[c - 'a']++;
        }

        int left = 0;
        int right = 0;
        int count = p.length();

        // Slide a window of size p.length() over string s
        while(right < s.length()) {
            // If the character at right pointer is in pattern string p, decrement count
            int rchar = s.charAt(right) - 'a';
            if(freq[rchar] >= 1) {
                count--;
            }
            freq[rchar]--;
            right++;

            // If count becomes 0, it means we have found an anagram of pattern string p
            if(count == 0) {result.add(left);}

            // If the window size is equal to pattern string p, slide the window to the right
            if(right - left == p.length()) {
                // If the character at left pointer is in pattern string p, increment count
                if(freq[s.charAt(left) - 'a'] >= 0) {
                    count++;
                }
                freq[s.charAt(left) - 'a']++;
                left++;
            }
        }
        return result;
    }
}
