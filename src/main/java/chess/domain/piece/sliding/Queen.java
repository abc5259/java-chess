package chess.domain.piece.sliding;

import chess.domain.color.Color;
import chess.domain.piece.Direction;
import chess.domain.piece.PieceScore;
import chess.domain.piece.PieceType;
import chess.domain.piece.Position;
import java.util.Set;

public class Queen extends SlidingPiece {
    private static final Set<Direction> DIRECTIONS = Direction.getEightDirection();

    public Queen(final Position position, final Color color) {
        super(position, color, DIRECTIONS);
    }

    @Override
    public PieceType pieceType() {
        if (color == Color.WHITE) {
            return PieceType.WHITE_QUEEN;
        }
        return PieceType.BLACK_QUEEN;
    }

    @Override
    public Queen update(final Position destination) {
        return new Queen(destination, color);
    }

    @Override
    public double score() {
        return PieceScore.QUEEN.score();
    }
}
