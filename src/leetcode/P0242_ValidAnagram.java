import java.util.Arrays;

public class P0242_ValidAnagram {
    private boolean validAnagram(String s, String t) {

        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String key = new String(ca);

        char[] ca1 = t.toCharArray();
        Arrays.sort(ca1);
        String key2 = new String(ca1);

        return key.equals(key2);

    }

    public static void main(String[] args) {
        P0242_ValidAnagram va = new P0242_ValidAnagram();
        String s = "rat";
        String t = "car";
        System.out.println(va.validAnagram(s, t));

    }

}
