package banking;

public class Account {
	
	private int accountNumber;
	private String Name;
	private String password;
	private double balance;
	private int pin;
	public Account(int accountNumber,String Name,String password,double balance,int pin) {
		this.accountNumber=accountNumber;
		this.Name=Name;
		this.password=password;
		this.balance=balance;
		this.pin=pin;
	}
	public Account() {
		
	}
	public void setName(String Name) {
		this.Name = Name;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAccountNumber() {
		return accountNumber;
	}
	public String getName() {
		return Name;
	}
	public String getPassword() {
		return password;
	}
	public double getBalance() {
		return balance;
	}
	public int getPin() {
		return pin;
	}

}
