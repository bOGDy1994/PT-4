package src.model;

import org.joda.time.DateTime;

public class SpendingAccount extends Account {

	public SpendingAccount(double inMoney, String nume) 
	{
		super(inMoney, nume);
		numberOfTransactions = 0;//we may do up to three transactions
		dateOfLastTransaction = new DateTime(1971,1,1,0,0);//this is the initialization date
		minSumMoney = 10.00;
		maxSumMoney = 5000.00;
	}

	@Override
	public void update(double interest, double taxes) 
	{
		money = money + money * interest;//we computate the money by using a monthly loan
		money = money - taxes;//as we are in a Spending Account, we suppose that we pay all of the taxes
	}

	@Override
	public boolean retrieveMoney(double sum) 
	{
		DateTime date = new DateTime();
		if((date.getDayOfMonth() == dateOfLastTransaction.getDayOfMonth())&&(date.getMonthOfYear() == dateOfLastTransaction.getMonthOfYear())&&(date.getYear() == dateOfLastTransaction.getYear()))
			if (numberOfTransactions > 2)
			{
				errorMessage = "You cannot have more than three transactions per day!";
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
		if((date.getDayOfMonth() == dateOfLastTransaction.getDayOfMonth())&&(date.getMonthOfYear() == dateOfLastTransaction.getMonthOfYear())&&(date.getYear() == dateOfLastTransaction.getYear()))
		{
			numberOfTransactions++;
		}
		else
		{
			numberOfTransactions = 1;
		}
		dateOfLastTransaction = date;
		return true;
	}

	@Override
	public void addMoney(double sum) 
	{
		money = money + sum;//the adding is the same for everything
	}

}
