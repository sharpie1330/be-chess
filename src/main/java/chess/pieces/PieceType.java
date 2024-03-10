package chess.pieces;

import java.util.Arrays;

public enum PieceType {
    pawn("♙", "♟"),
    knight("♘", "♞"),
    rook("♖", "♜"),
    bishop("♗", "♝"),
    queen("♕", "♛"),
    king("♔", "♚");

    private final String representationWhite;
    private final String representationBlack;

    PieceType(String representationWhite, String representationBlack) {
        this.representationWhite = representationWhite;
        this.representationBlack = representationBlack;
    }

    public String getRepresentationWhite() {
        return representationWhite;
    }

    public String getRepresentationBlack() {
        return representationBlack;
    }

    public static String getRepresentation(final String name, final String color) {
        PieceType pieceType = Arrays.stream(PieceType.values())
                .filter(rep -> rep.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기물입니다."));

        if (color.equals(Piece.WHITE_COLOR)) {
            return pieceType.representationWhite;
        } else if (color.equals(Piece.BLACK_COLOR)) {
            return pieceType.representationBlack;
        }
        throw new IllegalArgumentException("존재하지 않는 색상입니다.");
    }
}
