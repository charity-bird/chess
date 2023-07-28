import java.util.Scanner;

import Model.Chess;
import Model.Chess.HumanPlayer;
import Model.Chess.ComputerPlayer;

public class Main {

    public static int charToInteger(char c) {
        return c - '0';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HumanPlayer humanPlayer = new HumanPlayer(true);
        ComputerPlayer computerPlayer = new ComputerPlayer(false);

        Chess chess = new Chess();
        while(chess.game.gameOver() == false) {
            chess.game.printBoard();

            String move = sc.nextLine();

            int startX = -1;
            int startY = charToInteger(move.charAt(1));
            int endX = -1;
            int endY = charToInteger(move.charAt(4));

            for (int i = 0; i <= 7; i++) {
                if (move.charAt(0) == (char)('a'+i)) { startX = i; }
                if (move.charAt(3) == (char)('a'+i)) { endX = i; }
            }

            System.out.println("Move: startX:" + startX +" startY:"+ startY +" endX:"+ endX +" endY:"+ endY);
            chess.game.playerMove(humanPlayer, startX, startY, endX, endY);
        }

    }
}