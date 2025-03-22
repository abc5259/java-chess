package chess;

import chess.piece.Piece;
import java.util.List;

public class ChessBoard {

    private final List<Piece> pieces;

    public ChessBoard(List<Piece> pieces) {
        this.pieces = pieces;
    }
    
    public void move(Color color, Position from, Position to) {
        if (isNotExistPiece(from)) {
            throw new IllegalArgumentException("출발지에 기물이 없습니다.");
        }
        findPiece(from).move(this, color, to);
    }

    public boolean isExistPiece(Position position) {
        return pieces.stream()
                .anyMatch(piece -> piece.isPosition(position));
    }

    public boolean isNotExistPiece(Position position) {
        return !isExistPiece(position);
    }

    public boolean isColorInPosition(Color color, Position position) {
        if (isNotExistPiece(position)) {
            return false;
        }
        return findPiece(position).isColor(color);
    }

    public Piece findPiece(Position position) {
        return pieces.stream()
                .filter(piece -> piece.isPosition(position))
                .findFirst()
                .orElse(null);
    }
}
