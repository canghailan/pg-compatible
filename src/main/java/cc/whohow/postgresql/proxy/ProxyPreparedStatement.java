package cc.whohow.postgresql.proxy;

import java.sql.PreparedStatement;

public class ProxyPreparedStatement extends AbstractProxyPreparedStatement {
    protected final Proxy proxy;

    public ProxyPreparedStatement(PreparedStatement preparedStatement, Proxy proxy) {
        super(preparedStatement);
        this.proxy = proxy;
    }
}
