import java.util.Random;
import java.util.Scanner;

public class Dice {
    private static final Scanner input = new Scanner(System.in);
    private static final Random rand = new Random();

    public static void main(String[] args) {
        System.out.println( "\nDigite quantos grupos seram sorteados" );
        int groups = input.nextInt();

        System.out.println( "\nDigite quantos dados seram lançados por grupo" );
        int times = input.nextInt();

        int[][] randNumGroup = new int[groups][times];

        for ( int i = 0; i < groups; i++ ) {
            for ( int j = 0; j < times; j++ ) {
                randNumGroup[i][j] = rand.nextInt(1,7);
            }
        }

        System.out.println( writeResult( groups, times, randNumGroup, sumArrOfArr( randNumGroup ) ) );

        input.close();
    }

    private static int[] sumArrOfArr(int[][] n) {
        int[] sumGroups = new int[n.length];

        for ( int i = 0; i < n.length; i++ ) {
            for ( int j : n[i] ) {
                sumGroups[i] += j;
            }
        }

        return sumGroups;
    }

    private static String writeResult(int g, int t, int[][] arr, int[] sum) {
        StringBuilder result = new StringBuilder("\n");

        for ( int i = 0; i < g; i++ ) {
            for ( int j = 0; j < t + 1; j++ ) {
                if ( j == 0 ) {
                    result.append(arr[i][j]);
                }
                else if ( j == t ) {
                    result.append(" = ").append(sum[i]).append("\n");
                }
                else {
                    result.append(" + ").append(arr[i][j]);
                }
            }
        }

        return result.toString();
    }
}
