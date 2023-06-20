package hoa.can.code.ez;

/**
 * https://www.hackerrank.com/challenges/the-time-in-words/problem
 */
public class TheTimeInWords {
    public static String timeInWords(int h, int m) {
        if (m == 0) return String.format("%s o' clock", convertIntToString(h));

        if (m < 31) {
            String mc = convertIntToString(m);
            String hc = convertIntToString(h);
            if ("fifteen".equals(mc)) {
                return String.format("quarter past %s", hc);
            }

            if ("thirty".equals(mc)) {
                return String.format("half past %s", hc);
            }
            if ("one".equals(mc)) {
                return String.format("one minute past %s", hc);
            }
            return String.format("%s minutes past %s", mc, hc);
        }
        String mc = convertIntToString(60 - m);
        String hc = convertIntToString(h + 1);
        if("thirteen".equals(hc)) hc = "one";
        if ("fifteen".equals(mc)) return String.format("quarter to %s", hc);
        if ("one".equals(mc)) return String.format("one minute to %s", hc);
        return String.format("%s minutes to %s", mc, hc);
    }

    public static String convertIntToString(int n) {
        if (n < 1 || n > 60) {
            throw new IllegalArgumentException("Input out of range. Expected value between 1 and 60 (inclusive).");
        }

        if (n <= 20) {
            String[] numbers = {
                    "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                    "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                    "eighteen", "nineteen", "twenty"
            };
            return numbers[n - 1];
        } else {
            String[] tens = {"twenty", "thirty", "forty", "fifty", "sixty"};
            int tensDigit = n / 10 - 2;
            int onesDigit = n % 10;
            if (onesDigit != 0) {
                return String.format("%s %s", tens[tensDigit], convertIntToString(onesDigit));
            } else {
                return tens[tensDigit];
            }
        }

    }
}
