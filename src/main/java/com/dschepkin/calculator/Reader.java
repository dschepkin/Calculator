package main.java.com.dschepkin.calculator;

import java.io.InputStream;
import java.util.Scanner;

public class Reader {
    private static String output;

    public static String getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter expression like \"2 + 2\" in one line");
        System.out.println("Allowed only integer numbers: [123456789] [+-*/] [I II III IV V VI VII VIII IX]");
        System.out.print(":");
        output = scanner.nextLine();
        scanner.close();

        return output;
    }
}
