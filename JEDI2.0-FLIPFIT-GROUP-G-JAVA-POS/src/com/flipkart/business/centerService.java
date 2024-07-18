/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.Center;

/**
 * 
 */
public class centerService implements centerServiceInterface {
	public boolean setCenterDetails(Center c) {
		// fetch last center id and create a new by adding +1 and insert it into DB(No duplicate)
		return true;
	}

}
