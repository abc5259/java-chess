package chess.domain.strategy.speical;

import chess.domain.position.Direction;
import java.util.List;

public class RookMoveStrategy extends SpecialPieceMoveStrategy{

    private static final int DEFAULT_MAX_MOVE_DISTANCE = 7;
    private static final List<Direction> DIRECTIONS = Direction.straightDirections();

    public RookMoveStrategy() {
        super(DIRECTIONS, DEFAULT_MAX_MOVE_DISTANCE);
    }
}
