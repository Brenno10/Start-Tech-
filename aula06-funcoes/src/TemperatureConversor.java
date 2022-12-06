import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class TemperatureConversor {
    private static final Scanner input = new Scanner( System.in );
    private static final String[] tempTypesNames = { "Celsius", "Fahrenheit", "Kelvin" };
    private static boolean arrayWasBuild = false;
    private static int counter = 0;

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite a temperatura, tipo e para qual tipo converter (ex: 12c f, 90f k)" );
        String[] tempStr;

        do {
            if (counter > 0)
                System.out.println("\n - Tipo de Temperatura Inválido (somente 'c', 'f' e 'k' são aceitos)");
            counter++;

            tempStr = input.nextLine().trim().split("");
        } while ( runWhile(tempStr) );

        System.out.printf( "\nA conversão de %.2f %s para %s é %.2f°%S\n",
                getTemp(tempStr),
                tempTypesNames[getName(getTempTypes(tempStr).get(0))],
                tempTypesNames[getName(getTempTypes(tempStr).get(1))],
                calculate(getTempTypes(tempStr).get(0), getTemp(tempStr), getTempTypes(tempStr).get(1)),
                getTempTypes(tempStr).get(1));

        input.close();
    }

    public static double calculate(String from, double temp, String to ) {
        double result = 0;
        switch (from.toLowerCase()) {
            case "c" -> {
                switch ( to.toLowerCase() ) {
                    case "f" -> result = (temp * (9f / 5f)) + 32;
                    case "k" -> result = temp + 273.15;
                }
            }
            case "f" -> {
                switch ( to.toLowerCase() ) {
                    case "c" -> result = (temp - 32) * (5f / 9f);
                    case "k" -> result = (temp - 32) * (5f / 9f) + 273.15;
                }
            }
            case "k" -> {
                switch ( to.toLowerCase() ) {
                    case "c" -> result = temp - 273.15;
                    case "f" -> result = (temp - 273.15) * (5f / 9f) + 32;
                }
            }
        }

        return result;
    }

    private static boolean verifyType(String type) {
        if (!isNaN(type)) {
            return switch (type.toLowerCase()) {
                case "c", "f", "k" -> true;
                default -> false;
            };
        }
        else {
            return false;
        }
    }

    private static boolean isNaN( String _str ) {
        if (_str == null) {
            return false;
        }
        try {
            Double.parseDouble(_str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    private static double getTemp(String[] _str) {
        StringBuilder strNum = new StringBuilder();

        for (String s : _str) {
            if (isNaN(s)) {
                strNum.append(s);
            }
        }

        return Double.parseDouble(strNum.toString());
    }

    private static ArrayList<String> getTempTypes(String[] _str) {
        ArrayList<String> tempTypes = new ArrayList<>();

        for (String s : _str) {
            if (verifyType(s) && tempTypes.size() < 2) {
                tempTypes.add(s);
            }
        }

        if ( tempTypes.size() == 2 ) {
            arrayWasBuild = true;
        }

        return tempTypes;
    }

    private static int getName(String type) {
        return switch (type) {
            case "c" -> 0;
            case "f" -> 1;
            case "k" -> 2;
            default -> 3;
        };
    }

    private static boolean runWhile(String[] tempStr) {
        boolean isValidTemp;

        switch (getTempTypes(tempStr).get(0).toLowerCase()) {
            case "c" -> isValidTemp = (getTemp(tempStr) < -273.15);
            case "f" -> isValidTemp = (getTemp(tempStr) < -459.67);
            case "k" -> isValidTemp = (getTemp(tempStr) < 0);
            default -> isValidTemp = true;
        }

        if ( arrayWasBuild ) {
            return verifyType(getTempTypes(tempStr).get(0)) && verifyType(getTempTypes(tempStr).get(1)) &&
                    isValidTemp;
        }
        else {
            return true;
        }
    }
}
