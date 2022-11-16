import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class IfWasApproved {
    private static final ArrayList<Double> scores = new ArrayList<>();
    private static final Scanner input = new Scanner( System.in );

    public static void main( String[] args ) {
        input.useLocale(Locale.US);

        System.out.println( "\nQuantas notas são?" );
        int howManyScores = input.nextInt();

        System.out.println( "\nDigite as notas" );
        for (int i = 0; i < howManyScores; i++ ) {
            scores.add( input.nextDouble() );
        }

        if ( passed( calculateMedia( scores ) ) )
            System.out.printf( "\nO aluno(a) foi aprovado com média de %.1f",
                    calculateMedia( scores ) );
        else
            System.out.printf( "\nO aluno(a) foi reprovado com média de %.1f",
                    calculateMedia( scores ) );

        input.close();
    }

    public static double calculateMedia( ArrayList<Double> _numbers ) {
        double sum = 0;

        for (Double number : _numbers)
            sum += number;

        return sum / _numbers.size();
    }

    private static boolean passed( double media ) {
        return media >= 6;
    }
}
