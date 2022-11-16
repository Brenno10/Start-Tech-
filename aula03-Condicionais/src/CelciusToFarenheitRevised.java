import java.util.Locale;
import java.util.Scanner;

public class CelciusToFarenheitRevised {
    private static final Scanner input = new Scanner( System.in );

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite a temperatura (use C para celcius ou F para Farenheit)" );
        String userInput = input.nextLine();

        System.out.println( convert( userInput ) );
    }

    public static double convert( String temperature ) {
        String type = temperature.substring( temperature.length() - 1 ).toLowerCase();
        double value = Double.parseDouble( temperature.substring(0, temperature.length() - 1) );

        if ( type.equals( "c" ) ) {
            return ( value * 9 / 5 ) + 32;
        }
        return ( value -32 ) * 5 / 9;
    }
}
