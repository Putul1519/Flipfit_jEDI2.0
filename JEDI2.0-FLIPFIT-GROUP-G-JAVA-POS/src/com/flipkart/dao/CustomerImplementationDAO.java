package com.flipkart.dao;
import com.flipkart.bean.Center;
import com.flipkart.bean.Slot;

import java.sql.*;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the FlipFitCustomerDAOInterface that handles customer operations related to gyms and slots.
 */
public class CustomerImplementationDAO implements  CustomerInterfaceDAO {

    public static void main(String[] args) {
        CustomerInterfaceDAO dao = new CustomerImplementationDAO();
        //dao.createCustomer(1, 1, "John Doe", "1111111111", "abc", "john.doe@example.com", "somya");
//        dao.editProfile(1, "Sarthak Doe", "1111111111", "abc");
//        dao.viewGyms();
//        dao.viewSlots(1, "12-12-12");
        try {
            dao.editProfile(11, null, null, null);
        } catch (UserNotFoundException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

   
    /**
     * Retrieves details of all gviewCentersyms from the database.
     *
     * @return List of FlipFitGym objects representing all gyms.
     */
    @Override
    public List<Center> viewCenters(){
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Center> gymList = new ArrayList<Center>();
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String query = "SELECT * FROM Centers";
            stmt = con.prepareStatement(query);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int gymId = rs.getInt("CenterID");
                String gymName = rs.getString("CenterName");
                String gymLocation = rs.getString("CenterLoc");
                gymList.add(new Center(gymId, gymName, gymLocation));
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

    /**
     * Retrieves slot availability for a specific gym on a given date from the database.
     *
     * @param gymId The ID of the gym for which slot availability is to be retrieved.
     * @param date  The date for which slot availability is to be retrieved.
     * @return HashMap where keys are slot times and values are available seats.
     * @throws GymNotFoundException If no gym with the given gymId is found.
     */
    @Override
    public HashMap<String, Integer> viewSlots(int gymId, String date) throws GymNotFoundException {
        Connection con = null;
        PreparedStatement stmtSlots = null;
        PreparedStatement stmtBookings = null;
        ResultSet rsSlots = null;
        ResultSet rsBookings = null;
        HashMap<String, Integer> slotAvailability = new HashMap<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/FlipFit", "root", "mysqliswow");

            String querySlots = "SELECT * FROM slot WHERE gymId = ?";
            stmtSlots = con.prepareStatement(querySlots);
            stmtSlots.setInt(1, gymId);
            rsSlots = stmtSlots.executeQuery();

            if (!rsSlots.isBeforeFirst()) {
                throw new GymNotFoundException(gymId);
            }

            while (rsSlots.next()) {
                int slotId = rsSlots.getInt("slotId");
                String slotTime = rsSlots.getString("slotTime");
                int slotCapacity = rsSlots.getInt("slotCapacity");

                String queryBookings = "SELECT COUNT(*) as bookedCount FROM Booking WHERE gymId = ? AND bookingDate = ? AND bookingTimeSlot = ?";
                stmtBookings = con.prepareStatement(queryBookings);
                stmtBookings.setInt(1, gymId);
                stmtBookings.setString(2, date);
                stmtBookings.setString(3, slotTime);
                rsBookings = stmtBookings.executeQuery();

                int bookedCount = 0;
                if (rsBookings.next()) {
                    bookedCount = rsBookings.getInt("bookedCount");
                }
                int availableSeats = slotCapacity - bookedCount;
                slotAvailability.put(slotTime,availableSeats);
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

    /**
     * Placeholder method for filtering slots based on certain criteria (not implemented yet).
     */
    @Override
    public void filterSlots() {

    }

	@Override
	public com.flipkart.dao.List<PastBookings> viewPastBookings() {
		// TODO Auto-generated method stub
		return null;
	}
}