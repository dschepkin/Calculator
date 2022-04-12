package main.java.com.dschepkin.calculator;

public enum Roman {
    ONE     ("I"),
    TWO     ("II"),
    THREE   ("III"),
    FOUR    ("IV"),
    FIVE    ("V"),
    SIX     ("VI"),
    SEVEN   ("VII"),
    EIGHT   ("VIII"),
    NINE    ("IX");

    private String value;

    Roman(String value) {
        this.value = value;
    }

    String getValue(){
        return value;
    }
}
