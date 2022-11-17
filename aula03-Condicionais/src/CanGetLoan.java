import java.util.Locale;
import java.util.Scanner;

public class CanGetLoan {
    private static final Scanner input = new Scanner( System.in );

    public static void main( String[] args ) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite a sua idade" );
        int age = input.nextInt();

        System.out.println( "\nDigite o seu salário" );
        double salary = input.nextDouble();

        System.out.println( "\nDigite a quantidade do emprestimo" );
        double loan = input.nextDouble();

        System.out.println( "\nDigite a quantidade de parcelas ( min: 3, max: 24 )" );
        int parcels = input.nextInt();

        if ( !verifyLegibility( age, parcels, salary, loan ) ) {
            System.out.println( whyNotAllowed( age, parcels, salary, loan ) );
        }
        else {
            System.out.printf( "\nA pessoa que está solicitando o empréstimo tem %d anos de idade e" +
                            " tem o salário de %.1f reais.\n" +
                            "O valor solicitado é de %.1f reais para ser pago em %d parcelas.\n" +
                            "O empréstimo foi aprovado.",
                    age, salary, loan, parcels);
        }

        input.close();
    }

    private static boolean verifyLegibility ( int _age, int _parcels, double _salary, double _loan ) {
        return _age >= 18 && _age <= 65 && _parcels >= 3 && _parcels <= 24 &&
                _loan / _parcels <= _salary * 0.3;
    }

    private static String whyNotAllowed ( int _age, int _parcels, double _salary, double _loan ) {
        String reason = "\n";

        if ( _age < 18 )
            reason += " - A pessoa que está solicitando o empréstimo é jovem demais\n";
        if ( _age > 65 )
            reason += " - A pessoa que está solicitando o empréstimo é velha demais\n";
        if ( _parcels < 3 )
            reason += " - O mínimo de parcelas são 3\n";
        if ( _parcels > 24 )
            reason += " - O máximo de parcelas são 24\n";
        if ( _loan / _parcels > _salary * 0.3 )
            reason += " - O custo dass parcelas do emprestimo superam %30 do seu salário\n";

        return reason + "O empréstimo foi reprovado.";
    }
}
