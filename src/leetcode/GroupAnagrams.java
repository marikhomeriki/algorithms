import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    private List<List<String>> groupsAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {

            int[] count = new int[26];

            for (char c : s.toCharArray()) {
                count[c - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                sb.append("#");
                sb.append(count[i]);
            }

            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(s);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };

        System.out.println(ga.groupsAnagrams(strs));
    }

}
