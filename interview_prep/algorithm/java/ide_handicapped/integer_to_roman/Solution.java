class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();
        while (num > 0) {
            String append;
            if (num >= 1000) {
                result.append('M');
                num -= 1000;
            } else if (num >= 900) {
                result.append("CM");
                num -= 900;
            } else if (num >= 500) {
                result.append('D');
                num -= 500;
            } else if (num >= 400) {
                result.append("CD");
                num -= 400;
            } else if (num >= 100) {
                result.append('C');
                num -= 100;
            } else if (num >= 90) {
                result.append("XC");
                num -= 90;
            } else if (num >= 50) {
                result.append('L');
                num -= 50;
            } else if (num >= 40) {
                result.append("XL");
                num -= 40;
            } else if (num >= 10) {
                result.append('X');
                num -= 10;
            } else if (num == 9) {
                result.append("IX");
                num -= 9;
            } else if (num >= 5) {
                result.append('V');
                num -= 5;
            } else if (num == 4) {
                result.append("IV");
                num -= 4;
            } else {
                result.append('I');
                num -= 1;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        //https://leetcode.com/problems/integer-to-roman/
        Solution solution = new Solution();
        assert solution.intToRoman(3).equals("III");
        assert solution.intToRoman(58).equals("LVIII");
        assert solution.intToRoman(1994).equals("MCMXCIV");
    }
}