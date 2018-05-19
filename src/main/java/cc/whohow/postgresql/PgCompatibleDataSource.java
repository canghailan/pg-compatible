package cc.whohow.postgresql;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.function.Function;
import java.util.logging.Logger;

public class PgCompatibleDataSource implements DataSource {
    private final DataSource dataSource;

    public PgCompatibleDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return new PgCompatibleConnection(dataSource.getConnection());
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return new PgCompatibleConnection(dataSource.getConnection(username, password));
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return dataSource.getLogWriter();
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {
        dataSource.setLogWriter(out);
    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {
        dataSource.setLoginTimeout(seconds);
    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return dataSource.getLoginTimeout();
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return dataSource.getParentLogger();
    }

    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return dataSource.unwrap(iface);
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return dataSource.isWrapperFor(iface);
    }

    @Override
    public String toString() {
        return dataSource.toString();
    }

    public void setPreparedStatementFormatter(Function<PreparedStatement, String> formatter) {
        PgCompatiblePreparedStatement.formatter = formatter;
    }

    public void setCallableStatementFormatter(Function<CallableStatement, String> formatter) {
        PgCompatibleCallableStatement.formatter = formatter;
    }
}
