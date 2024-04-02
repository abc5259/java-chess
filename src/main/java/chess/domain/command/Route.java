package chess.domain.command;

import chess.domain.pieceinfo.Position;

public class Route {
    private final Position source;
    private final Position target;

    public Route(String source, String target) {
        validateDifferentPosition(source, target);

        this.source = Position.of(source);
        this.target = Position.of(target);
    }

    public void validateDifferentPosition(String source, String target) {
        if (source.equals(target)) {
            throw new IllegalArgumentException("출발지와 목적지의 위치는 달라야 합니다.");
        }
    }

    public Position getSource() {
        return source;
    }

    public Position getTarget() {
        return target;
    }
}
