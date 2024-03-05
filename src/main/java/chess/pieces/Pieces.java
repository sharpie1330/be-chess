package chess.pieces;

public enum Pieces {
    WHITE_PAWN(Pawn.WHITE_COLOR, "♙"),
    BLACK_PAWN(Pawn.BLACK_COLOR, "♟");

    private final String color;
    private final String icon;

    Pieces(String color, String icon) {
        this.color = color;
        this.icon = icon;
    }

    public String getColor() {
        return color;
    }

    public String getIcon() {
        return icon;
    }
}
