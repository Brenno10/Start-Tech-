import java.util.Locale;
import java.util.Scanner;

public class KilometersToMiles {
    private static final float baseNum = 1.609f;

    private static final Scanner input = new Scanner( System.in );

    public static void main( String[] args ) {
        input.useLocale(Locale.US);

        System.out.println( "\nKilometros para serem convertidos" );
        float km = input.nextFloat();

        System.out.println( "\nA converesão de " + km + "Km para milhas é " + kmToMiles(km, baseNum ) );

        input.close();
    }

    public static float kmToMiles ( float _km, float _base ) {
        return _km / _base;
    }
}
