import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class MostExpensive {
    private static final Scanner input = new Scanner( System.in );
    private static boolean run = true;
    private static final ArrayList<String> products = new ArrayList<>();
    private static final ArrayList<Double> prices = new ArrayList<>();

    public static void main( String[] args ) {
        input.useLocale(Locale.US);

        while ( run ) {
            System.out.println( "\nDigite o nome do produto (digite 'end' para finalizar)" );
            String item = input.nextLine();

            if ( item.trim().equals( "end" ) ) {
                run = false;
            }
            else {
                System.out.println( "\nDigite o preço do produto" );
                double price = Double.parseDouble(input.nextLine());

                products.add( item);
                prices.add( price );
            }
        }

        System.out.printf( "\n%s é o mais caro", getMostExpensive() );

        input.close();
    }

    private static String getMostExpensive() {
        int toReturn = 0;
        double currentItem = 0;

        for (int i = 0; i < products.size(); i++ ) {
            if ( prices.get(i) > currentItem) {
                toReturn = i;
                currentItem = prices.get(i);
            }
        }

        return products.get(toReturn);
    }
}
