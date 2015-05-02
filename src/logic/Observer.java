package src.logic;

import org.joda.time.DateTime;

public class Observer implements Runnable {

	public DateTime d = new DateTime();
	public DateTime dateOfLastUpdate = new DateTime(1971,1,1,0,0);
	Bank b;
	
	public Observer(Bank inB)
	{
		b = inB;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true)
		{
			d = d.now();
			if((d.getDayOfMonth() == 1)&&(d.getMonthOfYear()!=dateOfLastUpdate.getMonthOfYear())&&(d.getYear()!=dateOfLastUpdate.getYear()))
				{ 
					b.update();
					dateOfLastUpdate = d;
				}
		}
	}

}
