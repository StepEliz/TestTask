public enum RomanNumbers {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7),
    VIII(8), IX(9), X(10), XX(20), XXX(30), XL(40), L(50),
    LX(60),LXX(70), LXXX(80), XC(90), C(100);

    private int meaning;
    RomanNumbers(int meaning){
        this.meaning = meaning;
    }

    public String rname() {
        return name();
    }

   public int getEqual() {
       return meaning;
    }

    public static int romanInArabik(String num1) {
        int number1 = 0;
        for (RomanNumbers a: RomanNumbers.values()) {
            if (num1.equals(a.rname())) {
             number1 = (int)a.getEqual();
            }
        }
        return number1;
    }


    public static String charNumberArabikInRoman(char num1) {
        String number1 = Character.toString(num1);
        int i = Integer.parseInt(number1);
        for (RomanNumbers a: RomanNumbers.values()) {
            if (i == a.meaning) {
                number1 = a.rname();
            }
        }
        return number1;
    }

    public static String intNumberArabikInRoman(int num1) {
        String number1 = "";
        for (RomanNumbers a: RomanNumbers.values()) {
            if (num1 == a.meaning) {
                number1 = a.rname();
            }
        }
        return number1;
    }

    public static String arabikInRoman(int number) {
        String roman = "";
        char dozens = (char) (number / 10 * 10);
        if (number % 10 != 0) {
            roman = intNumberArabikInRoman(dozens) + charArrayInRoman(romanInArrayChar(number % 10));
        } else roman = intNumberArabikInRoman(dozens);
        return roman;
    }

    public static char[] romanInArrayChar(int number) {
        char[] array = (String.valueOf(number)).toCharArray();
        return array;
    }

    public static String charArrayInRoman(char[] array) {
        String result = "";
        for (char c : array) {
            result = result + charNumberArabikInRoman(c);
        }
        return result;
    }
}
