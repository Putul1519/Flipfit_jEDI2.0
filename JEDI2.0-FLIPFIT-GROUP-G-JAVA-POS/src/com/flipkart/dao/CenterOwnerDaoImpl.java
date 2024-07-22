package com.flipkart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.flipkart.bean.*;

public class CenterOwnerDaoImpl implements CenterOwnerDaoInterface{
	public void createOwner(int userId,String userPhoneNumber,String ownerGstNo,String aadharNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int ownerId=1;

		try {
			System.out.println("Inside addCenter");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);

			String sql = "SELECT MAX(ownerId) AS maxOwnerId FROM centerOwner";
			pstmt = con.prepareStatement(sql);

			// Execute query
			rs = pstmt.executeQuery();
			if (rs.next())
				ownerId = rs.getInt("maxOwnerId") + 1;
			
			sql = "INSERT INTO centerOwner VALUES (?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			// Set parameters for PreparedStatement
			pstmt.setInt(1, ownerId);
			pstmt.setString(2, ownerGstNo);
			pstmt.setInt(3, userId);
			pstmt.setInt(4, 0);
			pstmt.setString(5, aadharNo);
			pstmt.setString(6, userPhoneNumber);
			// Execute the insert statement
			int rowsInserted = pstmt.executeUpdate();
//			System.out.println(rowsInserted + " Owner record inserted");
		}
	        catch (Exception e) {
	            System.out.println("Error: " + e.getMessage());
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
	public void addCenter(String centerName, String centerLoc, int userId) {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int centerId = 0,ownerId=0;

		try {
			System.out.println("Inside addCenter");
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);

			String sql = "SELECT MAX(centerId) AS maxCenterId FROM Center";
			pstmt = con.prepareStatement(sql);

			// Execute query
			rs = pstmt.executeQuery();
			if (rs.next())
				centerId = rs.getInt("maxCenterId") + 1;
			System.out.println(userId);
			sql="Select ownerId as owner from centerOwner where userId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				ownerId=rs.getInt("owner");
				System.out.println(ownerId);
			}
			// SQL statement to insert data into center table
			sql = "INSERT INTO Center VALUES (?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			// Set parameters for PreparedStatement
			pstmt.setInt(1, centerId);
			pstmt.setString(2, centerName);
			pstmt.setString(3, centerLoc);
			pstmt.setInt(4, ownerId);
			// Execute the insert statement
			try {
				System.out.println(pstmt);
				int rowsInserted = pstmt.executeUpdate();
//				System.out.println(rowsInserted + " center record(s) inserted");
				
			}
			catch(Exception e){
				System.out.println(e);
			}
			// Commit transaction
			con.commit();
		} catch (ClassNotFoundException | SQLException e) {
			try {
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void updateCenterDetails(int gymId, String centerName, String centerLoc) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);
		    String sql = "UPDATE Center SET centerName=?, centerLoc=? WHERE centerId=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, centerName);
			pstmt.setString(2, centerLoc);
			pstmt.setInt(3, gymId);
			int rowsInserted = pstmt.executeUpdate();
//			System.out.println(rowsInserted + " center record(s) inserted");
			con.commit();
			
		} catch (ClassNotFoundException | SQLException e) {
			try {
				if (con != null) {
					con.rollback();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if(rs!=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	public List<Center> getCenterDetails(int userId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int centerId=0;
		List<Center> centerList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);
			
			String sql="Select ownerId as centerId from centerOwner where userId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			rs=pstmt.executeQuery();
			
			if(rs.next())
			{
				centerId=rs.getInt("centerId");
			}

			sql = "SELECT * FROM Center WHERE centerOwnerId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, centerId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int gymId = rs.getInt("centerId");
				int ownerId = rs.getInt("centerOwnerId");
				String centerName = rs.getString("centerName");
				String centerLoc = rs.getString("centerLoc");
				Center cen = new Center(gymId, ownerId, centerName, centerLoc);
				centerList.add(cen);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return centerList;
	}

	public void addSlot(int gymId, String startTime, String endTime, int slotCap,String price) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int slotId = 0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);

			String sql = "SELECT MAX(centerId) AS maxCenterId FROM Center";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			if (rs.next())
				slotId = rs.getInt("maxCenterId") + 1;
			SimpleDateFormat dateFormat=new SimpleDateFormat("dd-MM-yyyy");
			Date currDate=new Date();
			
			sql = "INSERT INTO Slot VALUES (?,?,?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			String slotDate=dateFormat.format(currDate);
			pstmt.setInt(1, slotId);
			pstmt.setInt(2, gymId);
			pstmt.setInt(3,0);
			pstmt.setInt(4, slotCap);
			pstmt.setInt(5, 0);
			pstmt.setString(6, startTime);
			pstmt.setString(7, endTime);
			pstmt.setString(8,slotDate);
			pstmt.setString(9, price);
			try {
				System.out.println(pstmt);
				int rowsInserted = pstmt.executeUpdate();
//				System.out.println(rowsInserted + " Slot record inserted");
			}
			catch(Exception e){
				System.out.println(e);
			}
			
			con.commit();
		} 
		catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
	}

	
    public List<Slot> viewSlots(int centerId)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<Slot> slotList = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);

			String sql = "SELECT * FROM Slot WHERE centerId = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, centerId);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int slotId = rs.getInt("slotId");
				int cId = rs.getInt("centerId");
				int slotStatus=rs.getInt("slotStatus");
				int slotMaxCap=rs.getInt("slotMaxCap");
				int slotCurrCap=rs.getInt("slotCurrCap");
				String slotStartTime=rs.getString("slotStartTime");
				String slotEndTime=rs.getString("slotEndTime");
				String slotDate=rs.getString("slotDate");
				String slotPrice=rs.getString("slotPrice");

				Slot slot = new Slot(slotId,slotStatus,slotStartTime,slotEndTime,slotMaxCap,slotPrice,slotCurrCap, cId,slotDate);
				slotList.add(slot);

			}
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if (rs != null)
					rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return slotList;

	}
	
	public void editYourDetails(int userId,String name,String email, String contactNo, String aadharNo, String gstnNo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		int ownerId=0;

		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			con.setAutoCommit(false);
			
			String sql="Select ownerId as ownerId from centerOwner where userId=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setInt(1,userId);
			rs=pstmt.executeQuery();
			if(rs.next())
			{
				ownerId=rs.getInt("ownerId");
			}

			sql = "UPDATE User SET userName=?, userEmail=? WHERE userId=(SELECT userId from centerOwner where ownerId=?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, email);
			pstmt.setInt(3, userId);
			int rowsInserted = pstmt.executeUpdate();
//			System.out.println(rowsInserted + " record inserted");
			
			
			
			sql="UPDATE centerOwner SET ownerGSTNo=?, aadharNo=?, contactNo=? WHERE ownerId=?";
			pstmt = con.prepareStatement(sql);
     		pstmt.setString(1, gstnNo);
			pstmt.setString(2, aadharNo);
			pstmt.setString(3, contactNo);
			pstmt.setInt(4, ownerId);
			int rowsInserted2 = pstmt.executeUpdate();
			con.commit();
//			System.out.println(rowsInserted2 + " record inserted");
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null) {
					con.close();
				}
				if(rs !=null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	public List<Booking> viewAllBooking(int gymId){
		Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Booking> bookings = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");


            String bookingQuery = "SELECT * FROM Booking where centerId=?";
            stmt = con.prepareStatement(bookingQuery);
            stmt.setInt(1, gymId);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int bookingId = rs.getInt("bookingId");
                int customerId = rs.getInt("customerId");
                int transactionId = rs.getInt("transactionId");
                String bookingDate = rs.getString("bookingDate");
                String bookingAmount = rs.getString("bookingAmount");
                int slotId = rs.getInt("slotId");

                Booking booking = new Booking(bookingId,customerId,gymId,slotId,transactionId,bookingAmount,bookingDate);

                bookings.add(booking);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (con != null) con.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        return bookings;
	}
}
	
