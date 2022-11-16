public class CalculateAge {
    private static final int currentYear = 2022;
    private static final int birthDay = 1998;

    public static void main( String[] args ) {
        int age = currentYear - birthDay;

        System.out.println( "\nA idade é " + age );
    }
}
