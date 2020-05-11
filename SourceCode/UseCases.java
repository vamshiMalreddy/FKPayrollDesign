import java.util.*;  
import java.sql.*;

class UseCases
{

	public static void AddEmployee()
	{
		Scanner sc= new Scanner(System.in);

		String salary = "NULL";
		String hourly_pay_rate  = "NULL";

		System.out.print("Enter Name:");
		String Name= sc.nextLine(); 
		System.out.print("Work_by_hour_employee/Flat_salary_employee:");
		String employee_type= sc.nextLine(); 
		System.out.print("Enter Commission Rate:");
		String commission_rate= sc.nextLine(); 
		System.out.print("Enter Method of Payment:");
		String method_of_payment= sc.nextLine(); 
		System.out.print("Union Membership (1(Yes)/0(No)):");
		String union_membership= sc.nextLine(); 
		if(employee_type.equals("Work_by_hour_employee"))
		{
			System.out.print("Enter Hourly pay rate:");
			hourly_pay_rate= sc.nextLine(); 
		}
		else
		{
			System.out.print("Enter Salary:");
			salary= sc.nextLine(); 
		}

		String query = 
		"INSERT INTO Employees (Name,worker_type,commission_rate,method_of_payment,union_membership,hourly_pay_rate,salary,amount_to_be_paid) VALUES ('"
		+Name+"','"+employee_type+"',"+commission_rate+",'"+method_of_payment+"',"+union_membership+","+hourly_pay_rate+","+salary+",0);";
		
		// System.out.println(query);

		int myRs = 0;
		try{
		myRs = SQLConnect.SQL_Update(query);
		}	
		catch (Exception exc) {
			exc.printStackTrace();
		}
		System.out.println("Employee Added!");

	}

	public static void DeleteEmployee()
	{
		Scanner sc= new Scanner(System.in);

		System.out.print("Enter ID of the employee:");
		String ID= sc.nextLine();

		String query = "DELETE FROM Employees WHERE ID="+ID+";";
		int myRs = 0;
		try{
		myRs = SQLConnect.SQL_Update(query);
		}	
		catch (Exception exc) {
			exc.printStackTrace();
		}
		System.out.println("Employee Deleted!");
	}

	public static void UpdateEmployee()
	{
		Scanner sc= new Scanner(System.in);

		System.out.print("Enter ID of the employee:");
		String ID= sc.nextLine();
		System.out.print("Enter column of the employee to be updated:");
		String column= sc.nextLine();
		System.out.print("Enter value of "+column+":" );
		String value= sc.nextLine();
		
		if(column.equals("Name")||column.equals("method_of_payment") ||column.equals("worker_type"))
		{
			value = "'"+value+"'";
		}
		String query = "UPDATE Employees SET "+ column+ " = "+value+" WHERE ID="+ID+";";
		int myRs = 0;
		try{
		myRs = SQLConnect.SQL_Update(query);
		}	
		catch (Exception exc) {
			exc.printStackTrace();
		}
		System.out.println("Employee Updated!");
	}

	public static void PostTimeCard()
	{
		Scanner sc= new Scanner(System.in);

		System.out.print("Enter Your ID:");
		String ID= sc.nextLine(); 
		System.out.print("Enter Date (YYYY-MM-DD):");
		String Date= sc.nextLine(); 
		System.out.print("Enter Hours Worked:");
		double Hours_worked= sc.nextDouble(); 
		
		String query = 
		"INSERT INTO TimeCards VALUES ("
		+ID+",'"+Date+"',"+Hours_worked+");";

		int myRs = 0;
		try{
		myRs = SQLConnect.SQL_Update(query);
		}	
		catch (Exception exc) {
			exc.printStackTrace();
		}
		System.out.println("TimeCard Added!");



		double effective_hours_worked;
		if(Hours_worked > 8.0)
			effective_hours_worked = (8+(Hours_worked-8)*1.5);
		else
			effective_hours_worked = Hours_worked;


		double hourly_pay_rate = 0.0;

 		query = "SELECT * FROM Employees WHERE ID = "+ID;
		ResultSet myRes = null;
		try{
		myRes = SQLConnect.SQL_Query(query);
		myRes.next();
		hourly_pay_rate = myRes.getDouble("hourly_pay_rate");
		// System.out.println(hourly_pay_rate);
		}	
		catch (Exception exc) {
			exc.printStackTrace();
		}


		query = "UPDATE Employees SET "+ "amount_to_be_paid"+ " = amount_to_be_paid+"+effective_hours_worked +"*"+hourly_pay_rate+" WHERE ID="+ID+";";
		// System.out.println(query);
		boolean myR = false;
		try{
		myR = SQLConnect.SQL_execute(query);
		}	
		catch (Exception exc) {
			exc.printStackTrace();
		}

	}
}