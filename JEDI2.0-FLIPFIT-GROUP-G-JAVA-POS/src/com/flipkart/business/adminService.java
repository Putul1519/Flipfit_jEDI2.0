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
 * Service class implementing adminServiceInterface to provide administrative operations.
 */
public class adminService implements adminServiceInterface {
	AdminDaoInterface adminDao = new AdminDaoImpl();

	/**
	 * Views all Centers.
	 *
	 * @return A list of all Centers.
	 */
	public List<Center> viewCenters() {
		List<Center> centers = adminDao.viewCenters();
		return centers;
	}

	/**
	 * Views all Center Owner Requests.
	 *
	 * @return A list of all Center Owner Requests.
	 */
	public List<CenterOwner> viewRequest() {
		List<CenterOwner> requests = adminDao.viewRequest();
		return requests;
	}

	/**
	 * Views all Center Owners.
	 *
	 * @return A list of all Center Owners.
	 */
	public List<CenterOwner> viewAllCenterOwners() {
		
		List<CenterOwner> centerOwners = adminDao.viewAllCenterOwners();
		return centerOwners;
	}

	/**
	 * Approves a Center Owner's request.
	 *
	 * @param ownerId The ID of the Center Owner whose request is to be approved.
	 * @return 1 if the request is approved, 0 otherwise.
	 */
	public int validateOwnerRequest(int ownerId) {
		int isValidated = adminDao.validateOwnerRequest(ownerId);
		return isValidated;
	}

	/**
	 * Removes a Center Owner.
	 *
	 * @param ownerId The ID of the Center Owner to be removed.
	 * @return 1 if the owner is removed, 0 otherwise.
	 */
	public void removeGymOwner(int ownerId) {
		adminDao.removeGymOwner(ownerId);
	}

}
