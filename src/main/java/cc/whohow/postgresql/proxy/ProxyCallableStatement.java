package cc.whohow.postgresql.proxy;

import java.sql.CallableStatement;

public class ProxyCallableStatement extends AbstractProxyCallableStatement {
    protected final Proxy proxy;

    public ProxyCallableStatement(CallableStatement callableStatement, Proxy proxy) {
        super(callableStatement);
        this.proxy = proxy;
    }
}
