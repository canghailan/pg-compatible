package cc.whohow.postgresql.proxy;

import java.sql.*;

public class ProxyConnection extends AbstractProxyConnection {
    protected final Proxy proxy;

    public ProxyConnection(Connection connection, Proxy proxy) {
        super(connection);
        this.proxy = proxy;
    }

    @Override
    public Statement createStatement() throws SQLException {
        return proxy.newProxyInstance(connection.createStatement());
    }

    @Override
    public PreparedStatement prepareStatement(String sql) throws SQLException {
        return proxy.newProxyInstance(connection.prepareStatement(sql));
    }

    @Override
    public CallableStatement prepareCall(String sql) throws SQLException {
        return proxy.newProxyInstance(connection.prepareCall(sql));
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
        return proxy.newProxyInstance(connection.createStatement(resultSetType, resultSetConcurrency));
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return proxy.newProxyInstance(connection.prepareStatement(sql, resultSetType, resultSetConcurrency));
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
        return proxy.newProxyInstance(connection.prepareCall(sql, resultSetType, resultSetConcurrency));
    }

    @Override
    public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return proxy.newProxyInstance(connection.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability));
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return proxy.newProxyInstance(connection.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
    }

    @Override
    public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
        return proxy.newProxyInstance(connection.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability));
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
        return proxy.newProxyInstance(connection.prepareStatement(sql, autoGeneratedKeys));
    }

    @Override
    public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
        return proxy.newProxyInstance(connection.prepareStatement(sql, columnIndexes));
    }

    @Override
    public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
        return proxy.newProxyInstance(connection.prepareStatement(sql, columnNames));
    }
}
