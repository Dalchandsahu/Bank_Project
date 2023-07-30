package bankDetails;
import java.util.*;

public class Start {

	private static Scanner sc;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("******* Welcome to Bank *********");
		sc = new Scanner(System.in);
		boolean b = true;
		while(b) {
			
			System.out.println("Press 1 for Account creation");
			System.out.println("Press 2 for view Account");
			System.out.println("Press 3 for withdraw money");
			System.out.println("Press 4  for deposit money");
			System.out.println("Press 5 for update Account");
			System.out.println("Press 6 for Delete Account");
			System.out.println("Press 7 for EXIT");
			int c =sc.nextInt();
			if(c==1) {
				// add student
				System.out.println("Enter Account Holder name");
				String AccName = sc.next();
				
				System.out.println("Enter your Address");
				String Accadd = sc.next();
				
				System.out.println("Enter pan Number");
				String AccPan = sc.next();
				
				System.out.println("Enter Inisiate Amount");
				int AccBal = sc.nextInt();
				
				// Create student object class
				
				Account st = new Account(AccName, Accadd, AccPan, AccBal);
				boolean answer = BankDao.insertAccountToDB(st);
				if(answer) {
					System.out.println("Account add successfully");
				}
				else {
					System.out.println("something wrong");
				}
				System.out.println(st);
				
				
			}
			else if(c==2) {
				// display data
				System.out.println("Enter You Account No");
				
				int AccountNo = sc.nextInt();
				BankDao.AccountDetails(AccountNo);
				
			}
			
			else if(c==3) {
				// Withdraw account
				System.out.println("Enter Your Account No");
				int accNo =Integer.parseInt(sc.next());
				
				System.out.println("Enter your amount");
				int amount =Integer.parseInt(sc.next());
				
				BankDao.withdraw(accNo ,amount);
			}
			
			else if(c==4) {
				// deposit
				System.out.println("Enter Your Account No");
				int accNo =Integer.parseInt(sc.next());
				
				System.out.println("Enter your amount");
				int amount =Integer.parseInt(sc.next());
				
				BankDao.Deposit(accNo ,amount);
				
			}
			
			else if(c==5) {
				// update
				System.out.println("Enter Account Number");
				int accountNo = sc.nextInt();
				
				System.out.println("Enter Your new name");
				String name = sc.next();
				
				System.out.println("Enter Your new panNumber");
				String panNumber = sc.next();
				
				System.out.println("Enter Your new address");
				String address = sc.next();
				
				BankDao.updateAccountDetails(accountNo, name, panNumber, address);
				
			}
			
			else if(c==6) {
				// delete account
				System.out.println("Enter user id");
				int userId =Integer.parseInt(sc.next());
			boolean as=	BankDao.deletAccountDetails(userId);
			if(as) {
				
				System.out.println("Account deleted successfully");
			}
			else {
				System.out.println("something wrong");
			}
			}
			else if(c==7){
				//exit
				break;
			}
			else {
				
			}

	}
		System.out.println("Thank you for using application");

}
}