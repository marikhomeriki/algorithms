
import java.util.LinkedHashMap;
import java.util.Map;

public class P0012_IntegerToRoman {
    public String intToRoman(int num) {
        String s = "";
        Map<Integer, String> roman = new LinkedHashMap<>();

        roman.put(1000, "M");
        roman.put(900, "CM");
        roman.put(500, "D");
        roman.put(400, "CD");
        roman.put(100, "C");
        roman.put(90, "XC");
        roman.put(50, "L");
        roman.put(40, "XL");
        roman.put(10, "X");
        roman.put(9, "IX");
        roman.put(5, "V");
        roman.put(4, "IV");
        roman.put(1, "I");

        for (int key : roman.keySet()) {
            int k = num / key;
            for (int i = 0; i < k; i++) {
                s += roman.get(key);
            }
            num -= key * k;
        }

        return s;
    }

    public static void main(String[] args) {
        P0012_IntegerToRoman itor = new P0012_IntegerToRoman();
        int num = 1994;
        System.out.println(itor.intToRoman(num));
        itor.intToRoman(num);
    }

}
