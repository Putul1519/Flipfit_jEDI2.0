package com.flipkart.business;

import java.util.*;

import com.flipkart.bean.*;

public interface adminServiceInterface {

	public List<CenterOwner> viewRequest();

	public boolean validateOwnerRequest(String ownerId);

	public List<Center> viewCenterdetails(String centerId);

	public void removeGymOwner(String ownerId);

	public List<Customer> viewCustomerDetails(String custId);

}
