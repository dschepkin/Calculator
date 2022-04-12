package main.java.com.dschepkin.calculator;

public class Executor {
    // Expression like: arg1 operation arg2 = 4 + 2

    private static int arg1;
    private static String operation;
    private static int arg2;
    private static int result;

    static String execute() {

        Argument[] argArr = new Argument[InputParser.getInput().length];

        for (int i = 0; i < InputParser.getInput().length; i++) {
            argArr[i] = new Argument(InputParser.getInput()[i]);
        }

        //проверка корректности выражение перед выполнением
        if (Sanitizer.preExecuteCheck(argArr)) {

            operation = argArr[1].getValue();
            arg1 = argArr[0].getDecimalValue();
            arg2 = argArr[2].getDecimalValue();

            if (operation.equals("-")) {
                result = arg1 - arg2;
            } else if (operation.equals("+")) {
                result = arg1 + arg2;
            } else if (operation.equals("*")) {
                result = arg1 * arg2;
            } else if (operation.equals("/")) {
                result = arg1 / arg2;
            }
        }

        if(Sanitizer.typeBothArgs.equals("Roman")) {
            if(Sanitizer.romanResultCheck(result)) {

                //возвращаем результат римским цислом в виде строки
                return Converter.castDecimalToRoman(result);
            } else {
                throw new IllegalArgumentException("Roman result <= 0. It is denied.");
            }
        }

        //возвращаем результат арабским числом
        return Integer.toString(result);
    }
}
