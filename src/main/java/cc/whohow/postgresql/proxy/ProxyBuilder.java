package cc.whohow.postgresql.proxy;

import javax.sql.DataSource;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.function.Function;
import java.util.function.Supplier;

public class ProxyBuilder implements Proxy, Supplier<Proxy> {
    protected Function<DataSource, DataSource> dataSourceProxy;
    protected Function<Connection, Connection> connectionProxy;
    protected Function<Statement, Statement> statementProxy;
    protected Function<PreparedStatement, PreparedStatement> preparedStatementProxy;
    protected Function<CallableStatement, CallableStatement> callableStatementProxy;

    public Function<DataSource, DataSource> getDataSourceProxy() {
        return dataSourceProxy;
    }

    public ProxyBuilder addDataSourceProxy(Function<DataSource, DataSource> dataSourceProxy) {
        if (this.dataSourceProxy == null) {
            this.dataSourceProxy = dataSourceProxy;
        } else {
            this.dataSourceProxy = this.dataSourceProxy.andThen(dataSourceProxy);
        }
        return this;
    }

    public Function<Connection, Connection> getConnectionProxy() {
        return connectionProxy;
    }

    public ProxyBuilder addConnectionProxy(Function<Connection, Connection> connectionProxy) {
        if (this.connectionProxy == null) {
            this.connectionProxy = connectionProxy;
        } else {
            this.connectionProxy = this.connectionProxy.andThen(connectionProxy);
        }
        return this;
    }

    public Function<Statement, Statement> getStatementProxy() {
        return statementProxy;
    }

    public ProxyBuilder addStatementProxy(Function<Statement, Statement> statementProxy) {
        if (this.statementProxy == null) {
            this.statementProxy = statementProxy;
        } else {
            this.statementProxy = this.statementProxy.andThen(statementProxy);
        }
        return this;
    }

    public Function<PreparedStatement, PreparedStatement> getPreparedStatementProxy() {
        return preparedStatementProxy;
    }

    public ProxyBuilder addPreparedStatementProxy(Function<PreparedStatement, PreparedStatement> preparedStatementProxy) {
        if (this.preparedStatementProxy == null) {
            this.preparedStatementProxy = preparedStatementProxy;
        } else {
            this.preparedStatementProxy = this.preparedStatementProxy.andThen(preparedStatementProxy);
        }
        return this;
    }

    public Function<CallableStatement, CallableStatement> getCallableStatementProxy() {
        return callableStatementProxy;
    }

    public ProxyBuilder addCallableStatementProxy(Function<CallableStatement, CallableStatement> callableStatementProxy) {
        if (this.callableStatementProxy == null) {
            this.callableStatementProxy = callableStatementProxy;
        } else {
            this.callableStatementProxy = this.callableStatementProxy.andThen(callableStatementProxy);
        }
        return this;
    }

    @Override
    public DataSource newProxyInstance(DataSource dataSource) {
        return new ProxyDataSource(dataSourceProxy.apply(dataSource), this);
    }

    @Override
    public Connection newProxyInstance(Connection connection) {
        return new ProxyConnection(connectionProxy.apply(connection), this);
    }

    @Override
    public Statement newProxyInstance(Statement statement) {
        return new ProxyStatement(statementProxy.apply(statement), this);
    }

    @Override
    public PreparedStatement newProxyInstance(PreparedStatement preparedStatement) {
        return new ProxyPreparedStatement(preparedStatementProxy.apply(preparedStatement), this);
    }

    @Override
    public CallableStatement newProxyInstance(CallableStatement callableStatement) {
        return new ProxyCallableStatement(callableStatementProxy.apply(callableStatement), this);
    }

    @Override
    public Proxy get() {
        if (dataSourceProxy == null) {
            dataSourceProxy = Function.identity();
        }
        if (connectionProxy == null) {
            connectionProxy = Function.identity();
        }
        if (statementProxy == null) {
            statementProxy = Function.identity();
        }
        if (preparedStatementProxy == null) {
            preparedStatementProxy = Function.identity();
        }
        if (callableStatementProxy == null) {
            callableStatementProxy = Function.identity();
        }
        return this;
    }
}
