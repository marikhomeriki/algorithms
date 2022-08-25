public class P1859_SortingSentence {
    public String sortSentence(String s) {
        String[] arr = s.split(" ");
        String[] res = new String[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int pos = arr[i].charAt(arr[i].length() - 1) - '0';
            res[pos - 1] = arr[i].substring(0, arr[i].length() - 1);
        }
        return String.join(" ", res);
    }

    public static void main(String[] args) {
        P1859_SortingSentence ss = new P1859_SortingSentence();
        String input = "is2 sentence4 This1 a3";
        ss.sortSentence(input);
        System.out.println(ss.sortSentence(input));
    }
}
