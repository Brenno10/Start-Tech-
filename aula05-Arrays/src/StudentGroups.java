import java.util.*;

public class StudentGroups {
    private static final Scanner input = new Scanner(System.in);
    private static final Random rand = new Random();
    private static final ArrayList<String> students = new ArrayList<>();

    public static void main(String[] args) {
        input.useLocale(Locale.US);

        System.out.println( "\nDigite o nome de alunos ( para grupos de 3 ), " +
                "digite 'criar' para gerar os grupos" );
        writeNames();
        if ( students.size() == 3 ) {
            System.out.printf("""

                    Grupo 1
                    %s
                    %s
                    %s
                    """,
                    students.get(0), students.get(1), students.get(2));
        }
        else
            makeRandomGroups();

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

    private static void makeRandomGroups() {
        List<Integer> indexArr = new ArrayList<>();
        int index = rand.nextInt( 0, students.size() );
        indexArr.add(index);

        for ( int i = 0; i < students.size(); i++ ) {
            index = rand.nextInt( 0, students.size() );
            if ( !isRepeatedIndex(index, indexArr) ) {
                indexArr.add( index );
            } else if ( i != 0 && indexArr.size() != students.size() )
                i--;
        }

        for ( int j = 0; j < students.size() / 3; j++ ) {
            System.out.println("\nGrupo" + (j + 1) + " :");
            for (int i = 0; i < 3; i++) {
                if ( indexArr.size() != 0 ) {
                    if ( indexArr.size() == 3 ) {
                        System.out.println(students.get(indexArr.get(2)));
                        indexArr.remove(2);
                    } else if ( indexArr.size() == 2 ) {
                        System.out.println(students.get(indexArr.get(1)));
                        indexArr.remove(1);
                    } else {
                        System.out.println(students.get(indexArr.get(0)));
                        indexArr.remove(0);
                    }
                }
            }
        }
    }

    public static boolean isRepeatedIndex(int index, List<Integer> list) {
        for ( int i : list ) {
            if ( i == index )
                return true;
        }
        return false;
    }
}
