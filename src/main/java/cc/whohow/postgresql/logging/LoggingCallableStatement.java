package cc.whohow.postgresql.logging;

import cc.whohow.postgresql.proxy.WrapperCallableStatement;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoggingCallableStatement extends WrapperCallableStatement {
    private static final Logger log = LogManager.getLogger("pg.sql.statement");

    public LoggingCallableStatement(CallableStatement callableStatement) {
        super(callableStatement);
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        log.debug(callableStatement);
        return callableStatement.executeQuery();
    }

    @Override
    public int executeUpdate() throws SQLException {
        log.debug(callableStatement);
        return callableStatement.executeUpdate();
    }

    @Override
    public boolean execute() throws SQLException {
        log.debug(callableStatement);
        return callableStatement.execute();
    }

    @Override
    public long executeLargeUpdate() throws SQLException {
        log.debug(callableStatement);
        return callableStatement.executeLargeUpdate();
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        log.debug(sql);
        return callableStatement.executeQuery(sql);
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        log.debug(sql);
        return callableStatement.executeUpdate(sql);
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        log.debug(sql);
        return callableStatement.execute(sql);
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        log.debug(sql);
        callableStatement.addBatch(sql);
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        log.debug(sql);
        return callableStatement.executeUpdate(sql, autoGeneratedKeys);
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        log.debug(sql);
        return callableStatement.executeUpdate(sql, columnIndexes);
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        log.debug(sql);
        return callableStatement.executeUpdate(sql, columnNames);
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        log.debug(sql);
        return callableStatement.execute(sql, autoGeneratedKeys);
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        log.debug(sql);
        return callableStatement.execute(sql, columnIndexes);
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        log.debug(sql);
        return callableStatement.execute(sql, columnNames);
    }

    @Override
    public long executeLargeUpdate(String sql) throws SQLException {
        log.debug(sql);
        return callableStatement.executeLargeUpdate(sql);
    }

    @Override
    public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        log.debug(sql);
        return callableStatement.executeLargeUpdate(sql, autoGeneratedKeys);
    }

    @Override
    public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
        log.debug(sql);
        return callableStatement.executeLargeUpdate(sql, columnIndexes);
    }

    @Override
    public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
        log.debug(sql);
        return callableStatement.executeLargeUpdate(sql, columnNames);
    }
}