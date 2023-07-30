package com.Dc.BankApplication.Model;

public class Account {
	private int accNo;

	private String accName;

	private String accAddr;

	private String accPan;

	private double accBal;


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

	public void setAccBal(double accBal) {
		this.accBal = accBal;
	}

	@Override
	public String toString() {
		return "Account [accNo=" + accNo + ", accName=" + accName + ", accAddr=" + accAddr + ", accPan=" + accPan
				+ ", accBal=" + accBal + "]";
	}

}
