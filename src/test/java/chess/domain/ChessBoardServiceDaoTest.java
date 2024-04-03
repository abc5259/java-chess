package chess.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import chess.db.BoardDao;
import chess.dto.BoardPieceDto;
import chess.db.DBConnectionUtils;
import chess.domain.position.Column;
import chess.domain.position.Position;
import chess.domain.position.Row;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChessBoardServiceDaoTest {

    private Connection connection;
    private BoardDao boardDao;

    @BeforeEach
    void beforeEach() {
        try {
            connection = DBConnectionUtils.getConnection();
            connection.setAutoCommit(false);
            boardDao = new BoardDao(connection);
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @AfterEach
    void afterEach() {
        try {
            connection.rollback();
        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @DisplayName("DB에 새로운 데이터를 추가한다.")
    @Test
    void addTest() {
        //given
        Position position = new Position(Row.RANK3, Column.C);
        Piece piece = new Piece(PieceType.ROOK, Color.WHITE);
        BoardPieceDto boardPieceDto = new BoardPieceDto(position, piece);

        //when
        boardDao.create(boardPieceDto);
        BoardPieceDto resultDto = boardDao.findByPosition(position).get();

        //then
        assertAll(
                () -> assertThat(resultDto.piece()).isEqualTo(piece),
                () -> assertThat(resultDto.position()).isEqualTo(position)
        );
    }
    
    @DisplayName("DB에서 특정 데이터를 삭제한다.")
    @Test
    void deleteTest() {
        //given
        Position position = new Position(Row.RANK1, Column.C);
        BoardPieceDto boardPieceDto = new BoardPieceDto(position, new Piece(PieceType.ROOK, Color.WHITE));

        //when
        boardDao.create(boardPieceDto);
        boardDao.delete(position);

        //then
        assertThat(boardDao.findByPosition(position).isEmpty()).isTrue();
    }
}
