package src.model;

import org.joda.time.DateTime;

public class SavingAccount extends Account {

	public SavingAccount(double inMoney, String nume) 
	{
		super(inMoney, nume);
		dateOfLastTransaction = new DateTime(1971,1,1,0,0);//this is the initialization date
		minSumMoney = 500.00;
		maxSumMoney = 100000.00;
	}

	@Override
	public void update(double interest, double taxes) 
	{
		money = money + money * interest;//we computate the money by using a monthly loan
		money = money - 0.5*taxes;//as we are in a Saving Account, we suppose that we pay only 50% of the taxes
	}

	@Override
	public boolean retrieveMoney(double sum) 
	{
		DateTime date = new DateTime();
		//we may extract exactly once per month
		if((date.getMonthOfYear()==dateOfLastTransaction.getMonthOfYear())&&(date.getYear() == dateOfLastTransaction.getYear()))
		{
			errorMessage = "You already made a transaction this month!";
			return false;
		}
		if(sum<minSumMoney)
		{
			errorMessage = "You must extract minimum " + minSumMoney + " to make a transaction for this account!";
			return false;
		}
		if(sum>maxSumMoney)
		{
			errorMessage = "You must extract maximum " + maxSumMoney + " to make a transaction for this account!";
			return false;
		}
		money = money - sum;
		dateOfLastTransaction = date;
		return true;
	}

	@Override
	public void addMoney(double sum) 
	{
		money = money + sum;//the adding is the same for everything
	}

}
