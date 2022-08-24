import java.util.ArrayList;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {

        s = s.toLowerCase();
        ArrayList<Character> al = new ArrayList<>();

        char[] ca = s.toCharArray();

        for (int i = 0; i < ca.length; i++) {
            if (!(ca[i] >= 96 && ca[i] < 123)) {

                continue;
            }
            al.add(ca[i]);

        }

        int p1 = 0;
        int p2 = al.size() - 1;

        for (int i = 0; i < al.size() / 2; i++) {
            if (al.get(p1) != al.get(p2)) {
                return false;
            } else {
                p1++;
                p2--;
            }
        }

        return true;

    }

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        String s1 = "race a car";
        String s2 = " ";
        String s3 = "1b1";
        ValidPalindrome vp = new ValidPalindrome();

        System.out.println(vp.isPalindrome(s));
        System.out.println(vp.isPalindrome(s1));
        System.out.println(vp.isPalindrome(s2));
        System.out.println(vp.isPalindrome(s3));
    }

}
