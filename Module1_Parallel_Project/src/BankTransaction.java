import java.util.*;

public class BankTransaction {

	AccountDetails acc = new AccountDetails();

	static Scanner sc = new Scanner(System.in);
	HashMap<Integer, AccountDetails> h1 = new HashMap<Integer, AccountDetails>();
	static BankTransaction bank = new BankTransaction();

	public static void main(String[] args) {

		// varaiables
		String cont = "yes";
		int choice;

		// To ask choice from users and perform operations

		while (cont.equals("yes")) {
			System.out.println("Press 1 to Create Account");
			System.out.println("Press 2 to Show Balance");
			System.out.println("Press 3 to Deposit");
			System.out.println("Press 4 to Withdraw");
			System.out.println("Press 5 to Transer Fund");
			System.out.println("Press 6 to Print Transcations");
			System.out.println("Enter Choice");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				bank.createAccount();
				break;
			case 2:
				bank.showBalance();
				break;
			case 3:
				bank.deposit();
				break;
			case 4:
				bank.withdraw();
				break;
			case 5:
				bank.transferFund();
				break;
			case 6:
				bank.showTranscations();
				break;

			}
			System.out.println("Press yes to continue and no to exit  ");
			cont = sc.next();
			if (cont.equals("no")) {
				System.out.println("Bye !!!");
				System.exit(0);
			}
		}
		sc.close();
	}

	// method to create account
	void createAccount() {
		AccountDetails acc = new AccountDetails();
		int accNo = 0;

		System.out.println("Enter name");
		String name = sc.nextLine();
		name += sc.nextLine();
		acc.setName(name);
		System.out.println("Enter Date of Birth in dd-MM-yy format");
		String dob = sc.nextLine();
		acc.setDob(dob);
		System.out.println("Enter address ");
		String add = sc.nextLine();
		acc.setAdd(add);
		System.out.println("Enter phone number");
		String phone = sc.next();
		acc.setPhone(phone);
		accNo = Integer.parseInt(phone) - 10000;
		acc.setAccNo(accNo);
		System.out.println("Enter password");
		String password = sc.nextLine();
		password += sc.next();
		acc.setPassword(password);
		System.out.println("Enter Balance");
		int bal = sc.nextInt();
		acc.setBalance(bal);

		if (h1.containsKey(accNo)) {
			System.out.println("ur Account already exists" + h1);
		} else {

			System.out.println("Account Created");
			acc.setTrans("Account Created\n");
			h1.put(accNo, acc);
		}

	}

	// method to show balance
	void showBalance() {
		System.out.println("Enter account no");
		int accNo = sc.nextInt();

		if (h1.containsKey(accNo)) {
			AccountDetails a = h1.get(accNo);
			boolean pass = bank.validatePass(accNo);
			if (pass) {
				System.out.println("Balance for account " + accNo + " " + a.getBalance());
			} else {
				System.out.println("Password doesn't Exists");
			}

		} else {
			System.out.println("Account doesn't Exists");
		}
	}

	// method to deposit

	void deposit() {
		System.out.println("Enter account no");
		int accNo = sc.nextInt();

		if (h1.containsKey(accNo)) {
			AccountDetails a = h1.get(accNo);
			boolean pass = bank.validatePass(accNo);
			if (pass == true) {
				System.out.println("Enter amount to deposit");
				int deposit = sc.nextInt();
				a.setBalance(a.getBalance() + deposit);
				acc.setTrans("Deposited " + deposit);
				h1.put(accNo, a);
				System.out.println("Updated Balance :" + a.getBalance());
			} else {
				System.out.println("Password doesn't match");
			}

		} else {
			System.out.println("Account doesn't Exists");
		}
	}

	// method to withdraw

	void withdraw()

	{
		System.out.println("Enter account no");
		int accNo = sc.nextInt();

		if (h1.containsKey(accNo)) {
			AccountDetails a = h1.get(accNo);

			boolean pass = bank.validatePass(accNo);
			if (pass == true) {
				System.out.println("Enter amount to withdraw");
				int withdraw = sc.nextInt();
				a.setBalance(a.getBalance() - withdraw);
				acc.setTrans("Withdrawn " + withdraw);
				h1.put(accNo, a);
				System.out.println("Updated Balance :" + a.getBalance());
			} else {
				System.out.println("Password doesn't match");
			}

		} else {
			System.out.println("Account doesn't Exists");
		}

	}

	// method for fund transfer

	void transferFund() {

		System.out.println("Enter account no");
		int accNo = sc.nextInt();
		int accNo1 = 0;

		if (h1.containsKey(accNo)) {
			AccountDetails a = h1.get(accNo);
			System.out.println("Enter the account no to which you want to transfer fund");
			accNo1 = sc.nextInt();
			AccountDetails a1 = h1.get(accNo1);
			if (h1.containsKey(accNo1)) {
				System.out.println("Enter amount to be transferred");
				int transferAmount = sc.nextInt();
				int bal = a.getBalance();
				int bal1 = a1.getBalance();
				if (transferAmount > bal) {
					System.out.println("Transfer Amount Greater than Balance");
					System.out.println("Cannot transfer amount!!");
				} 
			} else {
				System.out.println("Account doesn't Exists");
			}

		} else {
			System.out.println("Account doesn't Exists");
		}

	}

	// void show transactions

	void showTranscations() {
		System.out.println(acc.getTrans());

	}

	// Validations
	// method to validate password

	boolean validatePass(int accno) {

		AccountDetails a = h1.get(accno);
		System.out.println("Enter password");
		String pass = sc.next();
		if (a.getPassword().equals(pass)) {
			return true;
		} else
			return false;
	}
// method to validate balance
		
		boolean validateBal(int accNo,int am)
		{
			AccountDetails  ad =h1.get(accNo);
			if(ad.getBalance()<am)
			return false;
			else
				return true;
		}
	}

}
