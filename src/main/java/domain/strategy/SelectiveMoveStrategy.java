package domain.strategy;

import domain.board.Position;
import domain.piece.Piece;
import domain.piece.info.Direction;
import domain.piece.info.File;
import domain.piece.info.Rank;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SelectiveMoveStrategy implements MoveStrategy {
    @Override
    public List<Position> movablePositions(final Position source, final List<Direction> directions,
                                           final Map<Position, Piece> pieces) {
        final List<Position> positions = new ArrayList<>();
        for (final Direction direction : directions) {
            positions.addAll(findMovablePositions(source, direction, pieces));
        }
        return positions;
    }

    private List<Position> findMovablePositions(final Position source, final Direction direction,
                                                final Map<Position, Piece> pieces) {
        final List<Position> positions = new ArrayList<>();
        Position current = source;
        Position next = getValidNextPosition(current, direction);

        while (isNextInboard(direction, current) && isNotPieceOnNextPosition(next, positions, pieces)) {
            next = current.next(direction);
            positions.add(next);
            current = next;
        }
        return positions;
    }

    private Position getValidNextPosition(final Position source, final Direction direction) {
        Position next = source;
        if (isNextInboard(direction, source)) {
            next = source.next(direction);
        }
        return next;
    }

    private boolean isNotPieceOnNextPosition(final Position next, final List<Position> positions,
                                             final Map<Position, Piece> pieces) {
        final Piece piece = pieces.get(next);
        if (piece.isNotNone()) {
            positions.add(next);
            return false;
        }
        return true;
    }

    private boolean isNextInboard(final Direction direction, final Position current) {
        final int nextRank = direction.rank() + current.rankIndex();
        final int nextFile = direction.file() + current.fileIndex();
        return isNextRankInBoard(nextRank) && isNextFileInBoard(nextFile);
    }

    private boolean isNextRankInBoard(final int nextRank) {
        return Rank.isValid(nextRank);
    }

    private boolean isNextFileInBoard(final int nextFile) {
        return File.isValid(nextFile);
    }
}
