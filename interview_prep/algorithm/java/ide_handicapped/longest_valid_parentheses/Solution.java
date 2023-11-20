import java.util.Stack;

class Solution {
    public static int longestValidParenthese(String s){
        Stack<Integer> stack = new Stack<>();
        int maxLength = 0;
        stack.push(-1);
        for(int i = 0; i< s.length(); i++){
            char c = s.charAt(i);
            if(c=='('){
                stack.push(i);
            } else {
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                } else {
                    maxLength = Math.max(maxLength, i - stack.peek());
                }
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        // assert longestValidParenthese("()") == 2 : String.format("actual %s", longestValidParenthese("()"));
        verify(longestValidParenthese(""), 0);
        verify(longestValidParenthese("("), 0);
        verify(longestValidParenthese("()"), 2);
        verify(longestValidParenthese(")()())"), 4);
    }

    private static void verify(int actual, int expected){
        assert (actual == expected) : String.format("a %s, e %", actual, expected);
    }
}