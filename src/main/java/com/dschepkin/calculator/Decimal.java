package main.java.com.dschepkin.calculator;

public enum Decimal {
    ONE     ("1"),
    TWO     ("2"),
    THREE   ("3"),
    FOUR    ("4"),
    FIVE    ("5"),
    SIX     ("6"),
    SEVEN   ("7"),
    EIGHT   ("8"),
    NINE    ("9");

    private String value;

    Decimal(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}
