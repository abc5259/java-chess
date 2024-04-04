package chess.domain.piece;

import chess.domain.Position;
import java.util.List;

public class Empty extends Piece {

    public static final Empty EMPTY = new Empty();

    private Empty() {
        super(null);
    }

    @Override
    public List<Position> findPath(final Position source, final Position target, final Direction direction) {
        throw new IllegalArgumentException("[ERROR] 빈 기물은 이동할 수 없습니다.");
    }

    @Override
    public String getOwnPieceTypeName() {
        return PieceType.EMPTY.name();
    }

    @Override
    public double getPieceScore() {
        throw new IllegalArgumentException("[ERROR] 빈 기물은 점수를 계산할 수 없습니다.");
    }
}
