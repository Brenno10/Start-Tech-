import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class RandomNumbersDraw {
    private static final Scanner input = new Scanner( System.in );
    private static final Random rand = new Random();

    public static void main( String[] args ) {
        input.useLocale( Locale.US );

        System.out.println( "\nDigite a quantidade de números a serem sorteados." );
        int num = input.nextInt();
        int randNum;
        int times = 0;

        do {
            randNum = generateRandNum(num);
            times++;
            System.out.printf( "\nO número sorteado foi %d.", randNum );
        } while ( randNum != num );

        System.out.printf( "\n\nForam necessários %d sorteios para que o número %d fosse sorteado\n",
                times, num);
    }

    private static int generateRandNum(int _num) {
        return rand.nextInt(_num + 1);
    }
}
