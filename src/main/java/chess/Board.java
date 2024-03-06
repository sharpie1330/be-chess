package chess;

import chess.pieces.Piece;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static utils.StringUtils.*;

public class Board {
    public static final String BLANK_SPACE = "▯";
    public static final int LENGTH = 8;

    private final List<List<Piece>> board;

    public Board() {
        board = new ArrayList<>();
    }

    public void initialize() {
        addBoardBlackPieces();
        addBoardBlankRank();
        addBoardWhitePieces();
    }

    private void addBoardBlackPieces() {
        List<Piece> pieces = new ArrayList<>();

        pieces.add(Piece.createBlackRook());
        pieces.add(Piece.createBlackKnight());
        pieces.add(Piece.createBlackBishop());
        pieces.add(Piece.createBlackQueen());
        pieces.add(Piece.createBlackKing());
        pieces.add(Piece.createBlackBishop());
        pieces.add(Piece.createBlackKnight());
        pieces.add(Piece.createBlackRook());

        board.add(0, pieces);
        board.add(1, IntStream.range(0, LENGTH)
                .mapToObj(i -> Piece.createBlackPawn())
                .collect(Collectors.toList()));
    }

    private void addBoardBlankRank() {
        IntStream.rangeClosed(2, 5)
                .forEach(
                        i -> board.add(i,
                                IntStream.range(0, LENGTH)
                                        .mapToObj(i2 -> Piece.createBlankSquare())
                                        .collect(Collectors.toList())
                        )
                );
    }

    private void addBoardWhitePieces() {
        board.add(6, IntStream.range(0, LENGTH)
                .mapToObj(i -> Piece.createWhitePawn())
                .collect(Collectors.toList()));

        List<Piece> pieces = new ArrayList<>();

        pieces.add(Piece.createWhiteRook());
        pieces.add(Piece.createWhiteKnight());
        pieces.add(Piece.createWhiteBishop());
        pieces.add(Piece.createWhiteQueen());
        pieces.add(Piece.createWhiteKing());
        pieces.add(Piece.createWhiteBishop());
        pieces.add(Piece.createWhiteKnight());
        pieces.add(Piece.createWhiteRook());

        board.add(7, pieces);
    }

    public void print() {
        System.out.println(showBoard());
    }

    public int pieceCount() {
        int sum = 0;
        for(List<Piece> pieces: board){
            for (Piece piece : pieces) {
                if (!piece.getRepresentation().equals(Board.BLANK_SPACE)) {
                    sum++;
                }
            }
        }

        return sum;
    }

    public String showBoard() {
         return IntStream.range(0, LENGTH)
                .mapToObj(this::getBoardIndexLine)
                .reduce("", (x, y) -> appendNewLine(x + y));
    }

    private String getBoardIndexLine(int index) {
        return board.get(index).stream()
                .map(Piece::getRepresentation)
                .reduce("", (x, y) -> x + y);
    }
}
