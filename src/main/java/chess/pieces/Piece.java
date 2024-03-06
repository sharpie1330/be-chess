package chess.pieces;

import chess.Board;

import java.util.Objects;

import static chess.pieces.Representation.*;

public class Piece {
    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

    private final String color;
    private final String representation;

    private Piece(String color, String representation) {
        this.color = color;
        this.representation = representation;
    }

    public static Piece createWhitePawn() {
        return new Piece(WHITE_COLOR, pawn.getRepresentation_white());
    }

    public static Piece createBlackPawn() {
        return new Piece(BLACK_COLOR, pawn.getRepresentation_black());
    }

    public static Piece createWhiteKnight() {
        return new Piece(WHITE_COLOR, knight.getRepresentation_white());
    }

    public static Piece createBlackKnight() {
        return new Piece(BLACK_COLOR, knight.getRepresentation_black());
    }

    public static Piece createWhiteRook() {
        return new Piece(WHITE_COLOR, rook.getRepresentation_white());
    }

    public static Piece createBlackRook() {
        return new Piece(BLACK_COLOR, rook.getRepresentation_black());
    }

    public static Piece createWhiteBishop() {
        return new Piece(WHITE_COLOR, bishop.getRepresentation_white());
    }

    public static Piece createBlackBishop() {
        return new Piece(BLACK_COLOR, bishop.getRepresentation_black());
    }

    public static Piece createWhiteQueen() {
        return new Piece(WHITE_COLOR, queen.getRepresentation_white());
    }

    public static Piece createBlackQueen() {
        return new Piece(BLACK_COLOR, queen.getRepresentation_black());
    }

    public static Piece createWhiteKing() {
        return new Piece(WHITE_COLOR, king.getRepresentation_white());
    }

    public static Piece createBlackKing() {
        return new Piece(BLACK_COLOR, king.getRepresentation_black());
    }

    public static Piece createBlankSquare() {
        return new Piece("", Board.BLANK_SPACE);
    }

    public String getColor() {
        return color;
    }

    public String getRepresentation() {
        return representation;
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
