public class CalculateAge {
    public static void main( String[] args ) {
        int currentYear = Integer.parseInt( args[0] );
        int birthYear = Integer.parseInt( args[1] );

        int age = currentYear - birthYear;

        System.out.println( "\nA idade é " + age );
    }
}
