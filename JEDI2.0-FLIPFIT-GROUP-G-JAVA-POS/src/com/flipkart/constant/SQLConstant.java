package com.flipkart.constant;

public class SQLConstant {
	public static final String VIEW_REQUEST = "SELECT * FROM centerOwner WHERE approvalStatus=0";
	public static final String VIEW_CENTER_OWNER = "SELECT * FROM centerOwner WHERE approvalStatus=1";
	public static final String VALIDATE_OWNER_REQUEST = "UPDATE centerOwner SET approvalStatus=1 WHERE ownerId=?";

	public static final String VIEW_CENTERS = "SELECT * FROM center";

	public static final String DELETE_CENTER_OWNER_BOOKING = "Delete from Booking where centerId in (Select centerId from Center where centerOwnerId=?)";
	public static final String DELETE_CENTER_OWNER_SLOT = "Delete from Slot where centerId in (Select centerId from Center where centerOwnerId=?)";

	public static final String DELETE_CENTER_OWNER_CENTER = "DELETE FROM center WHERE centerOwnerId =?";

	public static final String SELECT_USERID_OWNER = "SELECT userId FROM centerOwner WHERE ownerId =?";

	public static final String DELETE_CENTER_OWNER = "DELETE FROM CenterOwner WHERE ownerId = ?";

	public static final String DELETE_USER = "DELETE FROM user WHERE userId = ?";

	public static final String SELECT_MAX_OWNERID = "SELECT MAX(ownerId) AS maxOwnerId FROM centerOwner";

	public static final String INSERT_INTO_CENTER_OWNER = "INSERT INTO CenterOwner VALUES (?,?,?,?,?,?)";
	public static final String SELECT_MAX_CENTERID = "SELECT MAX(centerId) AS maxCenterId FROM Center";

	public static final String SELECT_OWNERID_USER = "Select ownerId as owner from centerOwner where userId=?";

	public static final String INSERT_INTO_CENTER = "INSERT INTO Center VALUES (?,?,?,?)";

	public static final String UPDATE_CENTER = "UPDATE Center SET centerName=?, centerLoc=? WHERE centerId=?";

	public static final String SELECT_OWNERID_USER_2 = "Select ownerId as centerId from centerOwner where userId=?";

	public static final String SELECT_FROM_CENTER = "SELECT * FROM Center WHERE centerOwnerId = ?";

	public static final String INSERT_SLOT = "INSERT INTO Slot VALUES (?,?,?,?,?,?,?,?,?)";

	public static final String SELECT_SLOT = "SELECT * FROM Slot WHERE centerId = ?";

	public static final String SELECT_OWNERID_OWNER = "Select ownerId as ownerId from centerOwner where userId=?";

	public static final String UPDATE_USER = "UPDATE User SET userName=?, userEmail=? WHERE userId=(SELECT userId from centerOwner where ownerId=?)";
	public static final String UPDATE_CENTER_OWNER = "UPDATE centerOwner SET ownerGSTNo=?, aadharNo=?, contactNo=? WHERE ownerId=?";

	public static final String SELECT_BOOKING_CENTERID = "SELECT * FROM Booking where centerId=?";

	public static final String SELECT_USER = "SELECT userPass, userId FROM User WHERE userEmail=? and roleId=?";

	public static final String SELECT_USERID_USER = "SELECT MAX(userId) AS maxUserId FROM User";

	public static final String INSERT_USER = "INSERT INTO User VALUES (?,?,?,?,?)";
	public static final String SELECT_MAX_CUSTOMERID = "SELECT MAX(customerId) AS maxcustomerId FROM Customer";

	public static final String INSERT_CUSTOMER = "INSERT INTO Customer VALUES (?,?,?)";

	public static final String SELECT_CENTER = "SELECT * FROM Center";
	public static final String SELECT_CUSTOMERID = "SELECT customerId FROM Customer WHERE userId = ?";
	public static final String SELECT_BOOKING_CUSTOMERID = "SELECT * FROM booking WHERE customerId = ?";
	public static final String SELECT_CUSTOMER_ID = "Select customerId as custId from Customer where userId=?";
	public static final String SELECT_TRANSACTION_ID = "SELECT MAX(transactionId) AS maxTransactionId FROM Payment";
	
	public static final String INSERT_PAYMENT = "INSERT INTO Payment VALUES (?,?,?,?)";
	public static final String SELECT_SLOTID="Select * from Slot where slotId=?";
	
	public static final String UPDATE_SLOT="UPDATE Slot SET slotCurrCap=? where slotId=?";
	public static final String UPDATE_SLOT_2="UPDATE Slot SET slotStatus=? where slotId=?";
	
	public static final String SELECT_BOOKING_ID="SELECT MAX(bookingId) AS maxBookingId FROM Booking";
	public static final String INSERT_BOOKING = "INSERT INTO Booking VALUES (?,?,?,?,?,?,?)";
	public static final String SELECT_CUSTOMERID_2="Select customerId as custId from Customer where userId=?";
	public static final String UPDATE_SLOT_3="UPDATE Slot SET slotCurrCap=?, slotStatus=? where slotId=?";
	public static final String DELETE_BOOKING = "DELETE FROM Booking WHERE bookingId=?";
	
}
