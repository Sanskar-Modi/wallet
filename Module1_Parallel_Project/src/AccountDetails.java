
public class AccountDetails {

	private String name;
	private int accNo;
	private String password;
	private String dob;
	private String add;
	private String phone;
	private int balance;
	String trans[] = new String[10];
int i=0;

	public String getTrans() {
		String st = String.join(" ",trans);
	return st;
}



public void setTrans(String string) {
	trans[i] = string;
	i++;
}



	public int getBalance() {
		return balance;
	}



	public void setBalance(int balance) {
		this.balance = balance;
	}



	public String getPhone() {
		return phone;
	}



	@Override
	public String toString() {
		return "AccountDetails name =" + name + "\n accNo =" + accNo + "\n password =" + password + "\n dob =" + dob
				+ "\n add =" + add + "\n phone =" + phone + "\nbalance ="+balance;
	}

	

	public void setPhone(String phone2) {
		this.phone = phone2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAccNo() {
		return accNo;
	}

	public long setAccNo(int accNo2) {
		return this.accNo = accNo2;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getAdd() {
		return add;
	}

	public void setAdd(String add) {
		this.add = add;
	}
	
}
