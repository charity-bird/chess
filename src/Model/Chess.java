package Model;

import java.util.ArrayList;
import java.util.List;

/**
 * With reference to https://www.geeksforgeeks.org/design-a-chess-game/
 */
public class Chess {

    public class Spot{
        private int x;
        private int y;
        private Piece piece;

        public Spot(int x, int y, Piece piece) {
            this.setX(x);
            this.setY(y);
            this.setPiece(piece);
        }
        public void setX(int x) { this.x = x; }
        public void setY(int y) { this.y = y; }
        public int getX() { return this.x; }
        public int getY() { return this.y; }
        public void setPiece(Piece piece) { this.piece = piece; }
        public Piece getPiece() { return this.piece;}
        public String toString() {
            String row;
            if (this.x == 0) row = "a";
            else if (this.x == 1) row = "b";
            else if (this.x == 2) row = "c";
            else if (this.x == 3) row = "d";
            else if (this.x == 4) row = "e";
            else if (this.x == 5) row = "f";
            else if (this.x == 6) row = "g";
            else row = "h";
            return row+Integer.toString(y);
        }
    }
    public abstract class Piece {
        private boolean white;
        private boolean killed;

        public Piece(boolean white) {
            this.setWhite(white);
        }
        public boolean isWhite() { return this.white; }
        public boolean isKilled() { return this.killed; }
        public void setWhite(boolean white) { this.white = white; }
        public void setKilled(boolean killed) { this.killed = killed; }
        public abstract boolean canMove(Board board, Spot start, Spot end);
        public abstract String toString();
    }

    public class Pawn extends Piece {
        public Pawn(boolean white) {
            super(white);
        }
        public boolean canMove(Board board, Spot start, Spot end) {
            if (end.getPiece() != null
                && end.getPiece().isWhite() == this.isWhite())
                return false;

            return true;
        }
        public String toString() {
            if (this.isWhite())
                return "♙";
            else
                return "♟\uFE0E";
        }
    }
    public class Rook extends Piece {
        public Rook(boolean white) {
            super(white);
        }
        public boolean canMove(Board board, Spot start, Spot end) {
            if (end.getPiece().isWhite() == this.isWhite())
                return false;
            return false;
        }
        public String toString() {
            if (this.isWhite())
                return "♖";
            else
                return "♜";
        }
    }
    public class Knight extends Piece {
        public Knight(boolean white) {
            super(white);
        }
        public boolean canMove(Board board, Spot start, Spot end) {
            if (end.getPiece().isWhite() == this.isWhite())
                return false;
            return false;
        }
        public String toString() {
            if (this.isWhite())
                return "♘";
            else
                return "♞";
        }
    }
    public class Bishop extends Piece {
        public Bishop(boolean white) {
            super(white);
        }
        public boolean canMove(Board board, Spot start, Spot end) {
            if (end.getPiece().isWhite() == this.isWhite())
                return false;
            return false;
        }
        public String toString() {
            if (this.isWhite())
                return "♗";
            else
                return "♝";
        }
    }
    public class Queen extends Piece {
        public Queen(boolean white) {
            super(white);
        }
        public boolean canMove(Board board, Spot start, Spot end) {
            if (end.getPiece().isWhite() == this.isWhite())
                return false;
            return false;
        }
        public String toString() {
            if (this.isWhite())
                return "♕";
            else
                return "♛";
        }
    }
    public class King extends Piece {
        private boolean castlingDone = false;

        public King(boolean white) {
            super(white);
        }
        public boolean isCastlingDone() { return this.castlingDone; }
        public void setCastlingDone(boolean castlingDone) { this.castlingDone = castlingDone; }
        public boolean canMove(Board board, Spot start, Spot end) {
            if (end.getPiece().isWhite() == this.isWhite())
                return false;
            return false;
        }
        public String toString() {
            if (this.isWhite())
                return "♔";
            else
                return "♚";
        }
    }

    public class Board {
        public Spot[][] board;

        public Board() {
            board = new Spot[8][8];
            initializeBoard();
        }

        public void initializeBoard() {
            board[0][0] = new Spot(0,0, new Rook(true));
            board[0][1] = new Spot(0,1, new Knight(true));
            board[0][2] = new Spot(0,2, new Bishop(true));
            board[0][3] = new Spot(0,3, new Queen(true));
            board[0][4] = new Spot(0,4, new King(true));
            board[0][5] = new Spot(0,5, new Bishop(true));
            board[0][6] = new Spot(0,6, new Knight(true));
            board[0][7] = new Spot(0,7, new Rook(true));
            board[1][0] = new Spot(1,0, new Pawn(true));
            board[1][1] = new Spot(1,1, new Pawn(true));
            board[1][2] = new Spot(1,2, new Pawn(true));
            board[1][3] = new Spot(1,3, new Pawn(true));
            board[1][4] = new Spot(1,4, new Pawn(true));
            board[1][5] = new Spot(1,5, new Pawn(true));
            board[1][6] = new Spot(1,6, new Pawn(true));
            board[1][7] = new Spot(1,7, new Pawn(true));
            board[6][0] = new Spot(6,0, new Pawn(false));
            board[6][1] = new Spot(6,1, new Pawn(false));
            board[6][2] = new Spot(6,2, new Pawn(false));
            board[6][3] = new Spot(6,3, new Pawn(false));
            board[6][4] = new Spot(6,4, new Pawn(false));
            board[6][5] = new Spot(6,5, new Pawn(false));
            board[6][6] = new Spot(6,6, new Pawn(false));
            board[6][7] = new Spot(6,7, new Pawn(false));
            board[7][0] = new Spot(7,0, new Rook(false));
            board[7][1] = new Spot(7,1, new Knight(false));
            board[7][2] = new Spot(7,2, new Bishop(false));
            board[7][3] = new Spot(7,3, new Queen(false));
            board[7][4] = new Spot(7,4, new King(false));
            board[7][5] = new Spot(7,5, new Bishop(false));
            board[7][6] = new Spot(7,6, new Knight(false));
            board[7][7] = new Spot(7,7, new Rook(false));
            for(int i = 2; i < 6; i++) {
                for(int j = 0; j < 8; j++) {
                    board[i][j] = new Spot(i,j,null);
                }
            }
        }

        public Spot getSpot(int x, int y) {
            return board[x][y];
        }

    }

    public static abstract class Player {
        public boolean white;
        public boolean humanPlayer;
        public Player(boolean white) {
            this.white = white;
        }
        public boolean isHumanPlayer() { return this.humanPlayer; }
        public boolean isWhite() { return this.white; }
        public String toString() {
            String playerType = "";
            if (this.white && this.humanPlayer)
                return "White Human Player";
            else if (this.white && !this.humanPlayer)
                return "Black Computer Player";
            else if (!this.white && this.humanPlayer)
                return "Black Human Player";
            else
                return "White Computer Player";
        }
    }
    public static class HumanPlayer extends Player {
        public HumanPlayer(boolean white) {
            super(white);
            this.humanPlayer = true;
        }
    }
    public static class ComputerPlayer extends Player {
        public ComputerPlayer(boolean white) {
            super(white);
            this.humanPlayer = false;
        }
    }

    public class Move {
        private Player player;
        private Spot start;
        private Spot end;

        public Move(Player player, Spot start, Spot end) {
            this.player = player;
            this.start = start;
            this.end = end;
        }
        public String toString() {
            return "Player: " + player.toString()
                    + " Start: " + start.getX() + "," + start.getY()
                    + " End: " + end.getX() + "," + end.getY();
        }
    }

    public enum GameStatus {
        ACTIVE,
        BLACK_WIN,
        WHITE_WIN,
        STALEMATE,
        FORFIEGHT,
        RESIGNATION
    }

    public class Game {

        private Board board;
        private List<Move> movesPlayed;
        private GameStatus gameStatus;



        public Game() {
            movesPlayed = new ArrayList<Move>();
            board = new Board();
        }

        public void setStatus(GameStatus status) { this.gameStatus = status; }

        public boolean gameOver() {
            return false;
        }

        public boolean playerMove(Player player, int startX, int startY, int endX, int endY) {
            Spot startBox = board.getSpot(startX, startY);
            Spot endBox = board.getSpot(endX, endY);
            Move move = new Move(player, startBox, endBox);
            return this.makeMove(move, player);
        }

        public boolean makeMove(Move move, Player player) {
            System.out.println(move.toString());

            Piece sourcePiece = move.start.getPiece();
            if (sourcePiece == null) {
                return false;
            }

            if (sourcePiece.isWhite() != player.isWhite()) {
                return false;
            }

            if (!sourcePiece.canMove(board, move.start, move.end)) {
                return false;
            }

            // kill?
            Piece destPiece = move.start.getPiece();
            if (destPiece != null) {
                destPiece.setKilled(true);
            }

            // store the move
            movesPlayed.add(move);

            // move piece from the start of the box to the end of the box
            move.end.setPiece(move.start.getPiece());
            move.start.setPiece(null);

            if (destPiece != null && destPiece instanceof King) {
                if (player.isWhite()) {
                    this.setStatus(GameStatus.WHITE_WIN);
                }
                else {
                    this.setStatus(GameStatus.BLACK_WIN);
                }
            }


            return false;
        }

        public void printMove() {
            System.out.println("This is a move");
        }

        public void printBoard() {
            for(int i = 0; i <= 7; i++) {
                for(int j = 0; j <= 7; j++) {
                    if (this.board.board[i][j].getPiece() != null) {
                        System.out.print("\t["+board.board[i][j].getPiece().toString()+"]");
                    } else {
                        System.out.print("\t["+board.board[i][j].toString()+"]");
                    }
                }
                System.out.println();
            }
            System.out.println("This is a chessboard");
        }
    }

    public Game game;
    public Chess() {
        game = new Game();
    }
}
