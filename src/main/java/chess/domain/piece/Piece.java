package chess.domain.piece;

import chess.domain.game.ScoreRule;
import chess.domain.piece.strategy.MovementStrategy;
import chess.domain.position.Position;

public class Piece {
    private Long id;
    private final PieceType type;
    private final PieceColor color;
    private final PieceRule rule;

    public Piece(final PieceType type, final PieceColor color) {
        this(type, color, PieceRule.findRule(type, color));
    }

    public Piece(final Long id, final PieceType type, final PieceColor color) {
        this(id, type, color, PieceRule.findRule(type, color));
    }

    public Piece(final PieceType type, final PieceColor color, final PieceRule rule) {
        this.type = type;
        this.color = color;
        this.rule = rule;
    }

    public Piece(final Long id, final PieceType type, final PieceColor color, final PieceRule rule) {
        this.id = id;
        this.type = type;
        this.color = color;
        this.rule = rule;
    }

    public boolean isInMovableRange(final Position source, final Position target) {
        MovementStrategy movementStrategy = rule.movementStrategy();
        return movementStrategy.isMovable(source, target);
    }

    public boolean isColor(final PieceColor color) {
        return this.color == color;
    }

    public boolean isType(final PieceType pieceType) {
        return this.type == pieceType;
    }

    public boolean isPawn() {
        return this.type == PieceType.PAWN;
    }

    public boolean isKing() {
        return this.type == PieceType.KING;
    }

    public boolean isKnight() {
        return this.type == PieceType.KNIGHT;
    }

    public Long id() {
        return id;
    }

    public PieceType type() {
        return type;
    }

    public PieceColor color() {
        return color;
    }

    public double calculateScore(final ScoreRule scoreRule) {
        return scoreRule.calculate(rule.score());
    }

    @Override
    public String toString() {
        return "Piece{" +
                "type=" + type +
                ", color=" + color +
                ", rule=" + rule +
                '}';
    }
}
