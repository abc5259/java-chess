package chess.service;

import chess.dao.PieceDao;
import chess.dao.PositionDao;
import chess.domain.piece.Camp;
import chess.domain.piece.PieceType;
import chess.domain.position.BoardPosition;
import chess.domain.position.Lettering;
import chess.domain.position.Numbering;
import chess.domain.position.Position;
import chess.entity.PieceEntity;
import chess.entity.PositionEntity;
import java.util.Arrays;

public class ChessDataInitializer {

    private static final ChessDataInitializer INSTANCE = new ChessDataInitializer();

    private final PositionDao positionDao = PositionDao.getInstance();
    private final PieceDao pieceDao = PieceDao.getInstance();

    private ChessDataInitializer() {
        registerChessResource();
    }

    public static ChessDataInitializer getInstance() {
        return INSTANCE;
    }

    public void registerChessResource() {
        if (!positionDao.hasData()) {
            addAllPosition();
        }
        if (!pieceDao.hasData()) {
            addAllTypePiece();
        }
    }

    private void addAllPosition() {
        Arrays.stream(Lettering.values())
                .forEach(lettering -> Arrays.stream(Numbering.values())
                        .forEach(numbering -> {
                            Position position = BoardPosition.findPosition(lettering, numbering);
                            positionDao.add(new PositionEntity(position.getLettering(), position.getNumbering()));
                        }));
    }

    private void addAllTypePiece() {
        Arrays.stream(PieceType.values())
                .forEach(pieceType -> Arrays.stream(Camp.values())
                        .filter(camp -> camp != Camp.NONE)
                        .forEach(camp -> pieceDao.add(new PieceEntity(pieceType, camp))));
    }
}
