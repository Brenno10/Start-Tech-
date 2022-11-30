import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class TicTocToe {
    private static final Random rand = new Random();
    private static final Scanner input = new Scanner( System.in );
    private static boolean draw = false;
    private static String winner;
    private static final String[] gameBoard  = {
            "_", "_", "_",
            "_", "_", "_",
            "_", "_", "_",
    };

    public static void main(String[] args) {
        input.useLocale( Locale.US );

        gameStart();

        input.close();
    }

    private static void gameStart() {
        int nextPlayerIndex = rand.nextInt(1, 3);
        String lastPlayedLeter = "";
        boolean run = true;
        int[] position = new int[2];

        while ( run ) {
            setGameBoard();

            switch (nextPlayerIndex) {
                case 1 -> {
                    lastPlayedLeter = "x";
                    System.out.println("\nPróximo jogador: x");
                }
                case 2 -> {
                    lastPlayedLeter = "o";
                    System.out.println("\nPróximo jogador: o");
                }
            }
            System.out.println( "Escolha a posição (horizontal e vertical)" );
            String pos = input.nextLine();

            if ( pos.equalsIgnoreCase("stop") ) {
                System.out.println( "\nO jogador " + lastPlayedLeter + " desistiu do jogo." );
                break;
            }

            String[] splitNum = pos.trim().split("\\s+");
            while ( !isNaN(splitNum) ) {
                System.out.println( "\n - Posição inválida - " );
                setGameBoard();

                splitNum = input.nextLine().trim().split("\\s+");
            }

            for ( int i = 0; i < position.length; i++ ) {
                position[i] =  Integer.parseInt(splitNum[i]);
            }

            if ( position[0] <= 3 && position[1] >= 1 && gameBoard[getPosition(position)].equals("_") ) {
                if ( nextPlayerIndex == 1 ) {
                    gameBoard[getPosition(position)] = "x";
                    lastPlayedLeter = "x";
                    nextPlayerIndex = 2;
                } else {
                    gameBoard[getPosition(position)] = "o";
                    lastPlayedLeter = "o";
                    nextPlayerIndex = 1;
                }

                if ( verifyWinner(lastPlayedLeter) && !draw ) {
                    setGameBoard();
                    System.out.printf( "\n%s é o vencedor!", winner );
                    run = false;
                } else if ( !verifyWinner(lastPlayedLeter) && draw ) {
                    setGameBoard();
                    System.out.println( "\nFoi um empate!" );
                    run = false;
                }
            } else
                System.out.println( "\n - Posição inválida - " );
        }
    }

    private static int getPosition(int[] pos) {
        int x = pos[0], y = pos[1];
        int result = 0;

        if ( x == 1 && y == 1 )
            return result;
        else if ( x == 2 && y == 1 )
            result = 1;
        else if ( x == 3 && y == 1 )
            result = 2;
        else if ( x == 1 && y == 2 )
            result = 3;
        else if ( x == 2 && y == 2 )
            result = 4;
        else if ( x == 3 && y == 2 )
            result = 5;
        else if ( x == 1 && y == 3 )
            result = 6;
        else if ( x == 2 && y == 3 )
            result = 7;
        else if ( x == 3 && y == 3 )
            result = 8;

        return result;
    }

    private static boolean verifyWinner(String l) {
        boolean won = false;
        String[] i = gameBoard;

        if (i[0].equalsIgnoreCase(l) && i[1].equalsIgnoreCase(l) && i[2].equalsIgnoreCase(l)) {
            winner = l;
            won = true;
        } else if (i[3].equalsIgnoreCase(l) && i[4].equalsIgnoreCase(l) && i[5].equalsIgnoreCase(l)) {
            winner = l;
            won = true;
        } else if (i[6].equalsIgnoreCase(l) && i[7].equalsIgnoreCase(l) && i[8].equalsIgnoreCase(l)) {
            winner = l;
            won = true;
        } else if (i[0].equalsIgnoreCase(l) && i[3].equalsIgnoreCase(l) && i[6].equalsIgnoreCase(l)) {
            winner = l;
            won = true;
        } else if (i[1].equalsIgnoreCase(l) && i[4].equalsIgnoreCase(l) && i[7].equalsIgnoreCase(l)) {
            winner = l;
            won = true;
        } else if (i[2].equalsIgnoreCase(l) && i[5].equalsIgnoreCase(l) && i[8].equalsIgnoreCase(l)) {
            winner = l;
            won = true;
        } else if (i[0].equalsIgnoreCase(l) && i[4].equalsIgnoreCase(l) && i[8].equalsIgnoreCase(l)) {
            winner = l;
            won = true;
        } else if (i[2].equalsIgnoreCase(l) && i[4].equalsIgnoreCase(l) && i[6].equalsIgnoreCase(l)) {
            winner = l;
            won = true;
        } else if ( isComplete() ) {
            draw = true;
        }

        return won;
    }

    private static boolean isComplete() {
        boolean toReturn = true;

        for (String s : gameBoard) {
            if (s.equalsIgnoreCase("_")) {
                toReturn = false;
                break;
            }
        }

        return toReturn;
    }

    private static void setGameBoard() {
        System.out.printf(
                """
                           
                           1   2   3
                        1  %s | %s | %s
                        2  %s | %s | %s
                        3  %s | %s | %s
                        """,
                gameBoard[0], gameBoard[1], gameBoard[2],
                gameBoard[3], gameBoard[4], gameBoard[5],
                gameBoard[6], gameBoard[7], gameBoard[8]);
    }

    private static boolean isNaN( String[] _str ) {
        for ( String s : _str ) {
            if (s == null) {
                return false;
            }
            try {
                Double.parseDouble(s);
            } catch (NumberFormatException nfe) {
                return false;
            }
        }
        return true;
    }
}
