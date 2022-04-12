package main.java.com.dschepkin.calculator;

public class Sanitizer {

    //оба арумента десятичные или римские, иначе null.
    //чтобы понять с десятичным или римским калькулятором надо работать
    static String typeBothArgs;

    //при операциях с римскими цифрами результат не может быть отрицательным и равен нулю
    static boolean romanResultCheck(int result) {
        if(result <= 0) {
            return false;
        };

        return true;
    }
    /*
     - кол-во входных аргументов
     - аргументы корректных типов: может быть десятичным или римским числом, операцией
     - корректный порядок аргументов: пример 2 + 2, т.е аргументы иметь не четный позиции, операция четную
     - аргументы имеют одинаковый тип: т.е оба десятичные или римские
     */
    static boolean preExecuteCheck(Argument[] arguments) {
        countInputArgsCheck(arguments);
        argCorrectTypeCheck(arguments);

        return true;
    }

    //кол-во входных аргументов
    private static void countInputArgsCheck(Argument[] arguments) {
        if(arguments.length == 3) {
            return;
        } else {
            throw new IllegalArgumentException("Incorrent count argument. Should be 3 arguments");
        }
    }

    //аргументы корректных типов: может быть десятичным или римским числом, операцией
    //корректный порядок аргументов: пример 2 + 2, т.е аргументы иметь не четный позиции, операция четную
    //аргументы имеют одинаковый тип: т.е оба десятичные или римские
    private static void argCorrectTypeCheck(Argument[] arguments) {
        if(  ((arguments[0].getValueType().equals("Roman"))
            & (arguments[1].getValueType().equals("Operation"))
            & (arguments[2].getValueType().equals("Roman"))) ){

            typeBothArgs = "Roman";
        }

        if(  ((arguments[0].getValueType().equals("Decimal"))
            & (arguments[1].getValueType().equals("Operation"))
            & (arguments[2].getValueType().equals("Decimal"))) ) {

            typeBothArgs = "Decimal";
        }

        if(typeBothArgs == null) {
            throw new IllegalArgumentException("Incorrect argument type or order. Should be: (Decimal +-*/ Decimal) Or (Roman +-*/ Roman)");
        }
    }
}
