package bankDetails;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class BankDao {
	
	
	public static boolean insertAccountToDB(Account st) {
        boolean b = false;

        try {
         Connection  con  = CP.createC();
            String query = "insert into Bank_Manage(accName, accPan, accAddress, accBalance) VALUES (?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(query);
          
            pstmt.setString(1, st.getAccName());
            pstmt.setString(2, st.getAccPan());
            pstmt.setString(3, st.getAccAddr());
            pstmt.setDouble(4, st.getAccBal());

            pstmt.executeUpdate();
           b =true;
        } catch (SQLException e) {
            e.printStackTrace();
        } 
        return b;
    }

	public static void AccountDetails(int accountNo) {
	    try {
	        Connection con = CP.createC();
	        String query = "SELECT * FROM Bank_Manage WHERE accNo = ?";

	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, accountNo);

	        ResultSet set = pstmt.executeQuery();

	        if (set.next()) {
	            int id = set.getInt("accNo");
	            String name = set.getString("accName");
	            String pan = set.getString("accPan");
	            String address = set.getString("accAddress");
	            int balance = set.getInt("accBalance");

	            System.out.println("Account No: " + id);
	            System.out.println("Name: " + name);
	            System.out.println("PanNo: " + pan);
	            System.out.println("Address: " + address);
	            System.out.println("Balance: " + balance);
	            System.out.println("++++++++++++++++++");
	        } else {
	            System.out.println("Account not found for account number: " + accountNo);
	        }

	        con.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	public static void withdraw(int accNo, int amount) {
	    try {    
	        Connection con = CP.createC();
	        String query = "UPDATE Bank_Manage SET accBalance = accBalance - ? WHERE accNo = ?";
	        PreparedStatement pstmt = con.prepareStatement(query);
	        pstmt.setInt(1, amount);
	        pstmt.setInt(2, accNo);
	       
	        int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
	            System.out.println("***** Withdrawal successful. *****");
	        }else {
	        	 System.out.println("Withdrawal failed. Please check the account number and try again.");
	        }
	        
	        con.close();	  
	          }catch (SQLException e) {
	        e.printStackTrace();
	    }     
	}

	public static void Deposit(int accNo, int amount) {
		// TODO Auto-generated method stub
		 try {		    
		        Connection con = CP.createC();
		        
		        String query = "UPDATE bank_manage SET accBalance = accBalance + ? WHERE accNo = ?";
		        PreparedStatement pstmt = con.prepareStatement(query);
		        
		        pstmt.setInt(1, amount);
		        pstmt.setInt(2, accNo);
		
		        int rowsAffected = pstmt.executeUpdate();

		        if (rowsAffected > 0) {
		            System.out.println("***** Your Deposit successful *****.");
		        } else {
		            System.out.println("Deposit failed. Please check the account number and try again.");
		        }
		        con.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
	}
	
		public static void updateAccountDetails(int accountNo, String name, String panNumber, String address) {
		    try {
		        Connection con = CP.createC();
		        
		        // Check if the account number exists before proceeding with the update
		        String checkQuery = "SELECT 1 FROM Bank_Manage WHERE accNo = ?";
		        PreparedStatement checkStmt = con.prepareStatement(checkQuery);
		        checkStmt.setInt(1, accountNo);
		        ResultSet resultSet = checkStmt.executeQuery();

		        if (resultSet.next()) {
		            // Account number exists, proceed with the update
		            String updateQuery = "UPDATE bank_manage SET accName = ?, accPan = ?, accAddress = ? WHERE accNo = ?";
		            PreparedStatement pstmt = con.prepareStatement(updateQuery);
		            pstmt.setString(1, name);
		            pstmt.setString(2, panNumber);
		            pstmt.setString(3, address);
		            pstmt.setInt(4, accountNo);

		            int rowsAffected = pstmt.executeUpdate();

		            if (rowsAffected > 0) {
		                System.out.println("****** Account details updated successfully ******.");
		            } else {
		                System.out.println("Account not found for account number: " + accountNo);
		            }
		        } else {
		            System.out.println("Account not found for account number: " + accountNo);
		        }

		        con.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		}
		
		public static boolean deletAccountDetails(int userId) {
			// TODO Auto-generated method stub
			
			
			 boolean b = false;

		        try {
		        	// check account Number before delete account details......
		         Connection  con  = CP.createC();
		            String query = "delete from Bank_Manage where accNo =?";
		            PreparedStatement pstmt = con.prepareStatement(query);
		          
		            pstmt.setInt(1, userId);
		           
		            pstmt.executeUpdate();
		           b =true;
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
		        return b;
			
		}

	}

