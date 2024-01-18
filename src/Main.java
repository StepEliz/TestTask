import java.util.*;

public class Main {
    public static void main(String[] ex) throws RomanResultException, NumberFormatException, InputMismatchException {
        Scanner in = new Scanner(System.in);
        String expression = in.nextLine();
        System.out.println(calc(expression));
    }
    public static String calc(String input) throws RomanResultException, NumberFormatException, InputMismatchException {
        String[] str = input.split(" ");
        String operand = null;
        int pos = 0;
        int j = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i].equals("+") || str[i].equals("-") || str[i].equals("*") || str[i].equals("/")) {
                operand = str[i];
                pos = i;
                j++;
            }
        }
        if (j > 1 || j == 0) {
                throw new InputMismatchException("В веденной строке отсутствует операнд для вычисления");
        } else {
            String number1 = numbers(str, 0, pos);
            String number2 = numbers(str, pos + 1, str.length);
            if (isRoman(number1, number2)) {
                int res = calculation(RomanNumbers.romanInArabik(number1), RomanNumbers.romanInArabik(number2), String.valueOf(operand));
                String result = RomanNumbers.arabikInRoman(res);
                if (res <= 0) {
                    throw new RomanResultException("Результат вычисления меньше или равен 0");
                }
                return  result;
            } else if (!(Integer.parseInt(number1) >= 1 && Integer.parseInt(number1) <= 10 && Integer.parseInt(number2) >= 1 && Integer.parseInt(number2) <= 10)) {
                throw new NumberFormatException("Введены не корректные данные");
            } else {
                    int result = calculation(Integer.parseInt(number1), Integer.parseInt(number2), String.valueOf(operand));
                    return String.valueOf(result);
            }
            }
    }

    public static String numbers(String[] arg, int from, int to) {
        String[] str1 = Arrays.copyOfRange(arg, from, to);
        String number = Arrays.toString(str1);
        return number.replaceAll(", ", "").replaceAll("\\[", "").replaceAll("]", "");
    }

    public static boolean isRoman(String number1, String number2) {
        RomanArabik num1 = intOfRoman(number1);
        RomanArabik num2 = intOfRoman(number2);
        return num1 == RomanArabik.ROMAN && num2 == RomanArabik.ROMAN;
    }

    public static RomanArabik intOfRoman(String number1) {
        RomanArabik roman = RomanArabik.Error;
        for (RomanNumbers a: RomanNumbers.values()) {
            if (number1.equals(a.rname())) {
                roman = RomanArabik.ROMAN;
                break;
            }
        }
        return roman;
    }

    public static int calculation(int number1, int number2, String oper) {
        if (Objects.equals(oper, "+")) {
            return number1 + number2;
        } else if (Objects.equals(oper, "-")) {
            return number1 - number2;
        } else if (Objects.equals(oper, "*")) {
            return number1 * number2;
        } else {
            return number1 / number2;
        }
    }


}