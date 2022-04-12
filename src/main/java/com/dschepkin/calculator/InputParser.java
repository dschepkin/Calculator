package main.java.com.dschepkin.calculator;

public class InputParser<T> {
    private static String inputFromReader = Reader.getInput();

    static String[] getInput() {
        return inputFromReader.split("[\s]");
    }
}
