package banking.test;

import banking.Account;

public class MainlineTest {

	public static void main(String[] args) throws IllegalArgumentException, Exception {
		
		Account a = new Account("Account A");
		debug(a, "Init");
		a.deposit(1000);
		debug(a, "D 1000");
		a.withdraw(200);
		debug(a, "W 200");
		
		Account b = new Account("Account B");
		debug(b, "Init");
		b.deposit(300);
		debug(b, "D 300");
		b.withdraw(50);
		debug(b, "W 50");
		
		a.transfer(200, b);
		debug(a, "T:A->B 200");
		debug(b, "T:B<-A 200");
	}
	
	private static void debug(Account a, String note) {
		System.out.println(a.toString() + " :: " + note);
	}

}
