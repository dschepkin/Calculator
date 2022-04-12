package main.java.com.dschepkin.calculator;

public class Converter {

    //cast римское число в десятичное
    static int castRomanToDecimal(String roman) {
        return switch(roman) {
            case "I"    -> 1;
            case "II"   -> 2;
            case "III"  -> 3;
            case "IV"   -> 4;
            case "V"    -> 5;
            case "VI"   -> 6;
            case "VII"  -> 7;
            case "VIII" -> 8;
            case "IX"   -> 9;
            default -> throw new IllegalArgumentException("Incorrect number");
        };
    }

    //cast десятичное число в римское
    static String castDecimalToRoman(int decimal) {
        getCountDigital(decimal);
//        System.out.println("Number of elements in the number = " + getCountDigital(decimal));

        String roman = "Undefined";
        if (decimal == 0) {
            throw new IllegalArgumentException("Roman number not have 0");
        } else if ((getCountDigital(decimal) > 2)) {
            throw new IllegalArgumentException("Incorrent number > 3 number in result");
        } else if (getCountDigital(decimal) == 1) {
            return castOneDecimalNumberToRoman(decimal);
        }

        String numberString = Integer.toString(decimal);
        int[] arrNumber = new int[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {

            //ASCII коды, а не реальные числа в массиве - numberString.charAt(i)

            //Convert the ASCII value of each character to its value. To get the actual int value of a character,
            //we have to subtract the ASCII code value of the character '0' from the ASCII code of the actual character.
            arrNumber[i] = numberString.charAt(i) - '0';
        }

        //Если мы здесь, то число состоит из двух цифр. И оно всегда < 100
        // Если второй элемент числа равен 0, то это числа 10, 20...90
        if (arrNumber[1] == 0) {
            return castTwoDecimalNumberToRoman(arrNumber[0]);
            //иначе двузначное число, не заканчивающееся на 0
            //значит надо разбить цифру на 2 элемента. Вычислисть первый и конкатенировать со вторым числом
            //возвращаем строку вида 32 -> XXX+II = XXXII
        } else {
            String totalRoman;
            totalRoman = castTwoDecimalNumberToRoman(arrNumber[0]) + castOneDecimalNumberToRoman(arrNumber[1]);
            return totalRoman;
        }
    }

    //определяем кол-во чисел в цифре
    //нуля нет в римских цифрах, поэтому возвращать 0 в этом случае
    private static int getCountDigital(int number) {
        int count = (number == 0) ? 1 : 0;

        while(number != 0) {
            ++count;
            number /= 10;
        }

        return count;
    }

    //преобразуем десятичное число в римское
    private static String castOneDecimalNumberToRoman(int number) {
        return switch(number) {
            case 1 -> "I";
            case 2 -> "II";
            case 3 -> "III";
            case 4 -> "IV";
            case 5 -> "V";
            case 6 -> "VI";
            case 7 -> "VII";
            case 8 -> "VIII";
            case 9 -> "IX";
            default -> throw new IllegalArgumentException("Incorrect number");
        };
    }

    //преобразуем двузначные дясятичные числа заканчивающиеся на 0 в римские
    private static String castTwoDecimalNumberToRoman(int number) {
        return switch(number) {
            case 1 -> "X";
            case 2 -> "XXX";
            case 3 -> "XXX";
            case 4 -> "XL";
            case 5 -> "L";
            case 6 -> "LX";
            case 7 -> "LXX";
            case 8 -> "LXXX";
            case 9 -> "XC";
            default -> throw new IllegalArgumentException("Incorrect number");
        };
    }
}
