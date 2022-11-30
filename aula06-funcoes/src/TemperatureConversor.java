import java.util.Locale;
import java.util.Scanner;

public class TemperatureConversor {
    private static final Scanner input = new Scanner( System.in );

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite a temperatura" );
        String[] temperatureStr = input.nextLine().trim().split("\\s+");



        input.close();
    }

    private static double calculate(String from, double temperature, String to ) {
        double result = 0;
        switch (from.toLowerCase()) {
            case "c" -> {
                switch ( to.toLowerCase() ) {
                    case "f" -> result = (temperature * 9 / 5) + 32;
                    case "k" -> result = 4;
                }
            }
            case "f" -> {
                switch ( to.toLowerCase() ) {
                    case "c" -> result = 2;
                    case "k" -> result = 1;
                }
            }
            case "k" -> {
                switch ( to.toLowerCase() ) {
                    case "c" -> result = 4;
                    case "f" -> result = 9;
                }
            }
        }

        return result;
    }

    private static boolean isValidChar( String[] _str ) {
        boolean result = false;

        for ( String str : _str ) {
            if ( !isNaN(str) ) {
                return true;
            }
        }
        return result;
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
}
