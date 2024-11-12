import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        char[][] board = new char[3][3];
        initBoard(board);

        char player = 'X';
        Scanner scanner = new Scanner(System.in);


        while (true) {

            printBoard(board);
            System.out.println("Player " + player + ", enter row and column:");

            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (board[row][col] == ' ') {
                board[row][col] = player;

                if (checkWin(board, player)) {
                    printBoard(board);
                    System.out.println("Player " + player + " wins!");
                    break;
                }

                if (player == 'X') {
                    player = 'O';
                } else {
                    player = 'X';
                }
            } else {
                System.out.println("Occupied. Try again.");
            }
        }

        scanner.close();
    }

    private static void initBoard(char[][] board) {

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    private static void printBoard(char[][] board) {

        for (char[] row : board) {
            for (char cell : row) {

                System.out.print(cell + " | ");
            }
            System.out.println();
        }
    }

    private static boolean checkWin(char[][] board, char player) {

        for (int i = 0; i < 3; i++) {
            
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }

            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }

        return board[0][2] == player && board[1][1] == player && board[2][0] == player;
    }
}