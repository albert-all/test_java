import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class Main {

    static boolean flag1 =true;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите выражение [5 + 5] или [VI / III] + Enter ");

        String arithmeticOperation = in.nextLine();
        arithmeticOperation = arithmeticOperation.replaceAll("\\s+", " ");


        String answer =  calc(arithmeticOperation);
        if (flag1){
            System.out.println(answer);
        }
        else {
            System.out.println(ArabicToRomanConverter.arabicToRoman(Integer.valueOf(answer)));
        }


    }

    public static String calc(String input) {
        int answer = -1;
        String[] splitOperation = input.split("\\s");
        if (splitOperation.length > 3)
            throw new IllegalStateException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
        Integer a;
        Integer b;

        try {
            flag1 = true ;
            a = Integer.valueOf(splitOperation[0]);
            b = Integer.valueOf(splitOperation[2]);
        } catch (Exception e) {
            try {
                flag1 = false;
                a = RomanToArabicConverter.romanToArabic(splitOperation[0]);
                b = RomanToArabicConverter.romanToArabic(splitOperation[2]);
            } catch (Exception en) {
                throw new IllegalStateException("Неверный формат. Введите выражение в формате:  [5 + 5] или [VI / III]");

            }
        }


        char[] operation = splitOperation[1].toCharArray();

        ArabicToRomanConverter.arabicToRoman(1);
        RomanToArabicConverter.romanToArabic("III");

        switch (operation[0]) {
            case ('+') -> {
                answer = a + b;
                return Integer.toString(answer);
            }
            case ('-') -> {
                answer = a - b;
                return Integer.toString(answer);
            }
            case ('*') -> {
                answer = a * b;
                return Integer.toString(answer);
            }
            case ('/') -> {
                answer = a / b;
                return Integer.toString(answer);
            }
            default ->
                    throw new IllegalStateException("Можно использовать оператор (+, -, /, *): Не верный формат: " + operation[0]);
        }
    }
}

