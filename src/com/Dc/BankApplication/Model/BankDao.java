package com.Dc.BankApplication.Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BankDao {
    public static boolean insertAccountToDB(Account bA) {
        boolean isSuccess = false;
        Connection con = null;
        try {
            con = CP.createC();
            String query = "INSERT INTO account (accNo, accName, accPan, accAddress, accBalance) VALUES (?, ?, ?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setInt(1, bA.getAccNo());
            pstmt.setString(2, bA.getAccName());
            pstmt.setString(3, bA.getAccPan());
            pstmt.setString(4, bA.getAccAddr());
            pstmt.setDouble(5, bA.getAccBal());

            int rowsInserted = pstmt.executeUpdate();
            if (rowsInserted > 0) {
                isSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            CP.closeConnection(con);
        }
        return isSuccess;
    }
}
