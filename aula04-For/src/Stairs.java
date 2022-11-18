import java.util.Scanner;

public class Stairs {
    private static final Scanner input = new Scanner( System.in );

    public static void main(String[] args) {
        String stairs = "";

        System.out.println("\nDigite um número");
        int num = input.nextInt();

        for ( int i = 0; i < num; i++ ) {
            System.out.println( stairs += "#" );
        }

        input.close();
    }
}
