package domain.piece.piecerole;

import static domain.movement.Direction.E;
import static domain.movement.Direction.N;
import static domain.movement.Direction.S;
import static domain.movement.Direction.W;

import domain.movement.Movable;
import domain.position.Position;
import domain.score.Score;
import java.util.List;
import java.util.Objects;

public class Rook extends SlidingPiece {
    private static final Score SCORE = new Score(5.0);
    private static final int MAX_MOVEMENT = 7;
    private static final List<Movable> ROUTES = List.of(
            new Movable(MAX_MOVEMENT, N),
            new Movable(MAX_MOVEMENT, E),
            new Movable(MAX_MOVEMENT, S),
            new Movable(MAX_MOVEMENT, W)
    );

    public Rook() {
        super(PieceType.ROOK, SCORE);
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
