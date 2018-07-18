package cc.whohow.postgresql.log;

import cc.whohow.postgresql.proxy.Proxy;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.Statement;

public class SQLLoggerProxy implements Proxy {
    protected SQLLogger logger;

    public SQLLoggerProxy(SQLLogger logger) {
        this.logger = logger;
    }

    @Override
    public Statement newProxyInstance(Statement statement) {
        return new StatementSQLLogger(statement, logger);
    }

    @Override
    public PreparedStatement newProxyInstance(PreparedStatement preparedStatement) {
        return new PreparedStatementSQLLogger(preparedStatement, logger);
    }

    @Override
    public CallableStatement newProxyInstance(CallableStatement callableStatement) {
        return new CallableStatementSQLLogger(callableStatement, logger);
    }
}
