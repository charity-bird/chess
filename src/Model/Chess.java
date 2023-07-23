package Model;

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
            if (end.getPiece().isWhite() == this.isWhite())
                return false;
            int x = Math.abs(start.getX() - end.getX());

            return false;
        }
        public String toString() {
            if (this.isWhite())
                return "P";
            else
                return "p";
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
                return "R";
            else
                return "r";
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
                return "N";
            else
                return "n";
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
                return "B";
            else
                return "b";
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
                return "Q";
            else
                return "q";
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
                return "K";
            else
                return "k";
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
    }

    public class Player {}

    public class Move {}



    public class Game {

        public Board board;


        public Game() {
            board = new Board();
        }

        public boolean gameOver() {
            return false;
        }

        public void move(String move) {
            // TODO: Translate move to move()
        }

        public void printMove() {
            System.out.println("This is a move");
        }

        public void printBoard() {
            for(int i = 0; i <= 7; i++) {
                for(int j = 0; j <= 7; j++) {
                    if (this.board.board[i][j].getPiece() != null) {
                        System.out.print("["+board.board[i][j].getPiece().toString()+"]");
                    } else {
                        System.out.print("[□]");
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
