import java.util.Date;
import java.sql.*;

abstract class Employee{
	public int ID;
	protected String Name;
	protected double commission_rate;
	protected String method_of_payment;
	protected boolean union_membership;

	Employee(int ID, String Name,double commission_rate,String method_of_payment,boolean union_membership)
	{
		this.ID = ID;
		this.Name = Name;
		this.commission_rate = commission_rate;
		this.method_of_payment = method_of_payment;
		this.union_membership = union_membership;
	}

	public void toggle_union_membership()
	{
		union_membership = !union_membership;
	}

	public abstract void submit_time_card(double hours_worked,Date date);
	public abstract void submit_commission_receipt(double amount_of_sale,Date date);
	public abstract void deduct_union_service_charge(double union_service_charge);
}

class Work_by_hour_employee extends Employee{
	private double hourly_pay_rate;
	private double amount_to_be_paid;

    Work_by_hour_employee(double hourly_pay_rate,int ID, String Name,double commission_rate,String method_of_payment,boolean union_membership)
	{
		super(ID,Name,commission_rate,method_of_payment,union_membership);
		this.amount_to_be_paid = 0;
		this.hourly_pay_rate = hourly_pay_rate;
	}

	public void submit_time_card(double hours_worked,Date date)
	{
		// System.out.println("Current date is " + date); 

		if(hours_worked > 8)
			amount_to_be_paid += (8+(hours_worked-8)*1.5)*hourly_pay_rate;
		else
			amount_to_be_paid += hours_worked*hourly_pay_rate;
		// System.out.println(amount_to_be_paid);
	}

	public void submit_commission_receipt(double amount_of_sale,Date date)
	{
		amount_to_be_paid += amount_of_sale*super.commission_rate;
	}

	public void deduct_union_service_charge(double union_service_charge)
	{
		if(super.union_membership)
			amount_to_be_paid -= union_service_charge;
	}
}

class Flat_salary_employee extends Employee{
	private double salary;
	private double amount_to_be_paid;

	Flat_salary_employee(double salary,int ID, String Name,double commission_rate,String method_of_payment,boolean union_membership)
	{
		super(ID,Name,commission_rate,method_of_payment,union_membership);
		this.amount_to_be_paid = salary;
		this.salary = salary;
	}

	public void submit_commission_receipt(double amount_of_sale,Date date)
	{
		amount_to_be_paid += amount_of_sale*super.commission_rate;
		System.out.println(amount_to_be_paid);
	}

	public void submit_time_card(double hours_worked,Date date)
	{
		//Raise Exception
	}

	public void deduct_union_service_charge(double union_service_charge)
	{
		if(super.union_membership)
			amount_to_be_paid -= union_service_charge;
	}
}

public class Payroll{
	public static void main(String[] args) 
	{
		// ResultSet myRs = null;

		// try{
		// 	String query = "select * from Employees";
		// 	myRs = SQLConnect.sql(query);
		// 	while (myRs.next()) {
		// 	System.out.println(myRs.getString("Name") + ", " + myRs.getString("worker_type"));
		// 	}
		// }
		// catch (Exception exc) {
		// 	exc.printStackTrace();
		// }

		UseCases.AddEmployee();
	}
}
