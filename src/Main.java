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
            if (move.charAt(0) == 'a') { startX = 0; }
            if (move.charAt(0) == 'b') { startX = 1; }
            if (move.charAt(0) == 'c') { startX = 2; }
            if (move.charAt(0) == 'd') { startX = 3; }
            if (move.charAt(0) == 'e') { startX = 4; }
            if (move.charAt(0) == 'f') { startX = 5; }
            if (move.charAt(0) == 'g') { startX = 6; }
            if (move.charAt(0) == 'h') { startX = 7; }
            int startY = charToInteger(move.charAt(1));

            int endX = -1;
            if (move.charAt(3) == 'a') { endX = 0; }
            if (move.charAt(3) == 'b') { endX = 1; }
            if (move.charAt(3) == 'c') { endX = 2; }
            if (move.charAt(3) == 'd') { endX = 3; }
            if (move.charAt(3) == 'e') { endX = 4; }
            if (move.charAt(3) == 'f') { endX = 5; }
            if (move.charAt(3) == 'g') { endX = 6; }
            if (move.charAt(3) == 'h') { endX = 7; }
            int endY = charToInteger(move.charAt(4));

            chess.game.playerMove(humanPlayer, startX, startY, endX, endY);
        }

    }
}