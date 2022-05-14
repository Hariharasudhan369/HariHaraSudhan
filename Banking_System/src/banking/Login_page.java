package banking;

import java.util.List;
import java.util.Scanner;

public class Login_page extends Account {
	
	private int accountNO;
	private String name;
	private String password;
	private List<Account> accounts;
	private double balance;
	private int pin;
	private Account curacc;
	private int index;
	public Login_page() {
		
	}
	
	public Login_page(List<Account> accounts,int accountNO ,String name, String password) {
		super();
		this.accounts = accounts;
		for(int i=0;i<accounts.size();i++) {
			if((accounts.get(i).getAccountNumber()== accountNO) && accounts.get(i).getPassword().equals(password) ) {
				this.accountNO = accounts.get(i).getAccountNumber();
				this.name = accounts.get(i).getName();
				this.password = accounts.get(i).getPassword();
				this.pin=accounts.get(i).getPin();
				this.balance=accounts.get(i).getBalance();
				this.index =i;
				login_UI(accountNO, name);
			}
	}
	}
	void login_UI(int accountNO ,String name) {
		
		Scanner sc = new Scanner(System.in);
		int res = 0;
		while(res!=5) {
		System.out.println(":) Welcome "+name+" :)");
		System.out.println("1 - Show account details");
		System.out.println("2 - Deposit");
		System.out.println("3 - Transfer");
		System.out.println("4 - Change Password");
		System.out.println("5 - Logout");
	
		res = sc.nextInt();
		sc.nextLine();
		if(res == 1) {
			System.out.println("-----Your Account Details-----");
			System.out.println("Account No: "+ accountNO);
			System.out.println("Account Holder Name: "+ name);
			System.out.println("Account Balance is RS: "+ balance);
		}
		else if(res == 2) {
			System.out.println("Pls enter the amount");
			double amount = sc.nextDouble();
			accounts.get(index).setBalance(amount);
			this.balance = amount;
			System.out.println("Amount deposited succesfully");
		}
		else if(res == 3) {
			int size = 0;
			System.out.println("Available payee list:");
			for(int i=0;i<accounts.size();i++) {
				if(i!=index) {
					size++;
					System.out.println("Account no: "+accounts.get(i).getAccountNumber()+" Account holder name "+accounts.get(i).getName());
				}
			}
			if(size==0) {
				System.out.println("No available payees");
			}else {
				System.out.println("Please enter payee account no: ");
				int payeeno= sc.nextInt();
				System.out.println("Please enter the amount need to transfer: ");
				double transferAmount = sc.nextDouble();
			    System.out.println("Please enter your transaction pin: ");
			    int tpin = sc.nextInt();
			    if(tpin!=pin) {
			    	System.out.println("Invalid Pin");
			    }else {
			    	if(transferAmount>balance) {
			    		System.out.println("Amount Not Available in your account");
			    	}else {
			    		for(int i=0;i<accounts.size();i++) {
			    			if((accounts.get(i).getAccountNumber()== payeeno)) {
			    				double payeebalance = accounts.get(i).getBalance() + transferAmount ;
			    				accounts.get(i).setBalance(payeebalance);
			    				double amount = accounts.get(index).getBalance() - transferAmount;
			    				accounts.get(index).setBalance(amount);
			    				this.balance = amount;
			    				System.out.println("Amount transfered Successfully");
			    				System.out.println("Available balance is "+balance);
			    			}
			    		}
			    	}
			    }
			}
		}
		else if(res == 4) {
			String password = null;
			boolean flag = true;
			while(flag){
				System.out.println("Please set Password:");
				String pass = sc.nextLine();
				System.out.println("Please Re-Enter Password:");
				String rPass = sc.nextLine();
				if(!(pass.equals(rPass))) {
					System.out.println("Password Mis-matching please Try again...");
				}
				else {
					flag = false;
					password = rPass;
				}
			}
			accounts.get(index).setPassword(password);
		}
		else if(res == 5) {
			System.out.println("Logging out......");
		}
	}
	}
	
}
