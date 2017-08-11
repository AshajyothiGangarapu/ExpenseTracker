package com.alacriti.expensetrack.biz.delegate;


import java.sql.Connection;
import java.sql.SQLException;

import com.alacriti.expensetrack.datasource.MySqlDataSource;

public class BaseDelegate {

	//private static final AppLogger log = LogUtil.getLogger(BaseDelegate.class);

	private Connection connection;

	public void setConnection(Connection _connection) {
		//log.debugPrintCurrentMethodName();
		this.connection = _connection;
	}

	public Connection getConnection() {
		//log.debugPrintCurrentMethodName();
		return connection;
	}

	protected void endDBTransaction(Connection connection) {
		//log.debugPrintCurrentMethodName();
		try {
			connection.commit();

		} catch (SQLException e) {
			e.printStackTrace();
			//log.logError("SQLException in endDBTransaction " + e.getMessage(), e);
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e.printStackTrace();
				//log.logError("SQLException in endDBTransaction" + e1.getMessage(), e1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	protected void endDBTransaction(Connection connection, boolean isRollback) {

		if (isRollback) {
			try {
				connection.rollback();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			finally {
				try {
					if (connection != null)
						connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		} else {
			endDBTransaction(connection);
		}

	}

	protected Connection startDBTransaction() {
		//log.debugPrintCurrentMethodName();
		Connection conn = null;
		try {
			if (conn == null || conn.isClosed())
				conn = MySqlDataSource.getInstance().getConnection();

			conn.setAutoCommit(false);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
