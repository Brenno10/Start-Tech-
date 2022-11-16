import java.util.Locale;
import java.util.Scanner;

public class CelciusToFarenheit {
    private static final Scanner input = new Scanner( System.in );

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite a temperatura em celcius" );
        float celcius = input.nextFloat();

        float result = ( celcius * 9 / 5 ) + 32;

        System.out.println( "\nA temperatura " + celcius + "° em farenheit é " + result );

        input.close();
    }
}
