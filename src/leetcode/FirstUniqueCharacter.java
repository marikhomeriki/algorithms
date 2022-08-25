import java.util.Map;
import java.util.HashMap;

public class FirstUniqueCharacter {
    public int firstUniqChar(String s) {

        Map<Character, Integer> map = new HashMap<>();
        char[] ca = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            int c = map.getOrDefault(s.charAt(i), 0);
            map.put(s.charAt(i), c + 1);
        }

        for (int i = 0; i < ca.length; i++) {
            if (map.get(ca[i]) == 1) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        FirstUniqueCharacter fuq = new FirstUniqueCharacter();
        String s = "aabb";
        System.out.println(fuq.firstUniqChar(s));
        fuq.firstUniqChar(s);
    }

}
