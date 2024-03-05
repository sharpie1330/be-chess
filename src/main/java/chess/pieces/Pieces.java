package chess.pieces;

public enum Pieces {
    WHITE_PAWN(Pieces.WHITE_COLOR, "♙"),
    BLACK_PAWN(Pieces.BLACK_COLOR, "♟");

    public static final String WHITE_COLOR = "white";
    public static final String BLACK_COLOR = "black";

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
