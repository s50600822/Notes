import java.util.regex.Pattern;

public class Solution {
    public boolean isNumber(String s) {
        boolean seenDigit = false, seenDot = false, seenExponent = false;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            switch (ch) {
                case '+':
                case '-':
                    if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                        return false;
                    }
                    break;

                case 'e':
                case 'E':
                    if (seenExponent || !seenDigit) {
                        return false;
                    }
                    seenExponent = true;
                    seenDigit = false;
                    break;

                case '.':
                    if (seenDot || seenExponent) {
                        return false;
                    }
                    seenDot = true;
                    break;

                default:
                    if (Character.isDigit(ch)) {
                        seenDigit = true;
                    } else {
                        return false;
                    }
            }
        }

        return seenDigit;
    }

    public boolean isNumber2(String s) {
        boolean seenDigit = false, seenDot = false, seenExponent = false;

        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                // current char is a 0 -- 9
                seenDigit = true;
            }
            else if(ch == '+' || ch == '-'){
                // sign can be only the first char or after e/E
                if(i>0 && s.charAt(i-1) != 'e' && s.charAt(i-1) != 'E'){
                    return false;
                }
            }
            else if(ch == 'e' || ch == 'E'){
                // can be only one e/E and has to be after a digit.
                if(seenExponent || !seenDigit){
                    return false;
                }

                seenExponent = true;
                seenDigit = false;
            }
            else if(ch == '.'){
                // can be only one . and cannot be after e/E
                if(seenDot || seenExponent){
                    return false;
                }

                seenDot = true;
            }
            else{
                // rest anything is false.
                return false;
            }
        }

        return seenDigit;
    }

    public boolean isNumberRegexp(String s) {
        if (s == null || s.trim().length() == 0) {
            return false;
        }
        String regex = "[-+]?([0-9]*\\.?[0-9]+|[0-9]+\\.?[0-9]*)([eE][-+]?[0-9]+)?";

        return s.matches(regex);
    }

    public static void main(String[] args) {
        Solution validator = new Solution();
    }
}
