package com.totvs.tools;

import java.util.Scanner;

public class ScannerPlus {
    private static final Scanner input = new Scanner(System.in);

    public static String readString(String str) {
        System.out.println(str);
        return input.nextLine().trim();
    }

    public static String readLowerCaseString(String str) {
        System.out.println(str);
        return input.nextLine().trim().toLowerCase();
    }

    public static String readUpperCaseString(String str) {
        System.out.println(str);
        return input.nextLine().trim().toUpperCase();
    }

    public static int readInt(String str) {
        System.out.println(str);
        String strNum = input.nextLine().trim();
        int num = -1;
        while (num == -1) {
            try {
               num = Integer.parseInt(strNum);
            } catch (Exception e) {
                System.out.println(strNum + " não é um número válido");
                strNum = input.nextLine().trim();
            }
        }
        return num;
    }

    public static double readDouble(String str) {
        System.out.println(str);
        String strNum = input.nextLine().trim();
        double num = -1;
        while (num == -1) {
            try {
                num = Double.parseDouble(strNum);
            } catch (Exception e) {
                System.out.println(strNum + " não é um número válido");
                strNum = input.nextLine().trim();
            }
        }
        return num;
    }
}
