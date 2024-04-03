package domain.piece;

import domain.position.Position;

public class Empty implements Piece {
    private static final Empty INSTANCE = new Empty();

    private Empty() {
    }

    public static Empty create() {
        return INSTANCE;
    }

    @Override
    public void validateMovement(Position source, Position target, Color targetColor) {
        throw new IllegalStateException("빈 칸입니다.");
    }

    @Override
    public Color color() {
        return Color.NEUTRALITY;
    }

    @Override
    public Type type() {
        return Type.EMPTY;
    }
}
