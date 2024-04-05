package domain.piece.piecerole;

import static domain.movement.Direction.E;
import static domain.movement.Direction.N;
import static domain.movement.Direction.NE;
import static domain.movement.Direction.NW;
import static domain.movement.Direction.S;
import static domain.movement.Direction.SE;
import static domain.movement.Direction.SW;
import static domain.movement.Direction.W;

import domain.movement.Movable;
import domain.position.Position;
import domain.score.Score;
import java.util.List;
import java.util.Objects;

public class Queen extends SlidingPiece {
    private static final Score SCORE = new Score(9.0);
    private static final int MAX_MOVEMENT = 7;
    private static final List<Movable> ROUTES = List.of(
            new Movable(MAX_MOVEMENT, N),
            new Movable(MAX_MOVEMENT, E),
            new Movable(MAX_MOVEMENT, S),
            new Movable(MAX_MOVEMENT, W),
            new Movable(MAX_MOVEMENT, NE),
            new Movable(MAX_MOVEMENT, NW),
            new Movable(MAX_MOVEMENT, SE),
            new Movable(MAX_MOVEMENT, SW)

    );

    public Queen() {
        super(PieceType.QUEEN, SCORE);
    }

    @Override
    public boolean canMove(final Position sourcePosition, final Position targetPosition) {
        return ROUTES.stream()
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
