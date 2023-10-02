package hoa.can.code.diff;

public class ZigzagConversion {
    public String convert(String s, int rowWidth) {
        if (rowWidth == 1 || rowWidth >= s.length()) {
            return s;
        }
        String[] rows = new String[rowWidth];
        for (int i = 0; i < rowWidth; i++) {
            rows[i] = "";
        }
        int rowIndex = 0, step = 1;
        for (char c : s.toCharArray()) {
            rows[rowIndex] += c;
            if (rowIndex == 0) {
                step = 1;
            } else if (rowIndex == rowWidth - 1) {
                step = -1;
            }
            rowIndex += step;
        }
        final StringBuilder result = new StringBuilder();
        for (String row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
