
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
		
	}

	public void deduct_union_service_charge(double union_service_charge)
	{
		if(super.union_membership)
			amount_to_be_paid -= union_service_charge;
	}
}