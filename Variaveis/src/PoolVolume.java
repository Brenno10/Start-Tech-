import java.util.Locale;
import java.util.Scanner;

public class PoolVolume {
    private static final Scanner input = new Scanner( System.in );

    public static void main( String[] args ) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite a profundidade inicial" );
        float inicialDepth = input.nextFloat();

        System.out.println( "\nDigite a profundidade final (deixe 0 para ignorar)" );
        float finalDepth = input.nextFloat();

        System.out.println( "\nDigite a largura" );
        float width = input.nextFloat();

        System.out.println( "\nDigite a comprimento" );
        float length = input.nextFloat();

        System.out.println( "\nEssa piscina comporta " +
                metricVolumeCalc( inicialDepth, finalDepth, width, length ) + " litros de água");

        input.close();
    }

    public static float metricVolumeCalc ( float _iDepth, float _fDepth, float _width, float _length ) {
        float _depth = (_iDepth + _fDepth) / 2;

        return (_depth * _width * _length) * 1000;
    }
}
