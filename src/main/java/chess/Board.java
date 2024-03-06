package chess;

import chess.pieces.Pawn;
import utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

import static utils.StringUtils.*;

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
            String line = "";
            if (i == 1) {
                line = getBlackPawnsResult();
            } else if (i == 6) {
                line = getWhitePawnsResult();
            } else {
                line = BLANK_SPACE.repeat(LENGTH);
            }
            boardString.append(appendNewLine(line));
        }

        boardString.deleteCharAt(boardString.length() - 1);

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
