import java.util.HashMap;
import java.util.Map;

public class P0383_RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        int[] count = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            count[magazine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            count[ransomNote.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean canConstruct2(String ransomNote, String magazine) {

        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            if (map.containsKey(magazine.charAt(i))) {
                int c = map.get(magazine.charAt(i));
                map.put(magazine.charAt(i), c + 1);
            } else {
                map.put(magazine.charAt(i), 1);
            }
        }

        // for (int i = 0; i < magazine.length(); i++) {
        // int c = map.getOrDefault(magazine.charAt(i), 0);
        // map.put(magazine.charAt(i), c + 1);
        // }

        for (int i = 0; i < ransomNote.length(); i++) {
            if (map.containsKey(ransomNote.charAt(i))) {
                int c = map.get(ransomNote.charAt(i));
                map.put(ransomNote.charAt(i), c - 1);
            } else {
                return false;
            }
        }

        // for (char c : map.keySet()) {
        // if (map.get(c) < 0) {
        // return false;
        // }
        // }

        for (int c : map.values()) {
            if (c < 0) {
                return false;
            }
        }

        return true;
    }

    public boolean canConstruct3(String ransomNote, String magazine) {
        if (ransomNote.length() > magazine.length()) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < magazine.length(); i++) {
            int c = map.getOrDefault(magazine.charAt(i), 0);
            map.put(magazine.charAt(i), c + 1);
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            int c = map.getOrDefault(ransomNote.charAt(i), 0);
            map.put(ransomNote.charAt(i), c - 1);
        }

        for (int c : map.values()) {
            if (c < 0) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        P0383_RansomNote rn = new P0383_RansomNote();
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(rn.canConstruct(ransomNote, magazine));
        rn.canConstruct(ransomNote, magazine);
    }

}
