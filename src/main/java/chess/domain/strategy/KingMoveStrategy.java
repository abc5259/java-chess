package chess.domain.strategy;

import chess.domain.pieceInfo.Position;
import chess.domain.pieceInfo.PositionDifference;

public class KingMoveStrategy implements MoveStrategy {

    @Override
    public boolean canMove(final Position currentPosition, final Position newPosition) {
        PositionDifference positionDifference = currentPosition.calculateDifference(newPosition);

        return positionDifference.isWithinUnitRange();
    }
}
