public class ArabicToRomanConverter {

    private static final String[] ROMAN_NUMERALS = {
            "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    };

    private static final int[] ARABIC_VALUES = {
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    };

    public static String arabicToRoman(int number) {
        if (number <= 0 || number > 3999) {
            throw new IllegalArgumentException("Number out of range (1 to 3999)");
        }

        StringBuilder result = new StringBuilder();
        int i = 0;

        while (number > 0) {
            while (number >= ARABIC_VALUES[i]) {
                number -= ARABIC_VALUES[i];
                result.append(ROMAN_NUMERALS[i]);
            }
            i++;
        }

        return result.toString();
    }
}
