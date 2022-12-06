import java.util.ArrayList;
import java.util.Scanner;

public class MostLettersWord {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<String> words = new ArrayList<>();
    private static boolean run = true;

    public static void main(String[] args) {
        System.out.println( "\nDigite qualquer quantidade de palavras ( digite 'stop' para parar )" );
        while ( run ) {
            String word = input.nextLine();

            if ( word.equalsIgnoreCase("stop") )
                run = false;
            else
                words.add(word);
        }

    System.out.printf( "\nA maior palavra é %s, com %d letras\n",
            words.get( getLargestWord() ), words.get( getLargestWord() ).length() );

        input.close();
    }

    private static int getLargestWord() {
        String largest = "";
        int result = 0;

        for (int i = 0; i < MostLettersWord.words.size(); i++ ) {
            if ( words.get(i).length() > largest.length() ) {
                largest = MostLettersWord.words.get(i);
                result = i;
            }
        }

        return result;
    }
}
