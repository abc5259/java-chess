package chess.domain.piece;

import chess.domain.pieceinfo.PieceInfo;
import chess.domain.pieceinfo.Position;
import chess.domain.strategy.MoveStrategy;

public class EmptyPiece extends ChessPiece {

    public EmptyPiece(PieceInfo pieceInfo, MoveStrategy moveStrategy) {
        super(pieceInfo, moveStrategy);
    }

    @Override
    public ChessPiece createNewPiece(PieceInfo newPieceInfo) {
        return this;
    }

    @Override
    public boolean isMoveInvalid(Position newPosition, boolean isDisturbed, boolean isOtherPieceExist,
                                 boolean isSameTeam) {
        return true;
    }

    @Override
    public PieceType getType() {
        return PieceType.EMPTY;
    }

    @Override
    public double getScore() {
        return 0;
    }
}
