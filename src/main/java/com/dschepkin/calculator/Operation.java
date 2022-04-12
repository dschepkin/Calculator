package main.java.com.dschepkin.calculator;

public enum Operation {
    PLUS           ("+"),
    MINUS          ("-"),
    MULTIPLICAION  ("*"),
    DIVISION       ("/");

    private String value;

    Operation(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
