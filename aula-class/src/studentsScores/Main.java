package studentsScores;

import tools.Tools;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        int studentsAmount = Tools.scanInt( "Digite a quantidade de alunos:" );
        int scoresAmount = Tools.scanInt( "Digite a quantidade de notas:" );

        for ( int i = 0; i < studentsAmount; i++ ) {
            List<Double> scores = new ArrayList<>();
            String name = Tools.scanString( "Digite o nome do aluno:" );
            for ( int j = 0; j < scoresAmount; j++ ) {
                double score = Tools.scanDouble( "Digite a nota " + (j + 1) );
                if ( score >= 0 && score <= 10 )
                    scores.add( score );
                else {
                    System.out.println( "\nSó são aceitas notas de 0 á 10" );
                    j--;
                }
            }
            students.add(new Student( name, scores ));
        }

        for ( Student student : students ) {
            System.out.println( "\nNome: " + student.name );
            System.out.print( "Notas: [" );
            for ( int i = 0; i < scoresAmount; i++ ) {
                if ( i != student.scores.size() - 1  )
                    System.out.printf( "%.1f / ", student.scores.get(i));
                else
                    System.out.printf( "%.1f]", student.scores.get(i));
            }
        }
    }
}
