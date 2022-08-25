public class RansomNotes {
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

    public static void main(String[] args) {
        RansomNotes rn = new RansomNotes();
        String ransomNote = "aa";
        String magazine = "ab";
        System.out.println(rn.canConstruct(ransomNote, magazine));
        rn.canConstruct(ransomNote, magazine);
    }

}
