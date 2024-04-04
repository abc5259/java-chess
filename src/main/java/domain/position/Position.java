package domain.position;

import domain.game.Direction;
import domain.game.Vector;
import java.util.Objects;

public class Position {
    private final File file;
    private final Rank rank;

    public Position(final File file, final Rank rank) {
        this.file = file;
        this.rank = rank;
    }

    public Position(final Position other) {
        this.file = other.file;
        this.rank = other.rank;
    }

    public Vector generateVectorToTargetPosition(final Position target) {
        return new Vector(file.subtract(target.file), rank.subtract(target.rank));
    }

    public Position move(final Direction direction) {
        int fileVector = direction.getFileVector();
        int rankVector = direction.getRankVector();
        return new Position(file.add(fileVector), rank.add(rankVector));
    }

    public boolean hasEqualFilePosition(final Position other) {
        return file.equals(other.file);
    }

    public boolean isEqualRank(final Rank other) {
        return rank.equals(other);
    }

    public String fileName() {
        return file.getName();
    }

    public String rankName() {
        return rank.getName();
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
        return Objects.equals(file, position.file) && Objects.equals(rank, position.rank);
    }

    @Override
    public int hashCode() {
        return Objects.hash(file, rank);
    }
}
