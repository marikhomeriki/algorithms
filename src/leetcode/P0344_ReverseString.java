import java.util.Arrays;

public class P0344_ReverseString {

    private char[] reverseString(char[] s) {

        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[s.length - 1 - i];
            s[s.length - 1 - i] = temp;
        }
        return s;

    }

    public static void main(String[] args) {
        P0344_ReverseString rs = new P0344_ReverseString();
        char[] s = new char[] { 'h', 'e', 'l', 'l', 'o' };
        rs.reverseString(s);
    }

}
