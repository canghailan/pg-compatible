package cc.whohow.postgresql.proxy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class JdbcProxyChain implements JdbcProxy {
    protected final JdbcProxy proxy1;
    protected final JdbcProxy proxy2;

    public JdbcProxyChain(JdbcProxy proxy1, JdbcProxy proxy2) {
        this.proxy1 = proxy1;
        this.proxy2 = proxy2;
    }

    @Override
    public Connection newProxyInstance(Connection connection) {
        return proxy2.newProxyInstance(proxy1.newProxyInstance(connection));
    }

    @Override
    public Statement newProxyInstance(Statement statement) {
        return proxy2.newProxyInstance(proxy1.newProxyInstance(statement));
    }

    @Override
    public PreparedStatement newProxyInstance(PreparedStatement preparedStatement) {
        return proxy2.newProxyInstance(proxy1.newProxyInstance(preparedStatement));
    }

    @Override
    public CallableStatement newProxyInstance(CallableStatement callableStatement) {
        return proxy2.newProxyInstance(proxy1.newProxyInstance(callableStatement));
    }
}
