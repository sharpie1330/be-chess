package chess.pieces;

public class Pawn {
    private final String color;

    public Pawn() {
        this.color = Pieces.WHITE_COLOR;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }
}
