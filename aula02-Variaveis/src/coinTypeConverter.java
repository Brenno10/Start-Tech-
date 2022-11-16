import java.util.Locale;
import java.util.Scanner;

public class coinTypeConverter {
    private static final float[] allBases = {0.1935f, 0.1932f, 0.1704f, 30.9699f, 4.70f};
    private static final String[] allNames = {"Dolar", "Euro", "Libra", "Peso Argentino", "Coroas Tcheca"};
    private static final String[] allSymbols = {"US$", "€", "£", "pesos", "Kč"};

    private static final Scanner input = new Scanner( System.in );

    public static void main( String[] args ) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite um valor em reais" );
        float reais = input.nextFloat();

        for ( int i = 0; i < 5; i++ ) {
            if ( allSymbols[i].equals( "Kč" ) || allSymbols[i].equals( "pesos" ) ) {
                System.out.printf( "A conversão de R$%.2f para %s é %.2f %s %n",
                        reais, allNames[i], moneyConverter( reais, allBases[i] ), allSymbols[i] );
            }
            else {
                System.out.printf( "A conversão de R$%.2f para %s é %s%.2f %n",
                        reais, allNames[i], allSymbols[i], moneyConverter( reais, allBases[i] ) );
            }
        }

        input.close();
    }

    public static float moneyConverter ( float reais, float base ) {
        return reais * base;
    }
}
