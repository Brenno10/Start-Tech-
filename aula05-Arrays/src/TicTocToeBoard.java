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
        } while ( str.length != 9 && isValidChar(str) );

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

    private static String writeBoard(String[] _str) {
        StringBuilder toReturn = new StringBuilder();

        for ( int i = 0; i < _str.length; i++ ) {
            if ( i < 3 )
                toReturn.append(_str[i]);
            else if ( i < 6 )
                toReturn.append("\n").append(_str[i]);
            else
                toReturn.append("\n").append(_str[i]);
        }

        return toReturn.toString();
    }
}
