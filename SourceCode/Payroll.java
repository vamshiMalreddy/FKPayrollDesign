import java.util.Date;

class Employee{
	public int ID;
	private String Name;
	Employee(int ID, String Name)
	{
		this.ID = ID;
		this.Name = Name;
	}

	public void submit_time_card(double hours_worked,Date date)
	{
		//Implement an exeption here
	}
}

class Work_by_hour_employee extends Employee{
	private double hourly_pay_rate;
	private double amount_to_be_paid;

	Work_by_hour_employee(double hourly_pay_rate,int ID, String Name)
	{
		super(ID,Name);
		this.amount_to_be_paid = 0;
		this.hourly_pay_rate = hourly_pay_rate;
	}

	public void submit_time_card(double hours_worked,Date date)
	{
		System.out.println("Current date is " + date); 

		if(hours_worked > 8)
			amount_to_be_paid += (8+(hours_worked-8)*1.5)*hourly_pay_rate;
		else
			amount_to_be_paid += hours_worked*hourly_pay_rate;
		System.out.println(amount_to_be_paid);
	}
}

public class Payroll{
	public static void main(String[] args) {
		Employee emp = new Work_by_hour_employee(4.5,18,"Vamshi");
		System.out.println(emp.ID);
		emp.submit_time_card(9,new Date(2020,5,10));
	}
}