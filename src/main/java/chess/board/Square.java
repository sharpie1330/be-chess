package chess.board;

import chess.pieces.Piece;

public class Square {
    private Piece piece;

    public Square() {
    }

    public boolean isEqualPiece(Piece piece) {
        return piece != null && piece.equals(this.piece);
    }

    public Square(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        return piece;
    }
}
