package liquibase.database.jvm;

import liquibase.exception.DatabaseException;
import liquibase.servicelocator.LiquibaseService;

import java.sql.Connection;

/**
 * A SybaseASA specific Delegate that removes the calls 
 * to nativeSQL due to driver issues.
 * 
 * @author <a href="mailto:andreas.pohl@mateurope.com">Andreas Pohl</a>
 *
 */
@LiquibaseService(skip=true)
public class SybaseASAConnection extends JdbcConnection {

	public SybaseASAConnection() {}

	public SybaseASAConnection(Connection connection) {
		super(connection);
	}

	@Override
	public String nativeSQL(String sql) throws DatabaseException {
    	return sql;
    }

}
