import java.time.LocalDateTime;
import java.util.ArrayList;

public class BankAccount {

	private static int nextAccountID = 1000000;
	private double balance = 0;
	private double withdrawalFee;
	public int accountID;
	
	ArrayList<Transaction> transactionArray = new ArrayList<Transaction>();
	
	public BankAccount(String bankAccount, int balance, double withdrawalFee, double annualInterestRate) {
		
		this.accountID = nextAccountID;
		nextAccountID++;
		this.balance = balance;
		this.withdrawalFee = withdrawalFee;
	}
	
	public BankAccount(String bankAccount) {
		
		this(bankAccount, 0 , 0d, 0d);
	}
	
	public BankAccount(String bankAccount, int balance) {
		
		this(bankAccount, balance, 0d, 0d);
	}
	
	public void deposit(LocalDateTime localDateTime, double amount, String transactionName) {
		
		balance += amount;
		Transaction currentTransaction = new Transaction(localDateTime, amount, transactionName);
		handleTransaction(currentTransaction);
		
	}
	private void handleTransaction(Transaction currentTransaction) {
		
		LocalDateTime currentTime = currentTransaction.getTransactionTime();
		
		if (transactionArray.size()==0) {
			transactionArray.add(currentTransaction);
		}
		
		else {
			boolean found = false;
			for (int i = 0; i < transactionArray.size(); i++) {
			LocalDateTime testTime = transactionArray.get(i).getTransactionTime();
			int compareNum = currentTime.compareTo(testTime);
			if (compareNum <= 0) {
				transactionArray.add(i,currentTransaction);
				found = true;
				break;
			}
			}
			if (found == false) {
				transactionArray.add(currentTransaction);
			}
		}
	}
	
	public void deposit(double amount, String transactionName) {
		deposit(LocalDateTime.now(), amount, transactionName);
	}
	
	public void deposit(double amount) {
		deposit(LocalDateTime.now(), amount, null);
	}
	
	public void withdraw(LocalDateTime localDateTime, double amount, String transactionName) {
		
		balance -= amount;
		balance -= withdrawalFee;
		Transaction currentTransaction = new Transaction(localDateTime, amount, transactionName);
		handleTransaction(currentTransaction);
	}
	
	public void withdraw(double amount, String transactionName) {
		withdraw(LocalDateTime.now(), amount, transactionName);
	}
	
	public void withdraw(double amount) {
		withdraw(LocalDateTime.now(), amount, null);
	}
	
	public ArrayList<Transaction> getTransactions(LocalDateTime startTime, LocalDateTime endTime) {
		
		int startIndex = 0;
		int endIndex = transactionArray.size();
		
		if (startTime == null) {
			startIndex = 0;
		}

		boolean startFilled = false;
		boolean endFilled = false;
		for (int i = 0; i < transactionArray.size(); i++) {
			
			LocalDateTime testTime = transactionArray.get(i).getTransactionTime();
			
			if (startTime != null && !startFilled) {
				int compareStartTime = startTime.compareTo(testTime);
				if (compareStartTime <= 0) {
						startIndex = i;
						startFilled = true;
				}
			}
			
			if (endTime != null && !endFilled) {
				int compareEndTime = endTime.compareTo(testTime);
				if (compareEndTime <= 0) {
						endIndex = ++i;
						endFilled = true;
				}
				
			}
			
		}
		

		return new ArrayList<>(transactionArray.subList(startIndex, endIndex));
	}
	
	public boolean isOverDrawn() {
		
		return balance < 0;
	}
	
	public double getBalance()
	{
		return balance;
	}
	
	public void setWithdrawalFee(double withdrawalFee) {
		
		this.withdrawalFee = withdrawalFee;
	}

}
