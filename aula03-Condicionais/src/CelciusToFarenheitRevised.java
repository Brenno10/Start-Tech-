import java.util.Locale;
import java.util.Scanner;

public class CelciusToFarenheitRevised {
    private static final Scanner input = new Scanner( System.in );

    public static void main( String[] args ) {
        input.useLocale(Locale.US);
        String userInput;

        System.out.println( "\nDigite a temperatura (use C para celcius ou F para Farenheit)" );
        do {
            userInput = input.nextLine();

            if ( testType( userInput ) )
                System.out.printf( "\nA temperatura informada foi %.2f %s\n" +
                        "Ela é equivalente a %.2f° %s",
                        turnToNumber( userInput ), getLastChar( userInput ),
                        convert( userInput ), getType( userInput ) );
            else
                System.out.println( "\nA letra " +
                        userInput.substring( userInput.length() - 1 ).toUpperCase() +
                        " não correspondea uma unidade de medida de temperatura");

        } while ( !testType( userInput ) );

        input.close();
    }

    public static double convert( String temperature ) {
        if ( getLastChar( temperature ).equalsIgnoreCase( "c" ) )
            return ( turnToNumber( temperature ) * 9 / 5 ) + 32;

        return ( turnToNumber( temperature ) -32 ) * 5 / 9;
    }

    private static boolean testType ( String _str ) {
        return getLastChar( _str ).equalsIgnoreCase( "c" ) ||
                getLastChar( _str ).equalsIgnoreCase( "f" );
    }

    private static double turnToNumber ( String _str ) {
        return Double.parseDouble( _str.substring(0, _str.length() - 1) );
    }

    private static String getLastChar ( String _str ) {
        return _str.trim().substring( _str.length() - 1 ).toUpperCase();
    }

    private static String getType ( String _char ) {
        if ( getLastChar( _char ).equalsIgnoreCase( "c" ) )
            return "F";
        return "C";
    }
}
