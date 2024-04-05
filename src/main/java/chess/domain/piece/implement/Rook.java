package chess.domain.piece.implement;

import chess.domain.board.Path;
import chess.domain.piece.Color;
import chess.domain.piece.Piece;
import chess.domain.piece.PieceType;
import chess.domain.piece.Score;

public class Rook extends Piece {

    private static final Score ROOK_SCORE = new Score(5);

    public Rook(Color color) {
        super(color, PieceType.ROOK);
    }

    @Override
    public boolean canMove(Path path) {
        if (path.hasPieceExceptTarget()) {
            return false;
        }
        if (path.containsDiagonalDirection()) {
            return false;
        }
        return !path.isAllyAtTarget()
                && path.hasCountOfDistinctDirection(1);
    }

    @Override
    public Piece move() {
        return this;
    }

    @Override
    public Score getPieceScore() {
        return ROOK_SCORE;
    }
}
