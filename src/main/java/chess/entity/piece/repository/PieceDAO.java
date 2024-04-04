package chess.entity.piece.repository;

import chess.domain.position.ChessFile;
import chess.domain.position.ChessRank;
import chess.entity.PieceEntity;
import chess.infra.db.query.QueryManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PieceDAO implements PieceRepository {

    @Override
    public List<PieceEntity> findByGameId(Connection conn, final Long gameId) throws SQLException {
        ResultSet resultSet = QueryManager.setConnection(conn)
                .select("SELECT * FROM piece WHERE piece.game_id = ?")
                .setString(1, gameId.toString())
                .execute();

        List<PieceEntity> results = new ArrayList<>();
        while (resultSet.next()) {
            long id = resultSet.getLong("piece_id");
            String type = resultSet.getString("type");
            String color = resultSet.getString("color");
            String rank = resultSet.getString("rank");
            String file = resultSet.getString("file");

            results.add(new PieceEntity(id, gameId, type, color, rank, file));
        }
        return results;
    }

    @Override
    public Long add(Connection conn, PieceEntity pieceEntity) throws SQLException {
        ResultSet generatedKeys = QueryManager.setConnection(conn)
                .insert("INSERT INTO piece (`game_id`, `type`, `color`, `rank`, `file`) VALUES (?, ?, ?, ?, ?)")
                .setLong(1, pieceEntity.getGameId())
                .setString(2, pieceEntity.getType())
                .setString(3, pieceEntity.getColor())
                .setString(4, pieceEntity.getRank())
                .setString(5, pieceEntity.getFile())
                .execute()
                .getGeneratedKeys();

        generatedKeys.next();
        return generatedKeys.getLong(1);
    }

    @Override
    public void updatePositionById(Connection conn, Long pieceId, ChessFile file, ChessRank rank) throws SQLException {
        QueryManager.setConnection(conn)
                .update("UPDATE piece SET piece.file = ?, piece.rank = ? WHERE piece.piece_id = ?")
                .setString(1, file.name())
                .setString(2, rank.name())
                .setLong(3, pieceId)
                .execute();
    }

    @Override
    public void deleteAll(Connection conn) throws SQLException {
        QueryManager.setConnection(conn)
                .delete("DELETE FROM piece")
                .execute();
    }
}
