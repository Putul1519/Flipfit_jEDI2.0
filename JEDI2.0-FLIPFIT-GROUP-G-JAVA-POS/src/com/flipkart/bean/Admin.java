package com.flipkart.bean;

/**
 * Bean class for Admin.
 */
public class Admin {
    private int adminId;
    private int userId;


    public Admin(int adminId, int userId) {
       this.adminId = adminId;
       this.userId = userId;
    }
    /**
     * Getters and Setters
     */
    public int getAdminId() {
       return adminId;
    }
    public void setAdminId(int adminId) {
       this.adminId = adminId;
    }
    public int getUserId() {
       return userId;
    }
    public void setUserId(int userId) {
       this.userId = userId;
    }


}