public class HowManyFit {
    private static final int chairRows = 10;
    private static final int chairsPerRow = 8;

    public static void main( String[] args ) {
        int roomCapacity = (chairRows * chairsPerRow);

        System.out.println( "\nA capacidade máxima da sala é de " + roomCapacity + " pessoas e "
                + roomCapacity * 0.1 + " delas são reservadas para deficiêntes." );
    }
}
