package service;

import database.dao.GameStateDao;
import database.dao.PieceDao;
import domain.ChessGame;
import domain.board.ChessBoard;
import domain.board.ChessBoardFactory;
import domain.piece.Color;
import dto.PieceDto;
import dto.RoomDto;
import dto.StateDto;

import java.util.List;
import java.util.NoSuchElementException;

public class ChessGameService {
    private final PieceDao pieceDao;
    private final GameStateDao gameStateDao;

    public ChessGameService(final PieceDao pieceDao, final GameStateDao gameStateDao) {
        this.pieceDao = pieceDao;
        this.gameStateDao = gameStateDao;
    }

    public ChessGame initializeChessGame(final RoomDto roomDto) {
        try {
            final StateDto stateDto = loadPreviousState(roomDto);
            return new ChessGame(ChessBoardFactory.loadPreviousChessBoard(
                    loadPreviousPieces(roomDto), stateDto.getState()));
        } catch (NoSuchElementException e) {
            return new ChessGame(ChessBoardFactory.createInitialChessBoard());
        }
    }

    public void saveChessGame(final ChessGame chessGame, final RoomDto roomDto) {
        if (chessGame.isGameOver()) {
            updateState(new StateDto("GAMEOVER", roomDto.roomId()));
            return;
        }

        final ChessBoard board = chessGame.getBoard();
        Color turn = chessGame.getTurn();
        updatePieces(roomDto, board.getPieces());
        updateState(new StateDto(turn.name(), roomDto.roomId()));
    }

    private List<PieceDto> loadPreviousPieces(final RoomDto roomDto) {
        return pieceDao.findPieceByGameId(roomDto.roomId());
    }

    private StateDto loadPreviousState(final RoomDto roomDto) {
        return gameStateDao.findByGameId(roomDto.roomId())
                .orElseThrow(NoSuchElementException::new);
    }

    private void updatePieces(final RoomDto roomDto, final List<PieceDto> pieceDtos) {
        pieceDao.deleteAllByGameId(roomDto.roomId());
        for (final PieceDto pieceDto : pieceDtos) {
            pieceDao.add(roomDto, pieceDto);
        }
    }

    private void updateState(final StateDto stateDto) {
        gameStateDao.deleteByGameId(stateDto.gameId());
        gameStateDao.add(stateDto);
    }
}
