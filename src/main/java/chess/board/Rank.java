package chess.board;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Rank {
    public static final String BLANK_SQUARE = "▯";
    public static final int LENGTH = 8;

    private final List<Square> rank;

    public Rank() {
        this.rank = new ArrayList<>();
    }

    public boolean isEmpty() {
        boolean isEmpty = true;
        for (Square square : rank) {
            if (square.getPiece() != null) {
                return false;
            }
        }
        return isEmpty;
    }

    public void initAsBlankRank() {
        for (int i = 0; i < LENGTH; i++) {
            rank.add(new Square());
        }
    }

    public void add(Piece piece) {
        rank.add(new Square(piece));
    }

    public void set(int index, Piece piece) {
        rank.set(index, new Square(piece));
    }

    public int size() {
        return rank.size();
    }

    public Optional<Piece> findPiece(int index) {
        return Optional.ofNullable(rank.get(index).getPiece());
    }

    public int countPiece(Piece piece) {
        int count = 0;
        for (Square square : rank) {
            if (square.isEqualPiece(piece)) {
                count++;
            }
        }
        return count;
    }

    public String getRankStatus() {
        if (isEmpty()) {
            return BLANK_SQUARE.repeat(8);
        }

        return rank.stream()
                .map(p -> {
                    if (p.getPiece() == null) {
                        return BLANK_SQUARE;
                    }
                    return p.getPiece().getRepresentation();
                })
                .reduce("", (x, y) -> x + y);
    }
}

