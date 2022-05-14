package banking;

import java.util.List;

public class Account_Validation extends Account {
	
	public Account_Validation() {
		super();
	}
	public boolean authenicate(List<Account> accounts,int accno,String password) {
		
		for(int i=0;i<accounts.size();i++) {
			if((accounts.get(i).getAccountNumber()== accno) && accounts.get(i).getPassword().equals(password) ) {
				return true;
			}
		}
		return false;
	}
	
}
