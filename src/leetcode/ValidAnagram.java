import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ValidAnagram {
    private boolean validAnagram(String s, String t) {

        Set<String> mp = new HashSet<>();

        char[] ca = s.toCharArray();
        Arrays.sort(ca);
        String key = new String(ca);

        mp.add(key);

        char[] ca1 = t.toCharArray();
        Arrays.sort(ca1);
        String key2 = new String(ca1);

        if (mp.contains(key2)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ValidAnagram va = new ValidAnagram();
        String s = "rat";
        String t = "car";
        System.out.println(va.validAnagram(s, t));

    }

}
