package cc.whohow.postgresql.proxy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ProxyDataSource extends WrapperDataSource {
    protected final JdbcProxy proxy;

    public ProxyDataSource(DataSource dataSource, JdbcProxy proxy) {
        super(dataSource);
        this.proxy = proxy;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return new ProxyConnection(proxy.newProxyInstance(dataSource.getConnection()), proxy);
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return new ProxyConnection(proxy.newProxyInstance(dataSource.getConnection(username, password)), proxy);
    }
}
