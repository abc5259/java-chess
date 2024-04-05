package domain.position;

import domain.movement.ChessVector;
import domain.movement.Direction;
import java.util.Objects;

public class Position {
    private final File file;
    private final Rank rank;

    public Position(final File file, final Rank rank) {
        this.file = file;
        this.rank = rank;
    }

    public Position(final String fileRank) {
        this(new File(fileRank.charAt(0)), new Rank(fileRank.charAt(1)));
    }

    public Position(final String file, final String rank) {
        this(new File(file.charAt(0)), new Rank(rank.charAt(0)));
    }

    public Position move(final Direction direction) {
        int fileVector = direction.getFileVector();
        int rankVector = direction.getRankVector();
        return new Position(file.add(fileVector), rank.add(rankVector));
    }

    public ChessVector toVector(Position target) {
        return new ChessVector(file.subtract(target.file), rank.subtract(target.rank));
    }

    public boolean isRankAt(int number) {
        return rank.isRank(number);
    }

    public File getFile() {
        return file;
    }

    public Rank getRank() {
        return rank;
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
