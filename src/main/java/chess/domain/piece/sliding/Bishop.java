package chess.domain.piece.sliding;

import chess.domain.color.Color;
import chess.domain.piece.Direction;
import chess.domain.piece.PieceScore;
import chess.domain.piece.PieceType;
import chess.domain.piece.Position;
import java.util.Set;

public class Bishop extends SlidingPiece {
    private static final Set<Direction> DIRECTIONS = Direction.getDiagonalDirection();

    public Bishop(final Position position, final Color color) {
        super(position, color, DIRECTIONS);
    }

    @Override
    public PieceType pieceType() {
        if (color == Color.WHITE) {
            return PieceType.WHITE_BISHOP;
        }
        return PieceType.BLACK_BISHOP;
    }

    @Override
    public Bishop update(final Position destination) {
        return new Bishop(destination, color);
    }

    @Override
    public double score() {
        return PieceScore.BISHOP.score();
    }
}
