package chess.domain;

import chess.domain.position.Direction;
import chess.domain.position.Position;
import java.util.Deque;
import java.util.Map;
import java.util.Objects;

public class Piece {

    private final PieceType pieceType;
    private final Color color;

    public Piece(PieceType pieceType, Color color) {
        this.pieceType = pieceType;
        this.color = color;
    }

    public Map<Direction, Deque<Position>> calculateAllDirectionPositions(Position currentPosition) {
        return pieceType.calculateAllDirectionPositions(currentPosition);
    }

    public boolean isSameTeam(Piece piece) {
        return this.color == piece.color;
    }

    public boolean isSameTeam(Color color) {
        return this.color == color;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public boolean isForward(Direction direction) {
        if (pieceType.isBlackPawn()) {
            return direction == Direction.S;
        }
        if (pieceType.isWhitePawn()) {
            return direction == Direction.N;
        }
        return true;
    }

    public boolean isAttack(Direction direction) {
        if (pieceType.isBlackPawn()) {
            return direction == Direction.SW || direction == Direction.SE;
        }
        if (pieceType.isWhitePawn()) {
            return direction == Direction.NE || direction == Direction.NW;
        }
        return true;
    }

    public boolean isKing() {
        return pieceType.isKing();
    }

    public double getScore() {
        return pieceType.getScore();
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public Color getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Piece piece = (Piece) o;
        return pieceType == piece.pieceType && color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceType, color);
    }

    @Override
    public String toString() {
        return "Piece{" +
                "pieceType=" + pieceType +
                ", color=" + color +
                '}';
    }
}
