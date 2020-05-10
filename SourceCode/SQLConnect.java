
import java.sql.*;

class SQLConnect{

	public static ResultSet SQL_Query(String query) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// 1. Get a connection to database  
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payroll?useSSL=false", "student" , "student");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery(query);
			
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return myRs;
	}

	public static int SQL_Update(String query) throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		int myRs =0;

		try {
			// 1. Get a connection to database  
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payroll?useSSL=false", "student" , "student");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeUpdate(query);
			
			
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		return myRs;
	}
}

// Alter table Emoloyees ADD (amount_to_be_paid INT NOT NULL default 0);
