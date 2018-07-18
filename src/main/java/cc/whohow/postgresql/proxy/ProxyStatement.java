package cc.whohow.postgresql.proxy;

import java.sql.Statement;

public class ProxyStatement extends AbstractProxyStatement {
    protected final Proxy proxy;

    public ProxyStatement(Statement statement, Proxy proxy) {
        super(statement);
        this.proxy = proxy;
    }
}
