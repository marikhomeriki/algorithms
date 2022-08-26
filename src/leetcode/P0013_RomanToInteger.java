import java.util.LinkedHashMap;
import java.util.Map;

public class P0013_RomanToInteger {
    public int romanToInt(String s) {
        int result = 0;

        Map<String, Integer> roman = new LinkedHashMap<>();

        roman.put("M", 1000);
        roman.put("CM", 900);
        roman.put("D", 500);
        roman.put("CD", 400);
        roman.put("C", 100);
        roman.put("XC", 90);
        roman.put("L", 50);
        roman.put("XL", 40);
        roman.put("X", 10);
        roman.put("IX", 9);
        roman.put("V", 5);
        roman.put("IV", 4);
        roman.put("I", 1);

        while (s.length() > 0) {

            if (s.length() == 1) {
                return result + roman.get(s.substring(0, 1));
            }

            String two = s.substring(0, 2);
            if (roman.containsKey(two)) {
                result += roman.get(two);
                s = s.substring(2);
            } else {
                String one = s.substring(0, 1);
                result += roman.get(one);
                s = s.substring(1);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        P0013_RomanToInteger romantoint = new P0013_RomanToInteger();
        String s = "V";
        System.out.println(romantoint.romanToInt(s));
    }

}
