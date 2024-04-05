package domain.piece;

import domain.piece.piecerole.PieceRole;
import domain.position.Position;
import domain.score.Score;
import java.util.Objects;

public class Piece {
    private final PieceRole pieceRole;
    private final Color color;

    public Piece(final PieceRole pieceRole, final Color color) {
        this.pieceRole = pieceRole;
        this.color = color;
    }

    public boolean isSameColor(final Piece target) {
        return this.color == target.color;
    }

    public boolean isSameColor(final Color color) {
        return this.color == color;
    }

    public boolean isNotSameColor(final Color color) {
        return this.color != color;
    }

    public boolean canMove(final Position source, final Position target) {
        return pieceRole.canMove(source, target);
    }

    public boolean isPawn() {
        return pieceRole.isPawn();
    }

    public boolean isKing() {
        return pieceRole.isKing();
    }

    public boolean isSlidingPiece() {
        return pieceRole.isSlidingPiece();
    }

    public Score getScore() {
        return pieceRole.getScore();
    }

    public String getColor() {
        return color.name();
    }

    public String getPieceType() {
        return pieceRole.getPieceType();
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
        return pieceRole.equals(piece.pieceRole) && color == piece.color;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceRole, color);
    }
}
