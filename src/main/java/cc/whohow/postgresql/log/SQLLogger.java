package cc.whohow.postgresql.log;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;

public interface SQLLogger {
    void log(String sql);

    void log(PreparedStatement preparedStatement);

    void log(CallableStatement callableStatement);
}
