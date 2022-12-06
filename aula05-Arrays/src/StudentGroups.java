import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class StudentGroups {
    private static final Scanner input = new Scanner(System.in);
    private static final ArrayList<String> students = new ArrayList<>();

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite o nome de alunos ( para grupos de 3 ), " +
                "digite 'criar' para gerar os grupos" );
        writeNames();
        System.out.println( makeGroups() );

        input.close();
    }

    private static void writeNames() {
        students.clear();

        while ( true ) {
            String student = input.nextLine();

            if ( student.equalsIgnoreCase("criar") )
                break;
            else
                students.add(student);
        }

        if (students.size() % 3 != 0 ) {
            System.out.println( "\nA quantidade de estudantes não é o suficiente para formar grupos de 3" );
            writeNames();
        }
    }

    private static String makeGroups() {
        String result = "";
        int index = 0;

        for ( int j = 0; j < students.size() / 3; j++ ) {
            result += "\nGrupo " + (j + 1) + ":\n";
            for (int i = 0; i < 3; i++) {
                result += students.get(index) + "\n";
                index++;
            }
        }
        return result;
    }
}
