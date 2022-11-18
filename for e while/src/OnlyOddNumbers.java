import java.util.Scanner;

public class OnlyOddNumbers {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println( "\nDigite um número" );
        int num = input.nextInt();

        System.out.println("");
        for ( int i = 0; i <= num; i++ ) {
            if ( i % 2 != 0 ) {
                System.out.println( + i );
            }
        }

        input.close();
    }
}
