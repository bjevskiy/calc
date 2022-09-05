package calc;
import java.util.Map;
import java.util.TreeMap;
// ТЗ Требования: П.3 Калькулятор должен принимать на вход числа от 1 до 10 включительно...
class ConversionService {

    private final static TreeMap< Integer, String > romanLiterals = new TreeMap<>();

    static {
        romanLiterals.put(1, "I");
        romanLiterals.put(4, "IV");
        romanLiterals.put(5, "V");
        romanLiterals.put(9, "IX");
        romanLiterals.put(10, "X");
        romanLiterals.put(40, "XL");
        romanLiterals.put(50, "L");
        romanLiterals.put(90, "XC");
        romanLiterals.put(100, "C");
    }
    public static Number stringToNumber(String symbol) throws Exception {

        int value;
        Number.NumberType type;

        try {
            value = Integer.parseInt(symbol);
            type = Number.NumberType.ARABIC;
        }catch (NumberFormatException e) {
            value = ConversionService.romanToInt(symbol);
            type = Number.NumberType.ROMAN;
        }
        if (value < 1 || value > 10) {
            throw new Exception("Неподходящее значение. Калькулятор должен принимать на вход числа от 1 до 10 включительно.");
        }

        return new Number(value, type);
    }
    static int romanToInt(String romanNumber) throws Exception {
        int result = 0;

        int i = 0;
        while (i < romanNumber.length()) {
            char number = romanNumber.charAt(i);
            int num = mapIterate(number);

            if (num < 0) throw new Exception("Строка содержит неподходящий символ");

            i++;
            if (i == romanNumber.length()) {
                result += num;
            }else {
                int nextNum = mapIterate(romanNumber.charAt(i));
                if(nextNum > num) {
                    result += (nextNum - num);
                    i++;
                }
                else result += num;
            }
        }
        return result;
    }
    public static String intToRoman(int number) {
        int l =  romanLiterals.floorKey(number);
        if ( number == l ) {
            return romanLiterals.get(number);
        }
        return romanLiterals.get(l) + intToRoman(number-l);
    }

    private static int mapIterate(char number) {

        int result = -1;
        for (Map.Entry < Integer, String > entry : romanLiterals.entrySet()) {
            if (entry.getValue().equals(String.valueOf(number))) result = entry.getKey();
        }
        return result;
    }
}
