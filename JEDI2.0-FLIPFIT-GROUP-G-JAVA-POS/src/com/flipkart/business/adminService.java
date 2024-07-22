/**
 * 
 */
package com.flipkart.business;

import com.flipkart.dao.*;
import java.util.List;

import com.flipkart.bean.Center;
import com.flipkart.bean.CenterOwner;
import com.flipkart.bean.Customer;

/**
 * 
 */
public class adminService implements adminServiceInterface {
	AdminDaoInterface adminDao = new AdminDaoImpl();
	public List<Center> viewCenters() {
		List<Center> centers = adminDao.viewCenters();
		return centers;

	}

	

	public List<CenterOwner> viewRequest() {
		List<CenterOwner> requests = adminDao.viewRequest();
		return requests;

	}

	public List<CenterOwner> viewAllCenterOwners() {
		
		List<CenterOwner> centerOwners = adminDao.viewAllCenterOwners();
		return centerOwners;
	}

	public int validateOwnerRequest(int ownerId) {
		int isValidated = adminDao.validateOwnerRequest(ownerId);
		
		return isValidated;

	}

	public void removeGymOwner(int ownerId) {

		adminDao.removeGymOwner(ownerId);
		

	}

}
