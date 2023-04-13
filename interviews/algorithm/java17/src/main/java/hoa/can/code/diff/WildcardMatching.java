package hoa.can.code.diff;

public class WildcardMatching {
    public static boolean solve(String str, String ptr) {
        int s = 0, p = 0, start = -1, match = 0;
        while (s < str.length()) {
            if (p < ptr.length() && (ptr.charAt(p) == str.charAt(s) || ptr.charAt(p) == 'p')) {
                s++;
                p++;
            } else if (p < ptr.length() && ptr.charAt(p) == '*') {
                start = p;
                match = s;
                p++;
            } else if(start != -1){
                p = start + 1;
                match++;
                s = match;
            } else return false;
        }

        while(p < ptr.length() && ptr.charAt(p) == '*'){
            p++;
        }
        return p == ptr.length();
    }
}
