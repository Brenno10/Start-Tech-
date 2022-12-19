package tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Tools {
    private static final Scanner input = new Scanner(System.in);
    private static final Random rand = new Random();

    public static double scanDouble(String msg) {
        String in = "";
        while (true) {
            try {
                System.out.println( msg );
                in = input.nextLine().trim();
                return Double.parseDouble(in);
            } catch (NumberFormatException e) {
                System.out.println(in + " não é um número");
            }
        }
    }

    public static int scanInt(String msg) {
        String in = "";
        while (true) {
            try {
                System.out.println( msg );
                in = input.nextLine().trim();
                return Integer.parseInt(in);
            } catch (NumberFormatException e) {
                System.out.println(in + " não é um número");
            }
        }
    }

    public static String scanString(String msg) {
        System.out.println( msg );
        return input.nextLine().trim();
    }
}
