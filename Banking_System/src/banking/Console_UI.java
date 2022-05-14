package banking;

import java.util.ArrayList;
import java.util.Scanner;

public class Console_UI {
	
	public static int countOfAccountNO = 1;
	public Console_UI() {
		Scanner sc = new Scanner(System.in);
		int StartUI = 0;
		ArrayList<Account> Accounts = new ArrayList<>();
		Account_Validation validate = new Account_Validation();
		System.out.println(".........Welcome to HHSS Bank.........");
		while(StartUI!=3) {
			System.out.println("1 - Create Account");
			System.out.println("2 - login to existing account");
			System.out.println("3 - Close the application");
			System.out.println("...Waiting for your response...!");
			StartUI = sc.nextInt();
			sc.nextLine();
			if(StartUI == 3) {
				System.out.println(".........Thank you for using HHSS banking services.........");
			}
			else {
				if(StartUI == 1) {
					double balance = 0;
					System.out.println("..........Account Creation Page.........");
					System.out.println("Please enter your name:");
					String uName = sc.nextLine();
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
					System.out.println("Please set Transaction Pin for payments:");
					int pin = sc.nextInt();
					sc.nextLine();
					System.out.println("...All Set...");
					System.out.println("Your user name is "+uName);
					System.out.println("Please loin from start");
					Accounts.add (new Account(countOfAccountNO++,uName,password,balance,pin));
					System.out.println("Your Account Details");
					System.out.println("Account No: "+ Accounts.get(countOfAccountNO-2).getAccountNumber());
					System.out.println("Account Holder Name: "+ Accounts.get(countOfAccountNO-2).getName());
					System.out.println("Account Balance: "+ Accounts.get(countOfAccountNO-2).getBalance());
				}
				
				else if(StartUI == 2) {
					
					System.out.println("..........Account Login Page.........");
					System.out.println("Enter UserName:");
					String uName = sc.nextLine();
					System.out.println("Enter Account NO:");
					int accno = sc.nextInt();
					sc.nextLine();
					System.out.println("Enter Password:");
					String password = sc.nextLine();
					boolean res =  validate.authenicate(Accounts, accno, password);
					int count = 3;
					if(res==false) {
						while(count>0) {
						System.out.println("Invalid password "+count--+" attempts left Enter Password Again:");
						 password = sc.nextLine();
						 res =  validate.authenicate(Accounts, accno, password);
						 if(res==true) {
							 System.out.println("---!Logging in into your account!---");
							break;
						 }
						}
					}
					if(res==true) {
						Login_page login = new Login_page(Accounts,accno,uName,password);
					}
					
				}
			}
		}
				
	}

}
