package cc.whohow.postgresql.proxy;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public interface JdbcProxy {
    default Connection newProxyInstance(Connection connection) {
        return connection;
    }

    default Statement newProxyInstance(Statement statement) {
        return statement;
    }

    default PreparedStatement newProxyInstance(PreparedStatement preparedStatement) {
        return preparedStatement;
    }

    default CallableStatement newProxyInstance(CallableStatement callableStatement) {
        return callableStatement;
    }

    default JdbcProxy andThen(JdbcProxy after) {
        return new JdbcProxyChain(this, after);
    }
}
