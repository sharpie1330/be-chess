package chess.pieces;

import java.util.Arrays;

public enum PieceType {
    pawn("♙", "♟", 1.0),
    knight("♘", "♞", 2.5),
    rook("♖", "♜", 5.0),
    bishop("♗", "♝", 3.0),
    queen("♕", "♛", 9.0),
    king("♔", "♚", 0.0);

    private final String representationWhite;
    private final String representationBlack;
    private final double defaultPoint;

    PieceType(String representationWhite, String representationBlack, double defaultPoint) {
        this.representationWhite = representationWhite;
        this.representationBlack = representationBlack;
        this.defaultPoint = defaultPoint;
    }

    public String getRepresentationWhite() {
        return representationWhite;
    }

    public String getRepresentationBlack() {
        return representationBlack;
    }

    public double getDefaultPoint() {
        return defaultPoint;
    }

    public static double getDefaultPoint(final String name) {
        PieceType pieceType = getPieceType(name);

        return pieceType.getDefaultPoint();
    }

    public static PieceType getPieceType(String name) {
        return Arrays.stream(PieceType.values())
                .filter(p -> p.name().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 기물입니다."));
    }
}
