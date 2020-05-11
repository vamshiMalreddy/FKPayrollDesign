import java.util.*;
import java.text.SimpleDateFormat;

import java.sql.*;



publici class Payroll{
	public static void main(String[] args) 
	{
		final Calendar calendar = Calendar.getInstance();
		final java.util.Date date = calendar.getTime();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		String today = new SimpleDateFormat("dd").format(date); 
		System.out.println(day + " "+today);

		if(today.equals("28"))
			UseCases.PayFlatSalary();
		if(day == 6)
		{
			PostServiceCharge();
			UseCases.PayWeekWorkerSalary();
		}

	}
}
