import java.util.Locale;
import java.util.Scanner;

public class TicTocToeBoard {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        String[] str;
        System.out.println("\nDigite 9 digitos ( x, o, _ )");
        do {
            str = input.nextLine().trim().split("\\s+");

            if ( str.length !=9 ) {
                System.out.println( "\nSão necessários 9 digitos" );
                System.out.println( str.length );
            }
            else if ( isValidChar(str) ) {
                System.out.print( "\nDigite apenas 'x', 'o' ou '_'" );
            }
            else {
                System.out.println( writeBoard(str) );
                break;
            }
        } while ( str.length != 9 && !isValidChar(str) );

        input.close();
    }

    private static boolean isValidChar( String[] _str ) {
        for ( String s : _str ) {
            if ( !s.equalsIgnoreCase( "x" ) || !s.equalsIgnoreCase( "o" )
                    || !s.equalsIgnoreCase( "_" ) )
                return false;
        }
        return true;
    }
// |
    private static String writeBoard(String[] _str) {
        String toReturn = "\n";

        if ( _str.length == 9 ) {
            toReturn = "\n " + _str[0] + " | " + _str[1] + " | " + _str[2] +
                    "\n " + _str[3] + " | " + _str[4] + " | " + _str[5] +
                    "\n " + _str[6] + " | " + _str[7] + " | " + _str[8];
        }

        return toReturn;
    }
}
