import java.util.*;  
import java.sql.*;

class UseCases
{

	public static void AddEmployee()
	{
		Scanner sc= new Scanner(System.in);

		String salary = "NULL";
		String employee_type;
		String ID;
		String Name;
		String commission_rate;
		String method_of_payment;
		String union_membership;
		String hourly_pay_rate  = "NULL";

		System.out.print("Enter Name:");
		Name= sc.nextLine(); 
		System.out.print("Work_by_hour_employee/Flat_salary_employee:");
		employee_type= sc.nextLine(); 
		System.out.print("Enter Commission Rate:");
		commission_rate= sc.nextLine(); 
		System.out.print("Enter Method of Payment:");
		method_of_payment= sc.nextLine(); 
		System.out.print("Union Membership (1(Yes)/0(No)):");
		union_membership= sc.nextLine(); 
		if(employee_type == "Work_by_hour_employee")
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
}