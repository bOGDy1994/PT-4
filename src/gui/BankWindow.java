package src.gui;

import java.awt.EventQueue;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import src.logic.Bank;
import src.model.Account;
import src.model.Person;
import src.model.SavingAccount;
import src.model.SpendingAccount;

public class BankWindow {

	private JFrame frame;
	private JScrollPane scrollPane;
	private JTable table;
	private JTextField textField;
	private JLabel lblPersonName_1;
	private JTextField textField_1;
	private JLabel lblPersonPhonenumber;
	private JTextField textField_2;
	private JLabel lblPersonEmail;
	private JTextField textField_3;
	private JLabel lblAccountName;
	private JTextField textField_4;
	private JLabel lblAccountMoney;
	private JTextField textField_5;
	private JLabel lblAccountType;
	private JComboBox comboBox;
	private JLabel lblPersons;
	private JComboBox comboBox_1;
	private JLabel lblAccounts;
	private JComboBox comboBox_2;
	private JButton btnAddPerson;
	private JButton btnRemovePerson;
	private JButton btnRemoveAccount;
	private JButton btnExtractMoney;
	private JButton btnAddMoney;
	private JLabel lblSumOfMoney;
	private JTextField textField_6;
	private Bank b;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BankWindow window = new BankWindow();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void FillComboBox()
	{
		comboBox.addItem("Spending Account");
		comboBox.addItem("Saving Account");
	}
	
	private void FillComboBox_1(HashMap<Person,List<Account>> inH)
	{
		comboBox_1.removeAllItems();
		for(Entry<Person,List<Account>> entry : inH.entrySet())
			comboBox_1.addItem(entry.getKey().getName());
	}
	
	private void FillComboBox_2(HashMap<Person,List<Account>> inH)
	{
		comboBox_2.removeAllItems();
		for(Entry<Person,List<Account>> entry : inH.entrySet())
			if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
				{
					List<Account> lis = entry.getValue();
					for(Account ac : lis)
						comboBox_2.addItem(ac.getName());
				}
	}

	/**
	 * Create the application.
	 */
	public BankWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		b = new Bank();
		frame = new JFrame();
		frame.setBounds(100, 100, 900, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JLabel lblBankManagement = new JLabel("Bank Management");
		lblBankManagement.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBankManagement.setBounds(354, 26, 138, 33);
		frame.getContentPane().add(lblBankManagement);
		JLabel lblPersonName = new JLabel("Person age: ");
		lblPersonName.setBounds(403, 398, 95, 14);
		frame.getContentPane().add(lblPersonName);
	    String ColumnNames[] = {"test"};
		Object data[][] = new Object[255][255];
		DefaultTableModel m = new DefaultTableModel(data,ColumnNames);
		table = new JTable();
		table.setBounds(219, 104, 420, 231);
		table.setEnabled(false);
		table.setModel(m);
		table.setVisible(true);
		scrollPane = new JScrollPane();
		scrollPane.setBounds(70, 104, 765, 231);
		scrollPane.setViewportView(table);
		frame.getContentPane().add(scrollPane);
		
		textField = new JTextField();
		textField.setBounds(533, 398, 95, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		lblPersonName_1 = new JLabel("Person name : ");
		lblPersonName_1.setBounds(403, 441, 95, 14);
		frame.getContentPane().add(lblPersonName_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(533, 441, 95, 20);
		frame.getContentPane().add(textField_1);
		
		lblPersonPhonenumber = new JLabel("Person phonenumber : ");
		lblPersonPhonenumber.setBounds(403, 483, 145, 14);
		frame.getContentPane().add(lblPersonPhonenumber);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(533, 483, 95, 20);
		frame.getContentPane().add(textField_2);
		
		lblPersonEmail = new JLabel("Person email : ");
		lblPersonEmail.setBounds(403, 528, 95, 14);
		frame.getContentPane().add(lblPersonEmail);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(533, 528, 95, 20);
		frame.getContentPane().add(textField_3);
		
		lblAccountName = new JLabel("Account name :");
		lblAccountName.setBounds(638, 398, 95, 14);
		frame.getContentPane().add(lblAccountName);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(740, 398, 95, 20);
		frame.getContentPane().add(textField_4);
		
		lblAccountMoney = new JLabel("Account money :");
		lblAccountMoney.setBounds(638, 441, 95, 14);
		frame.getContentPane().add(lblAccountMoney);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(740, 441, 95, 20);
		frame.getContentPane().add(textField_5);
		
		lblAccountType = new JLabel("Account type :");
		lblAccountType.setBounds(638, 483, 95, 14);
		frame.getContentPane().add(lblAccountType);
		
		comboBox = new JComboBox();
		comboBox.setBounds(740, 483, 95, 21);
		FillComboBox();
		frame.getContentPane().add(comboBox);
		
		lblPersons = new JLabel("Persons : ");
		lblPersons.setBounds(70, 401, 95, 14);
		frame.getContentPane().add(lblPersons);
		
		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(172, 398, 95, 21);
		frame.getContentPane().add(comboBox_1);
		
		lblAccounts = new JLabel("Accounts : ");
		lblAccounts.setBounds(70, 444, 95, 14);
		frame.getContentPane().add(lblAccounts);
		
		comboBox_2 = new JComboBox();
		comboBox_2.setBounds(172, 441, 95, 21);
		frame.getContentPane().add(comboBox_2);
		
		JButton btnAddAccount = new JButton("Add account");
		btnAddAccount.setBounds(193, 595, 138, 23);
		btnAddAccount.addActionListener(new AddAccountAction());
		frame.getContentPane().add(btnAddAccount);
		
		btnAddPerson = new JButton("Add person");
		btnAddPerson.setBounds(70, 595, 113, 23);
		btnAddPerson.addActionListener(new AddPersonAction());
		frame.getContentPane().add(btnAddPerson);
		
		btnRemovePerson = new JButton("Remove person");
		btnRemovePerson.setBounds(367, 595, 144, 23);
		btnRemovePerson.addActionListener(new RemovePersonAction());
		frame.getContentPane().add(btnRemovePerson);
		
		btnRemoveAccount = new JButton("Remove account");
		btnRemoveAccount.setBounds(548, 595, 139, 23);
		btnRemoveAccount.addActionListener(new RemoveAccountAction());
		frame.getContentPane().add(btnRemoveAccount);
		
		btnExtractMoney = new JButton("Extract money");
		btnExtractMoney.addActionListener(new ExtractMoneyAction());
		btnExtractMoney.setBounds(697, 595, 138, 23);
		frame.getContentPane().add(btnExtractMoney);
		
		btnAddMoney = new JButton("Add money");
		btnAddMoney.addActionListener(new AddMoneyAction());
		btnAddMoney.setBounds(367, 628, 144, 23);
		frame.getContentPane().add(btnAddMoney);
		
		lblSumOfMoney = new JLabel("Sum of money");
		lblSumOfMoney.setBounds(70, 483, 95, 14);
		frame.getContentPane().add(lblSumOfMoney);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(172, 480, 95, 20);
		frame.getContentPane().add(textField_6);
	}
	
	private class AddPersonAction extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Person p = null;
			try{
				int age = Integer.parseInt(textField.getText());
				p = new Person(age,textField_1.getText(), textField_2.getText(), textField_3.getText());
			}catch (NumberFormatException e)
			{
				JButton ok = new JButton("Ok");
				JOptionPane.showMessageDialog(ok,"Input a valid age!");
			}
			String at = comboBox.getSelectedItem().toString();
			Account a = null;
			double sum = 0;
			if(at.equals("Spending Account"))
			{
				try{
					sum = Double.parseDouble(textField_5.getText());
					a = new SpendingAccount(sum, textField_4.getText());
				}
				catch(NumberFormatException e)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,"Input a valid sum!");
				}
			}
			else
			{
				try
				{
					sum = Double.parseDouble(textField_5.getText());
					a = new SavingAccount(sum, textField_4.getText());
				}
				catch(NumberFormatException e)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,"Input a valid sum!");
				}
			}
			if((p!=null)&&(a!=null))
			{
				b.addPerson(p, a);
				if(b.getError()!=null)
					{
						JButton ok = new JButton("Ok");
						JOptionPane.showMessageDialog(ok,b.getError());
					}
				FillComboBox_1(b.getAccounts());
				FillComboBox_2(b.getAccounts());
			}
		}
		
	}
	
	private class AddAccountAction extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Person p = null;
			for(Entry<Person,List<Account>> entry : b.getAccounts().entrySet())
				if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
					p = entry.getKey();
			Account a = null;
			double sum = 0;
			String at = comboBox.getSelectedItem().toString();
			if(at.equals("Spending Account"))
			{
				try{
					sum = Double.parseDouble(textField_5.getText());
					a = new SpendingAccount(sum, textField_4.getText());
				}
				catch(NumberFormatException e)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,"Input a valid sum!");
				}
			}
			else
			{
				try
				{
					sum = Double.parseDouble(textField_5.getText());
					a = new SavingAccount(sum, textField_4.getText());
				}
				catch(NumberFormatException e)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,"Input a valid sum!");
				}
			}
			if((p!=null)&&(a!=null))
			{
				b.addAccount(p, a);
				if(b.getError()!=null)
					{
						JButton ok = new JButton("Ok");
						JOptionPane.showMessageDialog(ok,b.getError());
					}
				FillComboBox_1(b.getAccounts());
				FillComboBox_2(b.getAccounts());
			}
		}
		
	}
	
	private class RemovePersonAction extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Person p = null;
			for(Entry<Person,List<Account>> entry : b.getAccounts().entrySet())
				if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
					p = entry.getKey();
			if(p!=null)
			{
				b.removePerson(p);
				FillComboBox_1(b.getAccounts());
				FillComboBox_2(b.getAccounts());
			}
		}
		
	}
	
	private class RemoveAccountAction extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Person p = null;
			Account a = null;
			for(Entry<Person,List<Account>> entry : b.getAccounts().entrySet())
				if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
					p = entry.getKey();
			for(Entry<Person,List<Account>> entry : b.getAccounts().entrySet())
				if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
					{
						List<Account> lis = entry.getValue();
						for(Account ac : lis)
							if(ac.getName().equals(comboBox_2.getSelectedItem().toString()))
								a = ac;
					}
			if((p!=null)&&(a!=null))
			{
				b.removeAccount(p, a);
				if(b.getError()!=null)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,b.getError());
				}
				FillComboBox_1(b.getAccounts());
				FillComboBox_2(b.getAccounts());
			}
		}
		
	}
	
	private class ExtractMoneyAction extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Person p = null;
			Account a = null;
			for(Entry<Person,List<Account>> entry : b.getAccounts().entrySet())
				if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
					p = entry.getKey();
			for(Entry<Person,List<Account>> entry : b.getAccounts().entrySet())
				if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
					{
						List<Account> lis = entry.getValue();
						for(Account ac : lis)
							if(ac.getName().equals(comboBox_2.getSelectedItem().toString()))
								a = ac;
					}
			if((p!=null)&&(a!=null))
			{
				double sum = 0;
				try
				{
					sum = Double.parseDouble(textField_6.getText());
				}
				catch(NumberFormatException er)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,"Please input a valid sum!");
				}
				if(sum<0)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,"Please input a valid sum!");
				}
				else
				{
					if(!a.retrieveMoney(sum))
					{
						JButton ok = new JButton("Ok");
						JOptionPane.showMessageDialog(ok,a.getError());
					}
				}
			}
		}
		
	}
	
	private class AddMoneyAction extends AbstractAction
	{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Person p = null;
			Account a = null;
			for(Entry<Person,List<Account>> entry : b.getAccounts().entrySet())
				if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
					p = entry.getKey();
			for(Entry<Person,List<Account>> entry : b.getAccounts().entrySet())
				if(entry.getKey().getName().equals(comboBox_1.getSelectedItem().toString()))
					{
						List<Account> lis = entry.getValue();
						for(Account ac : lis)
							if(ac.getName().equals(comboBox_2.getSelectedItem().toString()))
								a = ac;
					}
			if((p!=null)&&(a!=null))
			{
				double sum = 0;
				try
				{
					sum = Double.parseDouble(textField_6.getText());
				}
				catch(NumberFormatException er)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,"Please input a valid sum!");
				}
				if(sum<0)
				{
					JButton ok = new JButton("Ok");
					JOptionPane.showMessageDialog(ok,"Please input a valid sum!");
				}
				else
				{
					a.addMoney(sum);
				}
			}
		}
		
	}
	
}
