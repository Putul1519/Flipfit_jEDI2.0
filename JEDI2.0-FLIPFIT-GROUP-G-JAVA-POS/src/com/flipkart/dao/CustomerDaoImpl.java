package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.bean.Slot;
import com.flipkart.exception.BookingFailedException;
import com.flipkart.exception.GymNotFoundException;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the FlipFitCustomerDAOInterface that handles customer operations related to gyms and slots.
 */
public class CustomerDaoImpl implements  CustomerDaoInterface {
	public void createUser(int userId,String contactNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int customerId=1;

		try {
			System.out.println("Inside addCenter");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);

			String sql = "SELECT MAX(customerId) AS maxcustomerId FROM Customer";
			pstmt = con.prepareStatement(sql);

			// Execute query
			rs = pstmt.executeQuery();
			if (rs.next())
				customerId = rs.getInt("maxcustomerId") + 1;
			
			sql = "INSERT INTO Customer VALUES (?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			// Set parameters for PreparedStatement
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, userId);
			pstmt.setString(3, contactNo);
			// Execute the insert statement
			int rowsInserted = pstmt.executeUpdate();
			con.commit();
//			System.out.println(rowsInserted + " Customer record inserted");
		}
	        catch (Exception e) {
	            System.out.println("Error Customer: " + e.getMessage());
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
	}
	public List<Center> viewCenters(){
		 Connection con = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Center> gymList = new ArrayList<Center>();
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");

	            String query = "SELECT * FROM Center";
	            stmt = con.prepareStatement(query);
	            rs = stmt.executeQuery();
	            while (rs.next()) {
	                int gymId = rs.getInt("centerId");
	                int ownerId = rs.getInt("centerOwnerId");
	                String gymName = rs.getString("centerName");
	                String gymLocation = rs.getString("centerLoc");
	                gymList.add(new Center(gymId, ownerId, gymName, gymLocation));
	            }
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (con != null) con.close();
	            } catch (Exception e) {
	                System.out.println("Error closing resources: " + e.getMessage());
	            }
	        }
	        return gymList;
	}
	public List<Slot> viewSlots(int gymId,String date)throws GymNotFoundException{
		    Connection con = null;
	        PreparedStatement stmtSlots = null;
	        PreparedStatement stmtBookings = null;
	        ResultSet rsSlots = null;
	        ResultSet rsBookings = null;
	        List<Slot> slotAvailability = new ArrayList<>();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");

	            String querySlots = "SELECT * FROM Slot WHERE centerId=?";
	            stmtSlots = con.prepareStatement(querySlots);
	            stmtSlots.setInt(1, gymId);
	            rsSlots = stmtSlots.executeQuery();


	            while (rsSlots.next()) {
	                int slotId = rsSlots.getInt("slotId");
	                String slotStartTime = rsSlots.getString("slotStartTime");
	                String slotEndTime = rsSlots.getString("slotEndTime");
	                int slotMaxCap = rsSlots.getInt("slotMaxCap");
	                int slotCurrCap=rsSlots.getInt("slotCurrCap");
	                String slotDate=rsSlots.getString("slotDate");
	                String slotPrice=rsSlots.getString("slotPrice");
	                int slotStatus=rsSlots.getInt("slotStatus");
	                Slot s=new Slot(slotId,slotStatus,slotStartTime, slotEndTime, slotMaxCap,slotPrice,slotCurrCap, 
	                        gymId,slotDate);
	                slotAvailability.add(s);
	            }

	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            try {
	                if (rsBookings != null) rsBookings.close();
	                if (stmtBookings != null) stmtBookings.close();
	                if (rsSlots != null) rsSlots.close();
	                if (stmtSlots != null) stmtSlots.close();
	                if (con != null) con.close();
	            } catch (Exception e) {
	                System.out.println("Error closing resources: " + e.getMessage());
	            }
	        }

	        return slotAvailability;
	}
	public List<Booking> viewPastBooking(int userId)
	{
		 Connection con = null;
	        PreparedStatement stmt = null;
	        ResultSet rs = null;
	        List<Booking> bookings = new ArrayList<>();

	        try {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con = DriverManager.getConnection(
	                    "jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");

	            // First, get the customerId from the userId
	            String customerQuery = "SELECT customerId FROM Customer WHERE userId = ?";
	            stmt = con.prepareStatement(customerQuery);
	            stmt.setInt(1, userId);
	            rs = stmt.executeQuery();

	            int customerId = -1;
	            if (rs.next()) {
	                customerId = rs.getInt("customerId");
	            } else {
	                System.out.println("No customer found with userId: " + userId);
	                return bookings; // return empty list if no customer found
	            }

	            rs.close();
	            stmt.close();

	            // Now, get all bookings for the customerId
	            String bookingQuery = "SELECT * FROM booking WHERE customerId = ?";
	            stmt = con.prepareStatement(bookingQuery);
	            stmt.setInt(1, customerId);
	            rs = stmt.executeQuery();
	            
	            while (rs.next()) {
	                int bookingId = rs.getInt("bookingId");
	                int transactionId = rs.getInt("transactionId");
	                String bookingDate = rs.getString("bookingDate");
	       
	                String bookingAmount = rs.getString("bookingAmount");
	                int centerId=rs.getInt("centerId");
	                int slotId=rs.getInt("slotId");	     
	                Booking booking = new Booking(bookingId,customerId, centerId,  slotId,  transactionId,  bookingAmount, bookingDate);
	                bookings.add(booking);
	            }
	        } catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            try {
	                if (rs != null) rs.close();
	                if (stmt != null) stmt.close();
	                if (con != null) con.close();
	            } catch (Exception e) {
	                System.out.println("Error closing resources: " + e.getMessage());
	            }
	        }

	        return bookings;
	}

	public int makePayment(int userId,String paymentDetails) throws BookingFailedException
	{
		Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int transactionId = 1;
        int custId=1;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
            
            String sql="Select customerId as custId from Customer where userId=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
              custId=rs.getInt("custId");
            }
            
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date = currentDate.format(formatter);
            
            sql = "SELECT MAX(transactionId) AS maxTransactionId FROM Payment";
            stmt = con.prepareStatement(sql);

			// Execute query
			rs = stmt.executeQuery();
			if (rs.next())
				transactionId = rs.getInt("maxTransactionId") + 1;
			
            String query = "INSERT INTO Payment VALUES (?,?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, transactionId);
            stmt.setString(2, paymentDetails);
            stmt.setString(3, date);
            stmt.setInt(4, custId);

            int result = stmt.executeUpdate();
//            if (result > 0) {
//           
//                rs = stmt.getGeneratedKeys();
//                if (rs.next()) {
//                    transactionId = rs.getInt(1);
//                    System.out.println("Generated transactionId: " + transactionId);
//                }
//                System.out.println("Payment successfully recorded.");
//            } else {
//                throw new BookingFailedException("Failed to record payment.");
//            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
        return transactionId;
	}

	
	public void createBooking(int userId,int slotId,int centerId,int transactionId,String bookingDate) throws BookingFailedException{
		Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String price=null;
        int maxCap=0,currCap=0,bookingId=1,custId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
            String sql="Select customerId as custId from Customer where userId=?";
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,userId);
            rs=stmt.executeQuery();
            if(rs.next())
            {
            	custId=rs.getInt("custId");
            }
            sql="Select * from Slot where slotId=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, slotId);
            rs = stmt.executeQuery();
            if (rs.next()) {
              maxCap=rs.getInt("slotMaxCap");
              currCap=rs.getInt("slotCurrCap");
              price=rs.getString("slotPrice");
            }
            
            int available=maxCap-currCap;
            if(available==0)
            {
            	System.out.println("Slot is not available!");
            	return;
            }
            // Update slot table
            sql="UPDATE Slot SET slotCurrCap=? where slotId=?";
            stmt = con.prepareStatement(sql);
			stmt.setInt(1, currCap+1);
			stmt.setInt(2, slotId);
			int rowsInserted =stmt.executeUpdate();
//			System.out.println(rowsInserted + " record inserted");
			
			// Change slot Status
			if(currCap==maxCap)
			{
				sql="UPDATE Slot SET slotStatus=? where slotId=?";
		        stmt = con.prepareStatement(sql);
				stmt.setInt(1,1);
				stmt.setInt(2, slotId);
				rowsInserted =stmt.executeUpdate();
				System.out.println(rowsInserted + " record inserted");
				
			}
            
            
            sql = "SELECT MAX(bookingId) AS maxBookingId FROM Booking";
            stmt = con.prepareStatement(sql);

			// Execute query
			rs = stmt.executeQuery();
			if (rs.next())
				bookingId = rs.getInt("maxBookingId") + 1;
			
            String query = "INSERT INTO Booking VALUES (?,?,?,?,?,?,?)";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, bookingId);
            stmt.setInt(2, custId);
            stmt.setInt(3, slotId);
            stmt.setInt(4, centerId);
            stmt.setString(5,price);
            stmt.setInt(6,transactionId);
            stmt.setString(7,bookingDate);

            int result = stmt.executeUpdate();
            if(result>0)
            	System.out.println("Booking complete!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
	}
	
	public void deleteBooking(int userId,int bookingId)
	{
		Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int currCap=0,slotId=0,custId=0;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
            String sql="Select customerId as custId from Customer where userId=?";
            stmt=con.prepareStatement(sql);
            stmt.setInt(1,userId);
            rs=stmt.executeQuery();
            if(rs.next())
            {
            	custId=rs.getInt("custId");
            }
            
            
            sql="Select * from Booking where customerId=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, custId);
            
            rs = stmt.executeQuery();
            if (rs.next()) {
              slotId=rs.getInt("slotId");
            }
            
            sql="Select * from Slot where slotId=?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, slotId);
            
            rs = stmt.executeQuery();
            if (rs.next()) {
              currCap=rs.getInt("slotCurrCap");
            }
            currCap-=1;
           
            // Update slot table
            sql="UPDATE Slot SET slotCurrCap=?, slotStatus=? where slotId=?";
            stmt = con.prepareStatement(sql);
			stmt.setInt(1, currCap);
			stmt.setInt(2, 1);
			stmt.setInt(3, slotId);
			int rowsInserted =stmt.executeUpdate();
//			System.out.println(rowsInserted + " record inserted");
            
			
            String query = "DELETE FROM Booking WHERE bookingId=?";
            stmt = con.prepareStatement(query);
            stmt.setInt(1, bookingId);
            int result = stmt.executeUpdate();
            if(result>0)
            	System.out.println("Booking deleted!");

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            try {
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println("Error closing resources: " + e.getMessage());
            }
        }
		
	}
	
	
}