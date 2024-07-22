package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Center;
import com.flipkart.bean.CenterOwner;

public interface AdminDaoInterface {
	
	public List<CenterOwner> viewRequest();
	public List<CenterOwner> viewAllCenterOwners();

	public int validateOwnerRequest(int ownerId);

	public List<Center> viewCenters();
	public void removeGymOwner(int ownerId);

}
