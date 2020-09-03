package cc.whohow.postgresql.hibernate;

import cc.whohow.postgresql.proxy.WrapperPreparedStatement;
import org.postgresql.util.PGobject;

import java.lang.reflect.UndeclaredThrowableException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;

public class PgNullCompatiblePreparedStatement extends WrapperPreparedStatement {
    private static final PGobject NULL = pgNull();

    public PgNullCompatiblePreparedStatement(PreparedStatement preparedStatement) {
        super(preparedStatement);
    }

    private static PGobject pgNull() {
        try {
            PGobject pgNull = new PGobject();
            pgNull.setType("varchar");
            pgNull.setValue(null);
            return pgNull;
        } catch (SQLException e) {
            throw new UndeclaredThrowableException(e);
        }
    }

    @Override
    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        if (sqlType == Types.VARBINARY || sqlType == Types.VARCHAR || sqlType == Types.LONGVARCHAR) {
            preparedStatement.setObject(parameterIndex, NULL);
        } else {
            preparedStatement.setNull(parameterIndex, sqlType);
        }
    }

    @Override
    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        if (sqlType == Types.VARBINARY || sqlType == Types.VARCHAR || sqlType == Types.LONGVARCHAR) {
            preparedStatement.setObject(parameterIndex, NULL);
        } else {
            preparedStatement.setNull(parameterIndex, sqlType, typeName);
        }
    }
}
