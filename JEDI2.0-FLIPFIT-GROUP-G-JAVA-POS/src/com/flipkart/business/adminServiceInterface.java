package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.*;

public interface adminServiceInterface {
	public List<Center> viewCenters();
	
	public List<CenterOwner> viewRequest();
	
	public List<CenterOwner> viewAllCenterOwners();

	public int validateOwnerRequest(int ownerId);

	

	public void removeGymOwner(int ownerId);


}
