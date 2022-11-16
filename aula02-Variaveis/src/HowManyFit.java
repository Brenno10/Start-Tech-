public class HowManyFit {
    public static void main( String[] args ) {
        int chairRows = Integer.parseInt( args[0] );
        int chairsPerRow = Integer.parseInt( args[1] );

        int roomCapacity = ( chairRows * chairsPerRow );

        System.out.printf( "\nA capacidade máxima da sala é de %d pessoas e " +
                        "%.0f delas são reservadas para deficiêntes.\n",
                roomCapacity, roomCapacity * 0.1
        );
    }
}
