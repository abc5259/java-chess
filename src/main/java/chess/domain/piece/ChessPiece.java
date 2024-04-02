package chess.domain.piece;

import chess.domain.pieceinfo.PieceInfo;
import chess.domain.pieceinfo.Position;
import chess.domain.pieceinfo.Team;
import chess.domain.strategy.MoveStrategy;
import java.util.Objects;

public abstract class ChessPiece implements Piece {
    protected final PieceInfo pieceInfo;
    protected final MoveStrategy moveStrategy;

    public ChessPiece(PieceInfo pieceInfo, MoveStrategy moveStrategy) {
        this.pieceInfo = pieceInfo;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public abstract ChessPiece createNewPiece(PieceInfo newPieceInfo);

    @Override
    public abstract PieceType getType();

    @Override
    public abstract double getScore();

    @Override
    public ChessPiece move(Position newPosition, boolean isObstacleInRange, boolean isOtherPieceExist,
                           boolean isSameTeamExist) {
        if (isMoveInvalid(newPosition, isObstacleInRange, isOtherPieceExist, isSameTeamExist)) {
            return this;
        }

        PieceInfo newPieceInfo = pieceInfo.renewPosition(newPosition);
        return createNewPiece(newPieceInfo);
    }

    @Override
    public boolean isMoveInvalid(Position newPosition, boolean isDisturbed, boolean isOtherPieceExist,
                                 boolean isSameTeamExist) {
        Position currentPosition = pieceInfo.getPosition();
        if (!moveStrategy.canMove(currentPosition, newPosition)) {
            return true;
        }
        return isDisturbed || isSameTeamExist;
    }

    @Override
    public PieceInfo getPieceInfo() {
        return pieceInfo;
    }

    @Override
    public Team getTeam() {
        return pieceInfo.getTeam();
    }

    @Override
    public boolean isSameTeam(Team otherTeam) {
        return pieceInfo.isSameTeam(otherTeam);
    }

    @Override
    public Position getPosition() {
        return pieceInfo.getPosition();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessPiece that = (ChessPiece) o;
        return Objects.equals(pieceInfo, that.pieceInfo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pieceInfo);
    }
}
