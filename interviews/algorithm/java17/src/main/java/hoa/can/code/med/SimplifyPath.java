package hoa.can.code.med;

import java.util.Stack;

public class SimplifyPath {
    public  String solve(String path) {
        String[] tokens = path.split("/");
        Stack<String> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) {
                continue;
            } else if (token.equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                // Add the directory or file to the stack
                stack.push(token);
            }
        }
        // Build the simplified canonical path from the directories on the stack
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }
        // Return the simplified canonical path, or the root directory if the stack is empty
        return sb.length() > 0 ? sb.toString() : "/";
    }
//    public String solve(String path) {
//        String[] paths = path.split("/");
//        int left = -1, right = 0;
//        while (right < paths.length) {
//            if (paths[right].equals("..")) {
//                if (left != -1) {
//                    left = left - 1;
//                }
//            } else if (!paths[right].equals(".") && !paths[right].equals("")) {
//                paths[++left] = paths[right];
//            }
//            right++;
//        }
//        if (left == -1)
//            return "/";
//        StringBuilder buf = new StringBuilder();
//        for (int i = 0; i <= left; i++)
//            buf.append('/').append(paths[i]);
//        return buf.toString();
//    }
}
