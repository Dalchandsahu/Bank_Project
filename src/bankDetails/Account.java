package bankDetails;

public class Account {
	
	private int accNo;

	private String accName;

	private String accAddr;

	private String accPan;

	private int accBal;

	public Account(int accNo, String accName, String accAddr, String accPan, int accBal) {
		super();
		this.accNo = accNo;
		this.accName = accName;
		this.accAddr = accAddr;
		this.accPan = accPan;
		this.accBal = accBal;
	}

	public Account(String accName, String accAddr, String accPan, int accBal) {
		super();
		this.accName = accName;
		this.accAddr = accAddr;
		this.accPan = accPan;
		this.accBal = accBal;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}

	public String getAccAddr() {
		return accAddr;
	}

	public void setAccAddr(String accAddr) {
		this.accAddr = accAddr;
	}

	public String getAccPan() {
		return accPan;
	}

	public void setAccPan(String accPan) {
		this.accPan = accPan;
	}

	public double getAccBal() {
		return accBal;
	}

	public void setAccBal(int accBal) {
		this.accBal = accBal;
	}

	@Override
	public String toString() {
		return "Student [accNo=" + accNo + ", accName=" + accName + ", accAddr=" + accAddr + ", accPan=" + accPan
				+ ", accBal=" + accBal + "]";
	}

	
	

}
