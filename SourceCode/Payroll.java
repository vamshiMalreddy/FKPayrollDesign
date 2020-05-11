import java.util.*;
import java.text.SimpleDateFormat;

import java.sql.*;


public class Payroll{
	public static void main(String[] args) 
	{
		final Calendar calendar = Calendar.getInstance();
		final java.util.Date date = calendar.getTime();
		int day = calendar.get(Calendar.DAY_OF_WEEK);
		String today = new SimpleDateFormat("dd").format(date); 
		System.out.println(day + " "+today);

		if(today.equals("11"))
			UseCases.PayFlatSalary();
		if(day == 2)
		{
			// PostServiceCharge();
			UseCases.PayWeekWorkerSalary();
		}

	}
}
