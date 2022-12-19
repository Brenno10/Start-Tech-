package poolVolume;

import tools.Tools;

public class Main {
    public static void main(String[] args) {
        double width = Tools.scanDouble("Digite a largura:" );
        double length = Tools.scanDouble("Digite o comprimento:");
        double depth = Tools.scanDouble("Digite a profundidade:");

        Pool pool = new Pool(width, length, depth);
        System.out.printf( "O volume dessa psina é %.2f m³.", pool.calculateVolume() );
    }
}
