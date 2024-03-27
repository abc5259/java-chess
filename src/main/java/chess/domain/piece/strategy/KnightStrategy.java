package chess.domain.piece.strategy;

import chess.domain.square.Square;

public class KnightStrategy implements MoveStrategy {

    @Override
    public boolean canMove(final Square source, final Square target) {
        return source.isStraightAndDiagonal(target);
    }
}
