package src.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;

import src.logic.Bank;
import src.model.Account;
import src.model.Person;
import src.model.SavingAccount;
import src.model.SpendingAccount;

public class BankTest {
	
	Bank b;
	Person p1,p2;
	Account a1,a2;
	HashMap<Person, List<Account>> testMap;
	
	@Before
	public void init()
	{
		b = new Bank();
		p1 = new Person(20,"Maxim Bogdan", "0735863496", "Maxim Bogdan");
		p2 = new Person(20,"Maxim Bogdan", "0735863496", "Maxim Bogdan");
		a1 = new SavingAccount(7000.00, "bOGDySaving");
		a2 = new SpendingAccount(550.00, "bOGDySpending");
		testMap = new HashMap<Person, List<Account>>();
	}

	@Test
	public void test1() {
		b.addPerson(p1, a1);
		List<Account> lt = new ArrayList<Account>();
		lt.add(a1);
		testMap.put(p2,lt);
		List<Entry<Person, List<Account>>> e1 = new ArrayList<Entry<Person, List<Account>>>();
		List<Entry<Person, List<Account>>> e2 = new ArrayList<Entry<Person, List<Account>>>();
		for(Entry<Person, List<Account>> entry : testMap.entrySet())
			e1.add(entry);
		for(Entry<Person,List<Account>> entry2 : b.getAccounts().entrySet())
			e2.add(entry2);
		assertEquals(e1.size(), e2.size());
		int i = 0;
		while(i<e1.size())
			{
				Person p1 = e1.get(i).getKey();
				Person p2 = e2.get(i).getKey();
				assertEquals(p1.getAge(), p2.getAge());
				assertEquals(p1.getName(), p2.getName());
				assertEquals(p1.getPhonenumber(), p2.getPhonenumber());
				assertEquals(p1.getEmail(), p2.getEmail());
				List<Account> l1 = e1.get(i).getValue();
				List<Account> l2 = e2.get(i).getValue();
				assertEquals(l1.size(),l2.size());
				int j = 0;
				while(j<l1.size())
				{
					Account it1 = l1.get(j);
					Account it2 = l2.get(j);
					assertEquals(it1.getMoney(), it2.getMoney(), 0.001);
					assertEquals(it1.getName(), it2.getName());
					j++;
				}
				i++;
			}
	}
	
	@Before
	public void init2()
	{
		b = new Bank();
		p1 = new Person(20,"Maxim Bogdan", "0735863496", "Maxim Bogdan");
		p2 = new Person(20,"Maxim Bogdan", "0735863496", "Maxim Bogdan");
		a1 = new SavingAccount(7000.00, "bOGDySaving");
		a2 = new SpendingAccount(550.00, "bOGDySpending");
		testMap = new HashMap<Person, List<Account>>();
	}
	
	@Test
	public void test2() {
		b.addPerson(p1, a1);
		List<Account> lt = new ArrayList<Account>();
		lt.add(a2);
		testMap.put(p2,lt);
		List<Entry<Person, List<Account>>> e1 = new ArrayList<Entry<Person, List<Account>>>();
		List<Entry<Person, List<Account>>> e2 = new ArrayList<Entry<Person, List<Account>>>();
		for(Entry<Person, List<Account>> entry : testMap.entrySet())
			e1.add(entry);
		for(Entry<Person,List<Account>> entry2 : b.getAccounts().entrySet())
			e2.add(entry2);
		assertEquals(e1.size(), e2.size());
		int i = 0;
		while(i<e1.size())
			{
				Person p1 = e1.get(i).getKey();
				Person p2 = e2.get(i).getKey();
				assertEquals(p1.getAge(), p2.getAge());
				assertEquals(p1.getName(), p2.getName());
				assertEquals(p1.getPhonenumber(), p2.getPhonenumber());
				assertEquals(p1.getEmail(), p2.getEmail());
				List<Account> l1 = e1.get(i).getValue();
				List<Account> l2 = e2.get(i).getValue();
				assertEquals(l1.size(),l2.size());
				int j = 0;
				while(j<l1.size())
				{
					Account it1 = l1.get(j);
					Account it2 = l2.get(j);
					assertNotEquals(it1.getMoney(), it2.getMoney(), 0.001);
					assertNotEquals(it1.getName(), it2.getName());
					j++;
				}
				i++;
			}
	}
	
	@Before
	public void init3()
	{
		b = new Bank();
		p1 = new Person(20,"Maxim Bogdan", "0735863496", "Maxim Bogdan");
		p2 = new Person(20,"Maxim Bogdan", "0735863496", "Maxim Bogdan");
		a1 = new SavingAccount(7000.00, "bOGDySaving");
		a2 = new SpendingAccount(550.00, "bOGDySpending");
		testMap = new HashMap<Person, List<Account>>();
	}
	
	@Test
	public void test3() {
		b.addPerson(p1, a1);
		b.removePerson(p1);
		List<Account> lt = new ArrayList<Account>();
		List<Entry<Person, List<Account>>> e1 = new ArrayList<Entry<Person, List<Account>>>();
		List<Entry<Person, List<Account>>> e2 = new ArrayList<Entry<Person, List<Account>>>();
		for(Entry<Person, List<Account>> entry : testMap.entrySet())
			e1.add(entry);
		for(Entry<Person,List<Account>> entry2 : b.getAccounts().entrySet())
			e2.add(entry2);
		assertEquals(e1.size(), e2.size());
		int i = 0;
		while(i<e1.size())
			{
				Person p1 = e1.get(i).getKey();
				Person p2 = e2.get(i).getKey();
				assertEquals(p1.getAge(), p2.getAge());
				assertEquals(p1.getName(), p2.getName());
				assertEquals(p1.getPhonenumber(), p2.getPhonenumber());
				assertEquals(p1.getEmail(), p2.getEmail());
				List<Account> l1 = e1.get(i).getValue();
				List<Account> l2 = e2.get(i).getValue();
				assertEquals(l1.size(),l2.size());
				int j = 0;
				while(j<l1.size())
				{
					Account it1 = l1.get(j);
					Account it2 = l2.get(j);
					assertNotEquals(it1.getMoney(), it2.getMoney(), 0.001);
					assertNotEquals(it1.getName(), it2.getName());
					j++;
				}
				i++;
			}
	}
	


}
