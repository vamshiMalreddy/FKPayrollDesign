
import java.sql.*;

class SQLConnect{
	public static void sql() throws SQLException {

		Connection myConn = null;
		Statement myStmt = null;
		ResultSet myRs = null;

		try {
			// 1. Get a connection to database  
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Payroll?useSSL=false", "student" , "student");
			
			// 2. Create a statement
			myStmt = myConn.createStatement();
			
			// 3. Execute SQL query
			myRs = myStmt.executeQuery("select * from Employees");
			
			// 4. Process the result set
			while (myRs.next()) {
				System.out.println(myRs.getString("Name") + ", " + myRs.getString("worker_type"));
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			if (myRs != null) {
				myRs.close();
			}
			
			if (myStmt != null) {
				myStmt.close();
			}
			
			if (myConn != null) {
				myConn.close();
			}
		}
	}
}