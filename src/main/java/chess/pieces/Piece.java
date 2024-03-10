package chess.pieces;

import java.util.Objects;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    private final String color;
    private final String representation;
    private final PieceType pieceType;

    private Piece(String color, String representation, PieceType pieceType) {
        this.color = color;
        this.representation = representation;
        this.pieceType = pieceType;
    }

    public static Piece createWhitePiece(PieceType pieceType) {
        return new Piece(WHITE_COLOR, pieceType.getRepresentationWhite(), pieceType);
    }

    public static Piece createBlackPiece(PieceType pieceType) {
        return new Piece(BLACK_COLOR, pieceType.getRepresentationBlack(), pieceType);
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public boolean isBlack() {
        return getColor().equals(BLACK_COLOR);
    }

    public boolean isWhite() {
        return getColor().equals(WHITE_COLOR);
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, representation);
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return Objects.equals(color, piece.color) && Objects.equals(representation, piece.representation);
    }
}
