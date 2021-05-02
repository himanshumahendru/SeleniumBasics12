import java.sql.SQLException;

import utilities.DbManager;

public class DBconn {

	public static void main(String[] args) throws SQLException {

		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("Select SQL Query"));
		
	}

}
