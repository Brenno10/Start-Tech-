import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class FindSmallestAndLargest {
    private static final Scanner input = new Scanner( System.in );
    private static final ArrayList<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite qualquer quantidade de números." );
        String str = input.nextLine();

        String[] splited = str.trim().split("\\s+");
        for ( String num : splited ) {
            numbers.add(Integer.parseInt(num));
        }

        if ( numbers.size() == 1 ) {
            System.out.print( "\nO número selecionado foi " + numbers.get(0) );
        }
        else {
            System.out.print("Os números digitados foram ");
            for (int i = 0; i < numbers.size(); i++) {
                if (i == numbers.size() - 1) {
                    System.out.printf("%d.", numbers.get(i));
                } else if (i == numbers.size() - 2) {
                    System.out.printf("%d e ", numbers.get(i));
                } else {
                    System.out.printf("%d, ", numbers.get(i));
                }
            }
        }

        System.out.println( getAnswer() );

        input.close();
    }

    private static String getAnswer() {
        int smallest = numbers.get(0);
        int largest = numbers.get(0);

        for ( int j : numbers ) {
            if ( j > largest ) {
                largest = j;
            }
            if ( j < smallest ) {
                smallest = j;
            }
        }

        if ( smallest == largest ) {
            return "\nO número " + smallest + " é o único número.";
        }

        return "\nO maior número é o " + largest + ", e o menor número é " + smallest + ".";
    }
}
