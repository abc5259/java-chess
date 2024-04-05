package domain.piece.piecerole;

import domain.movement.Direction;
import domain.movement.Movable;
import domain.position.Position;
import java.util.List;
import java.util.Objects;

public class WhitePawn extends Pawn {
    private static final int INITIAL_RANK_POSITION = 2;
    private static final int INITIAL_MAX_MOVEMENT = 2;
    private static final int GENERAL_MAX_MOVEMENT = 1;
    private static final List<Movable> ROUTES = List.of(
            new Movable(INITIAL_MAX_MOVEMENT, Direction.N),
            new Movable(GENERAL_MAX_MOVEMENT, Direction.N),
            new Movable(GENERAL_MAX_MOVEMENT, Direction.NE),
            new Movable(GENERAL_MAX_MOVEMENT, Direction.NW)
    );

    public WhitePawn() {
        super(PieceType.WHITE_PAWN);
    }

    @Override
    public boolean canMove(Position sourcePosition, Position targetPosition) {
        if (sourcePosition.isRankAt(INITIAL_RANK_POSITION)) {
            return ROUTES.stream()
                    .anyMatch(movable -> movable.canMove(sourcePosition, targetPosition));
        }
        return ROUTES.stream()
                .filter(movable -> movable.maxMovementIs(GENERAL_MAX_MOVEMENT))
                .anyMatch(movable -> movable.canMove(sourcePosition, targetPosition));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        return o != null && getClass() == o.getClass();
    }

    @Override
    public int hashCode() {
        return Objects.hash(ROUTES);
    }
}
