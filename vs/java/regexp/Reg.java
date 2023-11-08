import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Reg {

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        boolean m = reg();
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime)/1000000;

        System.out.println(String.format("time: %s [%s ms]" , m ,durationMs));
    }

    public static String reverseString(String str) {
        if (str.isEmpty())
            return str;
        return reverseString(str.substring(1)) + str.charAt(0);
    }

    public static boolean reg(){
        final String expr = "(a|b|ab)*bc";
        final String in = "ababababababababababababababababababababababababababababac";
        Pattern p = Pattern.compile(expr);
        Matcher m = p.matcher(in);
        return m.matches();
    }
}