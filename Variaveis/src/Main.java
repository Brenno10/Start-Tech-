public class Main {
    private static int num1 = 2;
    private static int num2 = 2;

    public static void main( String[] args ) {
        System.out.printf( "%d + %d = %d", num1, num2, sum( num1, num2 ) );
    }

    public static int sum ( int _num1, int _num2 ) {
        return _num1 + _num2;
    }
}
