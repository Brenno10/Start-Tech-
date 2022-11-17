import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class PrizeDraw {
    private static final Scanner input = new Scanner( System.in );
    private static final Random rand = new Random();
    private static final int[] randArr = new int[3];

    public static void main( String[] args ) {
        input.useLocale(Locale.US);

        gameStart();

        System.out.println( "\nEscolha um número de 1 a 6" );
        int num;

        do {
            num = input.nextInt();
            if ( !ifIsValid( num ) ) {
                System.out.println( "\nO número " + num + " não é um número válido." );
            }
        } while ( !ifIsValid( num ) );

        System.out.printf( "\nO número selecionado foi o %d.\n" +
                "Os números sorteados foram %d, %d e %d." +
                verifyAnswer( num ),
                num, randArr[0], randArr[1], randArr[2] );

        input.close();
    }

    private static void gameStart() {
        for ( int i = 0; i < 3; i++ ) {
            randArr[i] = rand.nextInt(6) + 1;
        }
    }

    private static String verifyAnswer( int _num ) {
        String result = "\n";
        int hits = 0;

        for ( int i : randArr ) {
            if (_num == i) {
                hits += 1;
            }
        }

        switch ( hits ) {
            case 1 -> result += "Você teve 1 acerto!\n";
            case 2 -> result += "Você teve 2 acertos!\n";
            case 3 -> result += "Você acertou todos!\n";
            default -> result += "Você não obteve nenhum acerto.\n";
        }
        
        return result;
    }

    private static boolean ifIsValid ( int num ) {
        return num > 0 && num < 7;
    }
}
