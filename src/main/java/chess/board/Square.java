package chess.board;

import chess.pieces.Piece;

import java.util.List;

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

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public void addIfColorMatch(String color, List<Piece> findPieces) {
        if (piece != null && piece.getColor().equals(color)) {
            findPieces.add(piece);
        }
    }
}
