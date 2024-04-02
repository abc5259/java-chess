package chess.domain.piece;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Position {
    public static final int MINIMUM_POSITION = 1;
    public static final int MAXIMUM_POSITION = 8;

    private final int x;
    private final int y;

    public Position(final int x, final int y) {
        validateRange(x, y);
        this.x = x;
        this.y = y;
    }

    private void validateRange(final int x, final int y) {
        validateColumn(x);
        validateRow(y);
    }

    private void validateColumn(final int x) {
        if (x < MINIMUM_POSITION || x > MAXIMUM_POSITION) {
            throw new IllegalArgumentException("올바르지 않은 열입니다.");
        }
    }

    private void validateRow(final int y) {
        if (y < MINIMUM_POSITION || y > MAXIMUM_POSITION) {
            throw new IllegalArgumentException("올바르지 않은 행입니다.");
        }
    }

    public Set<Position> findPathTo(final Set<Direction> directions) {
        return directions.stream()
                .filter(this::isInRange)
                .map(direction -> new Position(direction.getDx() + x, direction.getDy() + y))
                .collect(Collectors.toSet());
    }

    private boolean isInRange(final Direction direction) {
        final int newX = direction.getDx() + x;
        final int newY = direction.getDy() + y;
        return isLocationInRange(newX) && isLocationInRange(newY);
    }

    private boolean isLocationInRange(final int location) {
        return location >= MINIMUM_POSITION && location <= MAXIMUM_POSITION;
    }

    public Direction findDirectionTo(final Position destination) {
        int dx = destination.x - this.x;
        int dy = destination.y - this.y;

        if (isNotInEightDirection(dx, dy)) {
            throw new IllegalArgumentException("이동할 수 없습니다.");
        }

        dx = calculateMoved(dx);
        dy = calculateMoved(dy);
        return Direction.findDirection(dx, dy);
    }

    private boolean isNotInEightDirection(final int dx, final int dy) {
        return !(Math.abs(dx) == Math.abs(dy) || (dx + dy != 0 && dx * dy == 0));
    }

    private int calculateMoved(final int dx) {
        if (dx != 0) {
            return dx / Math.abs(dx);
        }
        return dx;
    }

    public Set<Position> findPath(final Position other) {
        Set<Position> positions = new HashSet<>();
        Direction direction = findDirectionTo(other);
        int newX = x + direction.getDx();
        int newY = y + direction.getDy();

        while (newX != other.x || newY != other.y) {
            positions.add(new Position(newX, newY));
            newX += direction.getDx();
            newY += direction.getDy();
        }
        return positions;
    }

    public Column findColumn() {
        return Column.findColumn(x);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Position position = (Position) o;
        return x == position.x && y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
