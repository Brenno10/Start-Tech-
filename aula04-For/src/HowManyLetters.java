import java.util.Locale;
import java.util.Scanner;

public class HowManyLetters {
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        String word;
        String letter;

        do {
            System.out.println("\nDigite a palavra a ser verificada.");
            word = input.nextLine();

            System.out.println("\nDigite a letra que você quer verificar");
            letter = input.nextLine();

            if ( !verifyWord(word) && !verifyLetter(letter) )
                System.out.println(verifyErrors(word, letter));
        } while ( !verifyWord(word) && !verifyLetter(letter) );

        if ( countLetters(word, letter) == 0 ) {
            System.out.printf( "\nNão houve nenhum caso da letra %s na palavra %s",
                    letter, word);
        }
        else {
            System.out.printf("\nHouveram %d casos da letra %s na palavra %s.",
                    countLetters(word, letter), letter, word);
        }

        input.close();
    }

    private static String verifyErrors(String _str, String _char) {
        String errors = "\n";

        if (isNaN(_str))
            errors += _str + " é um número!\n";
        if (isNaN(_char))
            errors += _char + " é um número!\n";
        if ( _str.trim().split("").length <= 1 )
            errors += _str + " é pequeno demais para ser uma palavra!\n";
        if ( _char.trim().split("").length > 1 )
            errors += "Digite apenas uma letra!\n";

        return errors;
    }

    private static int countLetters(String _str, String _char) {
        String[] splitWord = _str.trim().toLowerCase().split("");
        int counter = 0;

        for ( String s : splitWord ) {
            if ( verifyLetter(_char) && verifyWord(_str) && s.equalsIgnoreCase(_char) ) {
                counter++;
            }
        }

        return counter;
    }

    private static boolean verifyWord(String _str) {
        return !isNaN(_str) && _str.trim().split("").length > 1;
    }

    private static boolean verifyLetter(String _char) {
        return !isNaN(_char) && _char.trim().split("").length == 1;
    }

    private static boolean isNaN(String _str ) {
        if (_str == null) {
            return false;
        }
        try {
            Double.parseDouble(_str);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
}
