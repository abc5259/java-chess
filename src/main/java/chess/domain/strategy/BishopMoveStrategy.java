package chess.domain.strategy;

import chess.domain.Position;
import chess.domain.PositionDifference;

public class BishopMoveStrategy implements MoveStrategy {
    
    @Override
    public boolean canMove(Position currentPosition, Position newPosition) {
        PositionDifference positionDifference = currentPosition.calculateDifference(newPosition);

        return positionDifference.isMagnitudeEqual();
    }
}
