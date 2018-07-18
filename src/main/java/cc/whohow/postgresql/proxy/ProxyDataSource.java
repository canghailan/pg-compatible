package cc.whohow.postgresql.proxy;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ProxyDataSource extends AbstractProxyDataSource {
    protected final Proxy proxy;

    public ProxyDataSource(DataSource dataSource, Proxy proxy) {
        super(dataSource);
        this.proxy = proxy;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return proxy.newProxyInstance(dataSource.getConnection());
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return proxy.newProxyInstance(dataSource.getConnection(username, password));
    }
}
