package chess.pieces;

public enum Representation {
    pawn("♙", "♟"),
    knight("♘", "♞"),
    rook("♖", "♜"),
    bishop("♗", "♝"),
    queen("♕", "♛"),
    king("♔", "♚");

    private final String representation_white;
    private final String representation_black;

    Representation(String representation_white, String representation_black) {
        this.representation_white = representation_white;
        this.representation_black = representation_black;
    }

    public String getRepresentation_white() {
        return representation_white;
    }

    public String getRepresentation_black() {
        return representation_black;
    }
}
