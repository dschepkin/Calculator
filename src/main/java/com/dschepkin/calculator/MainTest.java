package main.java.com.dschepkin.calculator;

public class MainTest {
    public static void main(String[] args) {
        Argument[] argArr = new Argument[InputParser.getInput().length];

        for(int i = 0; i < InputParser.getInput().length; i++) {
            argArr[i] = new Argument(InputParser.getInput()[i]);
        }
    }
}
