package cc.whohow.postgresql.proxy;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

public interface Proxy {
    default DataSource newProxyInstance(DataSource dataSource) {
        return dataSource;
    }

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
}
