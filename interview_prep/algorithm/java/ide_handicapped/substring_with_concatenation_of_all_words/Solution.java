import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;

class Solution {
    public static List<Integer> findSubString(String s, String[] words){
        List<Integer> result = new ArrayList<>();

        if(null == s|| s.length() == 0 || null == words || words.length == 0){
            return result;
        }
        int wlen = words[0].length();// precondition: all words are of the same leng
        int wcount = words.length;
        int totalL = wcount*wlen;
        Map<String, Integer> wMap = new HashMap<>();
        for(String w: words){
            wMap.put(w, wMap.getOrDefault(w, 0) + 1);
        }

        for(int i=0; i<= s.length() - totalL; i++){
            Map<String, Integer> seen = new HashMap<>();
            int counter = 0;
            while (counter < wcount) {
                int startIdx = i + counter*wlen;
                int endIdx = startIdx + wlen;
                String currentW = s.substring(startIdx, endIdx);
                if(!wMap.containsKey(currentW)){
                    break;
                }
                seen.put(currentW, seen.getOrDefault(currentW, 0)+1);
                if(seen.get(currentW) > wMap.get(currentW)){
                    break;
                }
                counter++;
            }

            if(counter == wcount){ result.add(i);}

        }
        return result;
    }

    public static void main(String[] args) {
        List<Integer> expected = List.of(0,9);
        List<Integer> actual  = findSubString("barfoothefoobarman", new String[]{"foo","bar"});
        assert actual.size()==expected.size();
        assert actual.contains(0);
        assert actual.contains(9);
    }
}