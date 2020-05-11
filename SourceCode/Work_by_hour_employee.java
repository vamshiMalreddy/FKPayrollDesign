
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

		if(hours_worked > 8)
			amount_to_be_paid += (8+(hours_worked-8)*1.5)*hourly_pay_rate;
		else
			amount_to_be_paid += hours_worked*hourly_pay_rate;
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
