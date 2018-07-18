package cc.whohow.postgresql.log;

import cc.whohow.postgresql.proxy.AbstractProxyCallableStatement;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CallableStatementSQLLogger extends AbstractProxyCallableStatement {
    protected final SQLLogger logger;

    public CallableStatementSQLLogger(CallableStatement callableStatement, SQLLogger logger) {
        super(callableStatement);
        this.logger = logger;
    }

    @Override
    public ResultSet executeQuery() throws SQLException {
        logger.log(callableStatement);
        return callableStatement.executeQuery();
    }

    @Override
    public int executeUpdate() throws SQLException {
        logger.log(callableStatement);
        return callableStatement.executeUpdate();
    }

    @Override
    public boolean execute() throws SQLException {
        logger.log(callableStatement);
        return callableStatement.execute();
    }

    @Override
    public long executeLargeUpdate() throws SQLException {
        logger.log(callableStatement);
        return callableStatement.executeLargeUpdate();
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        logger.log(sql);
        return callableStatement.executeQuery(sql);
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        logger.log(sql);
        return callableStatement.executeUpdate(sql);
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        logger.log(sql);
        return callableStatement.execute(sql);
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        logger.log(sql);
        callableStatement.addBatch(sql);
    }

    @Override
    public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        logger.log(sql);
        return callableStatement.executeUpdate(sql, autoGeneratedKeys);
    }

    @Override
    public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
        logger.log(sql);
        return callableStatement.executeUpdate(sql, columnIndexes);
    }

    @Override
    public int executeUpdate(String sql, String[] columnNames) throws SQLException {
        logger.log(sql);
        return callableStatement.executeUpdate(sql, columnNames);
    }

    @Override
    public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
        logger.log(sql);
        return callableStatement.execute(sql, autoGeneratedKeys);
    }

    @Override
    public boolean execute(String sql, int[] columnIndexes) throws SQLException {
        logger.log(sql);
        return callableStatement.execute(sql, columnIndexes);
    }

    @Override
    public boolean execute(String sql, String[] columnNames) throws SQLException {
        logger.log(sql);
        return callableStatement.execute(sql, columnNames);
    }

    @Override
    public long executeLargeUpdate(String sql) throws SQLException {
        logger.log(sql);
        return callableStatement.executeLargeUpdate(sql);
    }

    @Override
    public long executeLargeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
        logger.log(sql);
        return callableStatement.executeLargeUpdate(sql, autoGeneratedKeys);
    }

    @Override
    public long executeLargeUpdate(String sql, int[] columnIndexes) throws SQLException {
        logger.log(sql);
        return callableStatement.executeLargeUpdate(sql, columnIndexes);
    }

    @Override
    public long executeLargeUpdate(String sql, String[] columnNames) throws SQLException {
        logger.log(sql);
        return callableStatement.executeLargeUpdate(sql, columnNames);
    }
}