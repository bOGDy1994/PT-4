package src.logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

import src.model.Account;
import src.model.Person;

public class Bank implements BankProc {
	private HashMap<Person, List<Account>> AccountList;
	private double interest = 0.25;
	private double taxes = 30.00;
		
		
	public Bank()
	{
		AccountList = new HashMap<Person, List<Account>>();
	}
		
		
	/**
	 * 
	 * @pre p.getID()>=0 
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre !a.getName().equals("")
	 * @pre  Entry<p, a> entry == NULL
	 * @invariant isWellFormed()
	 * @post Entry<p, a> Entry !=NULL
	 */
	@Override
	public void addAccount(Person p, Account a) 
	{
		assert(p.getID()>=0);
		assert(p.getAge()>=18);
		assert(!p.getName().equals(""));
		assert(p.getPhonenumber().length() == 10);
		String expression = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(p.getEmail());
		assert(matcher.matches());
		assert(!a.getName().equals(""));
		List<Account> temp = AccountList.get(p);
		assert(temp!=null);
		isWellFormed();
		temp.add(a);
		AccountList.put(p, temp);
		isWellFormed();
	}

	/**
	 * 
	 * @pre p.getID()>=0 
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre HashMap<p, a> HashMap !=NULL
	 * @invariant isWellFormed()
	 * @post HashMap<p, a> HashMap ==NULL
	 */
	@Override
	public void removeAccount(Person p, Account a) 
	{
		assert(p.getID()>=0);
		assert(p.getAge()>=18);
		assert(!p.getName().equals(""));
		assert(p.getPhonenumber().length() == 10);
		String expression = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(p.getEmail());
		assert(matcher.matches());
		assert(!a.getName().equals(""));
		List<Account> l = AccountList.get(p);
		isWellFormed();
		int index = l.indexOf(a);
		l.remove(index);
		AccountList.put(p, l);
		isWellFormed();
	}
	
	/**
	 * 
	 * @pre p.getID()>=0 
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre HashMap<p, a> HashMap == NULL
	 * @invariant isWellFormed()
	 * @post HashMap<Person, Account> HashMap !=NULL
	 */

	@Override
	public void addPerson(Person p, Account a) 
	{
		assert(p.getID()>=0);
		assert(p.getAge()>=18);
		assert(!p.getName().equals(""));
		assert(p.getPhonenumber().length() == 10);
		String expression = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(p.getEmail());
		assert(matcher.matches());
		assert(!a.getName().equals(""));
		List<Account> temp = AccountList.get(p);
		assert(temp==null);
		isWellFormed();
		temp = new ArrayList<Account>();
		temp.add(a);
		AccountList.put(p, temp);
		isWellFormed();

	}

	/**
	 * 
	 * @pre p.getID()>=0 
	 * @pre p.getAge()>=18 
	 * @pre !p.getName().equals("") 
	 * @pre p.getPhonenumber().length == 10 
	 * @pre p.getEmail().equals(*@*.*)
	 * @pre HashMap<p, a> HashMap !=NULL
	 * @invariant isWellFormed()
	 * @post foreach Entry<p, a> entry in HashMap
	 * 			entry == NULL
	 */
	@Override
	public void removePerson(Person p) 
	{

		assert(p.getID()>=0);
		assert(p.getAge()>=18);
		assert(!p.getName().equals(""));
		assert(p.getPhonenumber().length() == 10);
		String expression = "\\b[\\w.%-]+@[-.\\w]+\\.[A-Za-z]{2,4}\\b";
		Pattern pattern = Pattern.compile(expression);
		Matcher matcher = pattern.matcher(p.getEmail());
		assert(matcher.matches());
		isWellFormed();
		AccountList.remove(p);
		isWellFormed();
	}
	
	/**
	 * 
	 * @pre NULL
	 * @post HashMap<Person,Account>
	 */
	public HashMap<Person,List<Account>> getAccounts()
	{
		return AccountList;
	}
	
	/**
	 * 
	 * @pre nothing
	 * @invariant foreach Entry<Person, Account> entry in HashMap<Person,Account>
	 * 				Account a = entry.getValue();
	 * 				a!=NULL;
	 * 				
	 * @post nothing
	 */
	private void isWellFormed()
	{
		for(Entry<Person,List<Account>> entry : AccountList.entrySet())
		{
			List<Account> a = entry.getValue();
			assert(a!=null);
		}
	}
	
	public void update()
	{
		for(Entry<Person,List<Account>> entry : AccountList.entrySet())
		{
			List<Account> showL = entry.getValue();
			for(Account it : showL)
				it.update(interest, taxes);
		}		
	}

}
