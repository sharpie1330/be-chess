package chess;

import chess.pieces.Pawn;

import java.util.ArrayList;
import java.util.List;

public class Board {
    public static final String BLANK_SPACE = "▯";
    public static final int LENGTH = 8;

    private List<Pawn> whitePawns;
    private List<Pawn> blackPawns;

    private List<Pawn> pawns;

    public Board() {

    }

    public void initialize() {
        whitePawns = pawnsInit(Pawn.WHITE_COLOR, Pawn.WHITE_REPRESENTATION);
        blackPawns = pawnsInit(Pawn.BLACK_COLOR, Pawn.BLACK_REPRESENTATION);
    }

    private List<Pawn> pawnsInit(final String color, final String representation) {
        pawns = new ArrayList<>();
        for (int i = 0; i < LENGTH; i++) {
            add(new Pawn(color, representation));
        }
        return List.copyOf(pawns);
    }


    public void print() {
        StringBuilder boardString = new StringBuilder();

        for (int i = 0; i < LENGTH; i++) {
            if (i == 1) {
                boardString.append(getBlackPawnsResult());
            } else if (i == 6) {
                boardString.append(getWhitePawnsResult());
            } else {
                boardString.append(BLANK_SPACE.repeat(LENGTH));
            }
            boardString.append("\n");
        }

        boardString.replace(boardString.length() - 1, boardString.length(), "");

        System.out.println(boardString);
    }

    public void add(Pawn pawn) {
        pawns.add(pawn);
    }

    public int size() {
        return pawns.size();
    }

    public Pawn findPawn(int index) {
        return pawns.get(index);
    }

    public String getWhitePawnsResult() {
        return whitePawns.stream().map(Pawn::getRepresentation).reduce("", (x, y) -> x + y);
    }

    public String getBlackPawnsResult() {
        return blackPawns.stream().map(Pawn::getRepresentation).reduce("", (x, y) -> x + y);
    }
}
