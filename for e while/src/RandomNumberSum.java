import java.util.Random;
import java.util.Scanner;

public class RandomNumberSum {
    private static final Random rand = new Random();
    private static final Scanner input = new Scanner( System.in );

    public static void main(String[] args) {
        System.out.println("\nDigite um número");
        int num = input.nextInt();

        int[] randArr = new int[num];
        int total = 0;

        System.out.println( "" );
        for ( int i = 0; i < randArr.length; i++ ) {
            randArr[i] = rand.nextInt(6) + 1;
            System.out.printf( "O número %d foi sorteado!\n", randArr[i] );
            total += randArr[i];
        }

        System.out.printf( "\nA soma dos números é %d.", total );
    }
}
