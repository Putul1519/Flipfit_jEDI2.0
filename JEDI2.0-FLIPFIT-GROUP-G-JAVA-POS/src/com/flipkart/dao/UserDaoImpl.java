package com.flipkart.dao;
import java.sql.*;

public class UserDaoImpl implements UserDaoInterface {
	public int authenticateUser(String email, String password,int roleId)
	{
		Connection con=null;
		PreparedStatement stmt = null;
	    ResultSet rs = null;
	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");
	            con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
	            String query = "SELECT userPass, userId FROM User WHERE userEmail=? and roleId=?";
	            
	            stmt = con.prepareStatement(query);
	            stmt.setString(1, email);
	            stmt.setInt(2, roleId);
	            rs = stmt.executeQuery();
	            if (rs.next()) {
	                String storedPassword = rs.getString("userPass");
	                if (password.equals(storedPassword)){
	                    return rs.getInt("userId");
	                }
	                else {
	                	return -1;
	                	}
	            } else {
	            	
	            	return -1;
	            }
	        } 
	        catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            try {
	                if (stmt != null) stmt.close();
	                if (con != null) con.close();
	            } catch (Exception e) {
	                System.out.println("Error closing resources: " + e.getMessage());
	            }
	        }
	        return 0;

	}
    public int createUser(String name,String email,String password,int roleId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int userId = 0;

		try {
//			System.out.println("Inside addCenter");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);

			String sql = "SELECT MAX(userId) AS maxUserId FROM User";
			pstmt = con.prepareStatement(sql);

			// Execute query
			rs = pstmt.executeQuery();
			if (rs.next())
				userId = rs.getInt("maxUserId") + 1;
			
			sql = "INSERT INTO User VALUES (?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			// Set parameters for PreparedStatement
			pstmt.setInt(1, userId);
			pstmt.setString(2, email);
			pstmt.setString(3, password);
			pstmt.setString(4, name);
			pstmt.setInt(5,roleId);
			// Execute the insert statement
				int rowsInserted = pstmt.executeUpdate();
//				System.out.println(rowsInserted + " User record(s) inserted");
				con.commit();
				return userId;
		}
	        catch (Exception e) {
	            System.out.println("Error User: " + e.getMessage());
	        }
			finally {
	            try {
	                if (pstmt != null) pstmt.close();
	                if (con != null) con.close();
	                if(rs!=null) rs.close();
	            } catch (Exception e) {
	                System.out.println("Error closing resources: " + e.getMessage());
	            }
	       }
		return 0;
    }
}
