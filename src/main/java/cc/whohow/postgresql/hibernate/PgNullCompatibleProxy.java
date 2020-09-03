package cc.whohow.postgresql.hibernate;

import cc.whohow.postgresql.proxy.JdbcProxy;

import java.sql.PreparedStatement;

public class PgNullCompatibleProxy implements JdbcProxy {
    @Override
    public PreparedStatement newProxyInstance(PreparedStatement preparedStatement) {
        return new PgNullCompatiblePreparedStatement(preparedStatement);
    }
}
