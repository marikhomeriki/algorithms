public class P0557_ReverseWords {
    public String reverseWords(String s) {

        String[] st = s.split(" ");
        for (int i = 0; i < st.length; i++) {
            st[i] = reverse(st[i]);
        }
        return String.join(" ", st);
    }

    private String reverse(String s) {
        char[] ca = s.toCharArray();

        for (int i = 0; i < ca.length / 2; i++) {
            char temp = ca[i];
            ca[i] = ca[ca.length - 1 - i];
            ca[ca.length - 1 - i] = temp;
        }
        return s = String.valueOf(ca);
    }

    public static void main(String[] args) {
        P0557_ReverseWords rw = new P0557_ReverseWords();

        String s = "Let's take LeetCode contest";
        rw.reverseWords(s);
    }

}
