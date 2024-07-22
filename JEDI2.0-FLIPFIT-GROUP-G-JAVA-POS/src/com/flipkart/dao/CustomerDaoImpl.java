package com.flipkart.dao;
import com.flipkart.bean.*;
import com.flipkart.bean.Slot;
import com.flipkart.exception.BookingFailedException;
import com.flipkart.exception.GymNotFoundException;
import static com.flipkart.constant.SQLConstant.*;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import static com.flipkart.constant.SQLConstant.*;


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
			pstmt = con.prepareStatement(SELECT_MAX_CUSTOMERID);
			rs = pstmt.executeQuery();
			if (rs.next())
				customerId = rs.getInt("maxcustomerId") + 1;
			
			pstmt = con.prepareStatement(INSERT_CUSTOMER);
			
			pstmt.setInt(1, customerId);
			pstmt.setInt(2, userId);
			pstmt.setString(3, contactNo);
			
			int rowsInserted = pstmt.executeUpdate();
			con.commit();

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

	            stmt = con.prepareStatement(SELECT_CENTER);
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

	            stmtSlots = con.prepareStatement(SELECT_SLOT);
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

	            stmt = con.prepareStatement(SELECT_CUSTOMERID);
	            stmt.setInt(1, userId);
	            rs = stmt.executeQuery();

	            int customerId = -1;
	            if (rs.next()) {
	                customerId = rs.getInt("customerId");
	            } else {
	                System.out.println("No customer found with userId: " + userId);
	                return bookings;
	            }

	            rs.close();
	            stmt.close();

	            stmt = con.prepareStatement(SELECT_BOOKING_CUSTOMERID);
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
      
            stmt = con.prepareStatement(SELECT_CUSTOMER_ID);
            stmt.setInt(1, userId);
            rs = stmt.executeQuery();
            if (rs.next()) {
              custId=rs.getInt("custId");
            }
            
            LocalDate currentDate = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
            String date = currentDate.format(formatter);
            
            stmt = con.prepareStatement(SELECT_TRANSACTION_ID);

			rs = stmt.executeQuery();
			if (rs.next())
				transactionId = rs.getInt("maxTransactionId") + 1;
			
            stmt = con.prepareStatement(INSERT_PAYMENT);
            stmt.setInt(1, transactionId);
            stmt.setString(2, paymentDetails);
            stmt.setString(3, date);
            stmt.setInt(4, custId);

            int result = stmt.executeUpdate();


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
            
            stmt=con.prepareStatement(SELECT_CUSTOMER_ID);
            stmt.setInt(1,userId);
            rs=stmt.executeQuery();
            if(rs.next())
            {
            	custId=rs.getInt("custId");
            }

            stmt = con.prepareStatement(SELECT_SLOTID);
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
    
            stmt = con.prepareStatement(UPDATE_SLOT);
			stmt.setInt(1, currCap+1);
			stmt.setInt(2, slotId);
			int rowsInserted =stmt.executeUpdate();

			
		
			if(currCap==maxCap)
			{

		        stmt = con.prepareStatement(UPDATE_SLOT_2);
				stmt.setInt(1,1);
				stmt.setInt(2, slotId);
				rowsInserted =stmt.executeUpdate();
				System.out.println(rowsInserted + " record inserted");
				
			}
            
            stmt = con.prepareStatement(SELECT_BOOKING_ID);

			rs = stmt.executeQuery();
			if (rs.next())
				bookingId = rs.getInt("maxBookingId") + 1;
			
            stmt = con.prepareStatement(INSERT_BOOKING);
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

            stmt=con.prepareStatement(SELECT_CUSTOMERID_2);
            stmt.setInt(1,userId);
            rs=stmt.executeQuery();
            if(rs.next())
            {
            	custId=rs.getInt("custId");
            }
            
            
            stmt = con.prepareStatement(SELECT_BOOKING_CUSTOMERID);
            stmt.setInt(1, custId);
            
            rs = stmt.executeQuery();
            if (rs.next()) {
              slotId=rs.getInt("slotId");
            }
            
            stmt = con.prepareStatement(SELECT_SLOTID);
            stmt.setInt(1, slotId);
            
            rs = stmt.executeQuery();
            if (rs.next()) {
              currCap=rs.getInt("slotCurrCap");
            }
            currCap-=1;
           
            stmt = con.prepareStatement(UPDATE_SLOT_3);
			stmt.setInt(1, currCap);
			stmt.setInt(2, 1);
			stmt.setInt(3, slotId);
			int rowsInserted =stmt.executeUpdate();

            
            stmt = con.prepareStatement(DELETE_BOOKING);
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