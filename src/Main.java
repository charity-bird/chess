import java.util.Scanner;

import Model.Chess;
public class Main {

    public Chess chessboard;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Chess chess = new Chess();
        while(chess.game.gameOver() == false) {
            chess.game.printBoard();
            String move = sc.nextLine();
            chess.game.move(move);
        }

    }
}