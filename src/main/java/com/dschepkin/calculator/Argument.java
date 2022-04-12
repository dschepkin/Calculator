package main.java.com.dschepkin.calculator;

public class Argument {
    /*
    * Аргумент операции.
    *
    * Состояние определяется:
    * значение  value
    * тип       valueType   (Может быть: десятичным числом, римским, операцией)
    *
    * defineValueType - По передаваемому строкову значению может определить тип аргумента: десятичное или римское число или операция (+ - ...)
    */

    private String value;
    private String valueType;

    /*
    Преобразованное десятичное число:
    String decimal      -> int
    String roman        -> int
    String operation    -> int = 0
     */
    private int decimalValue;

    Argument(String value) {
        this.value = value;
        valueType = defineValueType(value);
    }

    public String getValue() {
        return value;
    }

    public String getValueType() {
        return valueType;
    }

    public int getDecimalValue() {
        return decimalValue;
    }

    //определяем тип аргумента: decimal, roman, operation
    private String defineValueType(String value) {
        for (Roman roman : Roman.values()) {
            if (roman.getValue().equals(value)) {
                decimalValue = Converter.castRomanToDecimal(value);
                return "Roman";
            }
        }

        for (Operation operation : Operation.values()) {
            if (operation.getValue().equals(value)) {
                return "Operation";
            }
        }

        for (Decimal decimal : Decimal.values()) {
            if (decimal.getValue().equals(value)) {
                //если найдено десятичное число в перечислении, то конвертируем String -> int (для последующего вычисления)
                try {
                    decimalValue = Integer.parseInt(value);
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

                return "Decimal";
            }
        }

        throw new IllegalArgumentException("Incorrent argument type.");
    }
}
