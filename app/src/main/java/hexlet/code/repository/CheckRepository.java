package hexlet.code.repository;

import hexlet.code.model.UrlCheck;

import java.sql.SQLException;
import java.sql.Statement;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CheckRepository extends BaseRepository {
    public static void save(UrlCheck urlCheck) throws SQLException {
        String sql = "INSERT INTO url_checks"
                + " (status_code, title, h1, description, url_id, created_at)"
                + " VALUES (?, ?, ?, ?, ?, ?)";
        log.info(sql);
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, urlCheck.getStatusCode());
            preparedStatement.setString(2, urlCheck.getTitle());
            preparedStatement.setString(3, urlCheck.getH1());
            preparedStatement.setString(4, urlCheck.getDescription());
            preparedStatement.setLong(5, urlCheck.getUrlId());
            preparedStatement.setTimestamp(6, urlCheck.getCreatedAt());
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
            if (generatedKeys.next()) {
                urlCheck.setId(generatedKeys.getLong(1));
            } else {
                throw new SQLException("DB have not returned an id after saving an entity");
            }
        }
    }
    public static void delete(Long id) throws SQLException {
        String sql = "DELETE FROM url_checks where url_id = ?";
        log.info(sql);
        try (var conn = dataSource.getConnection();
             var preparedStatement = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
            var generatedKeys = preparedStatement.getGeneratedKeys();
        }
    }
    public static Optional<UrlCheck> findUrl(Long id) throws SQLException {
        var sql = "SELECT * FROM url_checks WHERE url_id = ?";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var idMain = resultSet.getLong("id");
                var statusCode = resultSet.getInt("status_code");
                var title = resultSet.getString("title");
                var h1 = resultSet.getString("h1");
                var description = resultSet.getString("description");
                var date = resultSet.getTimestamp("created_at");
                var url = new UrlCheck(statusCode, title, h1, description, id, date);
                url.setId(id);
                return Optional.of(url);
            }
            return Optional.empty();
        }
    }
    public static String findStatusCheck(Long id) throws SQLException {
        var sql = "SELECT status_code FROM url_checks WHERE url_id = ?";
        String returnCode = "пусто";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                returnCode = String.valueOf(resultSet.getInt("status_code"));

            }
            return returnCode;
        }
    }
    public static String findDateTimeCheck(Long id) throws SQLException {
        var sql = "SELECT created_at FROM url_checks WHERE url_id = ?";
        //String returnCode = " ";
        try (var conn = dataSource.getConnection();
             var stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            var resultSet = stmt.executeQuery();
            if (resultSet.next()) {
                var date = resultSet.getTimestamp("created_at");
                var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
                return date.toLocalDateTime().format(formatter);
            }
            return "пусто";
        }
    }

}
