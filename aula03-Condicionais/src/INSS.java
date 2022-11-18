import java.util.Locale;
import java.util.Scanner;

public class INSS {
    private static final Scanner input = new Scanner( System.in );
    private static final double[] aliquot = {0.075, 0.09, 0.12, 0.14};
    private static final double[] baseSalary = {1212.00, 2427.35, 3641.03, 7087.22};

    public static void main( String[] args ) {
        input.useLocale( Locale.US );

        System.out.println( "\nDigite seu salário." );
        double salary = input.nextDouble();

        System.out.printf( "\nVocê ira pagar R$%.2f de contribuição ao INSS",
                calc( salary, aliquotLvl( salary ) ) );

        input.close();
    }

    private static int aliquotLvl( double _salary ) {
        int lvl;

        if ( _salary <= baseSalary[0] )
            lvl = 1;
        else if ( _salary > baseSalary[0] && _salary <= baseSalary[1] )
            lvl = 2;
        else if ( _salary > baseSalary[1] && _salary <= baseSalary[2] )
            lvl = 3;
        else
            lvl = 4;

        return lvl;
    }

    private static double calc( double _salary, int _lvl ) {
        double toCalc, result = 0;

        if ( _salary < baseSalary[0] ) {
            result = _salary * aliquot[0];
        }
        else if ( _salary > baseSalary[3] ) {
            result = 828.38;
        }
        else {
            result += baseSalary[0] * aliquot[0];

            for ( int i = 1; i < _lvl; i++ ) {
                if ( _salary < baseSalary[i] ) {
                    toCalc = _salary - baseSalary[i - 1];
                    result += toCalc * aliquot[i];
                    break;
                }
                else {
                    toCalc = baseSalary[i] - baseSalary[i - 1];
                    result += toCalc * aliquot[i];
                }
            }
        }

        return result;
    }
}
