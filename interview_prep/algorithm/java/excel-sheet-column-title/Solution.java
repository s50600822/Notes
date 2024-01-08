class Solution {
    public String convertToTitle(int columnNumber) {
        //https://leetcode.com/problems/excel-sheet-column-title
        StringBuilder result = new StringBuilder();

        while (columnNumber > 0) {
            columnNumber--;
            char currentChar = (char) ('A' + columnNumber % 26);
            result.insert(0, currentChar);
            columnNumber /= 26;
        }

        return result.toString();
    }
}