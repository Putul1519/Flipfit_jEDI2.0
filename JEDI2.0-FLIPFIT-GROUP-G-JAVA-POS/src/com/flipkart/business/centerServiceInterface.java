package com.flipkart.business;
import java.util.List;

import com.flipkart.bean.*;

public interface centerServiceInterface {
	public List<Center> getCenterDeatils(String centerId);
	
	public boolean setCenterDetails(Center c);
	
	public List<Slot> viewSlots(String centerId);
}
