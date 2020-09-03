package cc.whohow.postgresql.logging;

import cc.whohow.postgresql.proxy.JdbcProxy;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class LoggingProxy implements JdbcProxy {
    @Override
    public Statement newProxyInstance(Statement statement) {
        return new LoggingStatement(statement);
    }

    @Override
    public PreparedStatement newProxyInstance(PreparedStatement preparedStatement) {
        return new LoggingPreparedStatement(preparedStatement);
    }

    @Override
    public CallableStatement newProxyInstance(CallableStatement callableStatement) {
        return new LoggingCallableStatement(callableStatement);
    }
}
