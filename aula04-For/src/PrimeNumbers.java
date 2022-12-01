import java.util.Scanner;

public class PrimeNumbers {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println( "\nAté qual número sera verificado" );
        int num = input.nextInt();

        System.out.println( "\nO número informado foi " + num );
        System.out.println( "Os números primos entre 1 e " + num + " são:" );
        for ( int i = 1; i <= num; i++ ) {
            if ( getPrimeNumber(i) )
                System.out.println(i);
        }

        input.close();
    }

    private static boolean getPrimeNumber(int n) {
        boolean flag = false;

        for ( int i = 2; i < n / 2; i++ ) {
            if ( n % i == 0) {
                flag = true;
                break;
            }
        }

        return !flag;
    }
}
