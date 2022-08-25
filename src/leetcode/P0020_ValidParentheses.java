import java.util.LinkedList;
import java.util.Map;
import java.util.Deque;
import java.util.HashMap;

public class P0020_ValidParentheses {

    public boolean isValid(String s) {
        Deque<Character> dq = new LinkedList<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                dq.addLast(s.charAt(i));
            }

            if (s.charAt(i) == ')' || s.charAt(i) == ']' || s.charAt(i) == '}') {
                if (dq.isEmpty()) {
                    return false;
                }

                if (s.charAt(i) == ')' && dq.getLast() != '(') {
                    return false;
                }

                if (s.charAt(i) == '}' && dq.getLast() != '{') {
                    return false;
                }

                if (s.charAt(i) == ']' && dq.getLast() != '[') {
                    return false;
                }

                dq.removeLast();
            }
        }

        if (!dq.isEmpty()) {
            return false;
        }

        return true;

    }

    public boolean isValid2(String s) {
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                count++;
            }
            if (s.charAt(i) == ')') {

                count--;
                if (count < 0) {
                    return false;
                }
            }

        }

        return true;

    }

    public boolean isValid3(String s) {
        Deque<Character> stack = new LinkedList<>();
        Map<Character, Character> mapping = new HashMap<>();

        mapping.put(')', '(');
        mapping.put(']', '[');
        mapping.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[' || ch == '{') {
                stack.addLast(ch);
            }

            if (ch == ')' || ch == ']' || ch == '}') {
                if (stack.isEmpty() || stack.getLast() != mapping.get(ch)) {
                    return false;
                }

                stack.removeLast();
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }

    public static void main(String[] args) {
        P0020_ValidParentheses vp = new P0020_ValidParentheses();
        String s = "())";
        vp.isValid(s);
        System.out.println(vp.isValid(s));
    }

}
