/**
 * 
 */
package com.flipkart.bean;

/**
 * 
 */
public class User {
    private String userId;
    private String email;
    private String userName;
    private String password;
    private int roleId;

    public User(String userId, String email,String userName, String password, int roleId) {
       this.userId = userId;
       this.email = email;
       this.userName=userName;
       this.password = password;
       this.roleId = roleId;
    }

    public String getUserId() {
       return userId;
    }

    public void setUserId(String userId) {
       this.userId = userId;
    }
    public String getEmail() {
       return email;
    }
    public void setEmail(String email) {
       this.email = email;
    }
    public String getUserName() {
       return userName;
    }
    public String getPassword() {
       return password;
    }
    public void setPassword(String password) {
       this.password = password;
    }
    public int getRoleId() {
       return roleId;
    }
    public void setRoleId(int roleId) {
       this.roleId = roleId;
    }

}