package com.flipkart.dao;
import static com.flipkart.constant.SQLConstant.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.flipkart.bean.Center;
import com.flipkart.bean.CenterOwner;
/**
 * DAO for Admin
 */

public class AdminDaoImpl implements AdminDaoInterface {

	/**
	 * Views all Center Owner Requests.
	 *
	 * @return A list of all Center Owner Requests.
	 */
	public List<CenterOwner> viewRequest() {
		List<CenterOwner> requests = new ArrayList<>();
		try {

			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			stmt = con.prepareStatement(VIEW_REQUEST);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("userId");
				int ownerId = rs.getInt("ownerId");
				String ownerAadharNo = rs.getString("aadharNo");
				String ownerGstN = rs.getString("ownerGstNo");
				String ownerContactNo = rs.getString("contactNo");
				int approvalReq = rs.getInt("approvalStatus");
				CenterOwner centerOwner = new CenterOwner(userId, ownerId, approvalReq, ownerContactNo, ownerAadharNo,
						ownerGstN);
				requests.add(centerOwner);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return requests;

	}
	/**
	 * Views all Center Owners.
	 *
	 * @return A list of all Center Owners.
	 */
	public List<CenterOwner> viewAllCenterOwners() {

		List<CenterOwner> owners = new ArrayList<>();
		try {

			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			stmt = con.prepareStatement(VIEW_CENTER_OWNER);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int userId = rs.getInt("userId");
				int ownerId = rs.getInt("ownerId");
				String ownerAadharNo = rs.getString("aadharNo");
				String ownerGstN = rs.getString("ownerGSTNo");
				String ownerContactNo = rs.getString("contactNo");
				int approvalReq = rs.getInt("approvalStatus");

				CenterOwner centerOwner = new CenterOwner(userId, ownerId, approvalReq, ownerContactNo, ownerAadharNo,
						ownerGstN);
				owners.add(centerOwner);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return owners;

	}
	/**
	 * Approves a Center Owner's request.
	 *
	 * @param ownerId The ID of the Center Owner whose request is to be approved.
	 * @return 1 if the request is approved, 0 otherwise.
	 */
	public int validateOwnerRequest(int ownerId) {
		int status = 0;
		try {

			Connection con = null;
			PreparedStatement stmt = null;

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			stmt = con.prepareStatement(VALIDATE_OWNER_REQUEST);
			stmt.setInt(1, ownerId);
			int rs = stmt.executeUpdate();

			if (rs > 0) {
				status = 1;
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return status;

	}
	/**
	 * Views all Centers.
	 *
	 * @return A list of all Centers.
	 */
	public List<Center> viewCenters() {
		List<Center> centers = new ArrayList<>();
		try {

			Connection con = null;
			PreparedStatement stmt = null;
			ResultSet rs = null;

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");

			stmt = con.prepareStatement(VIEW_CENTERS);
			rs = stmt.executeQuery();

			while (rs.next()) {
				int centerId = rs.getInt("centerId");
				String centerName = rs.getString("centerName");
				int centerOwnerId = rs.getInt("centerOwnerId");
				String centerLoc = rs.getString("centerLoc");

				Center center = new Center(centerId, centerOwnerId, centerName, centerLoc);
				centers.add(center);
			}
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

		return centers;
	}
	/**
	 * Removes a Center Owner.
	 *
	 * @param ownerId The ID of the Center Owner to be removed.
	 */
	public void removeGymOwner(int ownerId) {

		try {

			Connection con = null;
			PreparedStatement stmtDeleteCenterOwner = null;
			PreparedStatement stmtDeleteCenters = null;
			PreparedStatement stmtDeleteUser = null;

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/FlipFit", "root", "putul1519");
			stmtDeleteCenters = con.prepareStatement(DELETE_CENTER_OWNER_BOOKING);
			stmtDeleteCenters.setInt(1, ownerId);
			stmtDeleteCenters.executeUpdate();

			stmtDeleteCenters = con.prepareStatement(DELETE_CENTER_OWNER_SLOT);
			stmtDeleteCenters.setInt(1, ownerId);
			stmtDeleteCenters.executeUpdate();
			
			stmtDeleteCenters = con.prepareStatement(DELETE_CENTER_OWNER_CENTER);
			stmtDeleteCenters.setInt(1, ownerId);
			stmtDeleteCenters.executeUpdate();

			PreparedStatement stmtSelectUserId = con.prepareStatement(SELECT_USERID_OWNER);
			stmtSelectUserId.setInt(1, ownerId);
			ResultSet rs = stmtSelectUserId.executeQuery();

			int userId = 0;
			if (rs.next()) {
				userId = rs.getInt("userId");
			}
			rs.close();
			stmtSelectUserId.close();

			stmtDeleteCenterOwner = con.prepareStatement(DELETE_CENTER_OWNER);
			stmtDeleteCenterOwner.setInt(1, ownerId);
			stmtDeleteCenterOwner.executeUpdate();

			stmtDeleteUser = con.prepareStatement(DELETE_USER);
			stmtDeleteUser.setInt(1, userId);
			stmtDeleteUser.executeUpdate();

		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}

	}

}
