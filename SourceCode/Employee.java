
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
