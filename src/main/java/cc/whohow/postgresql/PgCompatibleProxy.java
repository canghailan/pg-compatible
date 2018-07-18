package cc.whohow.postgresql;

import cc.whohow.postgresql.log.SQLLogger;
import cc.whohow.postgresql.log.SQLLoggerProxy;
import cc.whohow.postgresql.proxy.ProxyBuilder;

public class PgCompatibleProxy extends ProxyBuilder {
    public PgCompatibleProxy nullCompatible() {
        addPreparedStatementProxy(PgNullCompatiblePreparedStatement::new);
        return this;
    }

    public PgCompatibleProxy addSQLLogger(SQLLogger logger) {
        SQLLoggerProxy proxy = new SQLLoggerProxy(logger);
        addStatementProxy(proxy::newProxyInstance);
        addPreparedStatementProxy(proxy::newProxyInstance);
        addCallableStatementProxy(proxy::newProxyInstance);
        return this;
    }
}
