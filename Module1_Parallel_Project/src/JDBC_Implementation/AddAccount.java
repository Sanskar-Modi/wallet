package JDBC_Implementation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class AddAccount {
	static PreparedStatement ps;
	static Connection con;
	static ResultSet rs;
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		AddAccount addAccount = new AddAccount();

		// Step 1: loading the driver class

		Class.forName("oracle.jdbc.driver.OracleDriver");

		// Step 2 : create the connection

		con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "sanskar", "sans123");

		// Step 3 : Creating statement

		// = con.prepareStatement();

		// Step 4 : execute logic and query
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
				addAccount.createAccount();
				break;
			case 2:
				addAccount.showBalance();
				break;
			case 3:
				addAccount.deposit();
				break;
			case 4:
				addAccount.withdraw();
				break;
			case 5:
				addAccount.transferFund();
				break;
			case 6:
				addAccount.showTranscations();
				break;

			}
			System.out.println("Press yes to continue and no to exit  ");
			cont = sc.next();
			if (cont.equals("no")) {
				System.out.println("Bye !!!");
				System.exit(0);
			}
		}

	}

	// method to create account
	void createAccount() throws SQLException {

		System.out.println("Enter name");
		String name = sc.nextLine();
		name += sc.nextLine();
		System.out.println("Enter Date of Birth in dd-MM-yy format");
		String dob = sc.nextLine();
		System.out.println("Enter address ");
		String add = sc.nextLine();
		System.out.println("Enter phone number");
		int phone = sc.nextInt();
		System.out.println("Enter account no");
		int account = sc.nextInt();
		System.out.println("Enter Balance");
		int bal = sc.nextInt();

		ps = con.prepareStatement("insert into AccountDetails values(?,?,?,?,?,?)");
		ps.setString(1, name);
		ps.setInt(2, account);
		ps.setString(3, dob);
		ps.setString(4, add);
		ps.setInt(5, phone);
		ps.setInt(6, bal);
		int ans = ps.executeUpdate();
		if (ans != 0) {
			System.out.println("Record updated");
		}

	}

	// method to show balance
	void showBalance() throws SQLException {
		System.out.println("Enter Account No");
		int accno = sc.nextInt();
		
        ps =con.prepareStatement("Select balance,name from AccountDetails where accountno =?");
		ps.setInt(1, accno);
		ResultSet rs= ps.executeQuery();
		
		while(rs.next())
		{
			System.out.println("Hello Your Name is "+rs.getString(1)+"Balance in your account"+rs.getInt(2));
		}
		
	}

	// method to deposit

	void deposit() {

	}

	// method to withdraw

	void withdraw()

	{

	}

	// method for fund transfer

	void transferFund() {

	}

	// void show transactions

	void showTranscations() {

	}

	// Step 5: closing connection

}
