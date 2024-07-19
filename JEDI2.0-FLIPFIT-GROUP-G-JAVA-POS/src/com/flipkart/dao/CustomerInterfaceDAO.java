package com.flipkart.dao;

import java.util.List;

import com.flipkart.bean.Center;


/**
 * Interface for FlipFitCustomerDAO operations related to customer interactions with gyms and slots.
 */
public interface CustomerInterfaceDAO {

    /**
     * Creates a new customer record in the database.
     *
     * @param userId      The user ID of the customer.
     * @param name        The name of the customer.
     * @param phoneNumber The phone number of the customer.
     * @param address     The address of the customer.
     */
    public void createCustomer(int userId, String name, String phoneNumber, String address);

    /**
     * Edits the profile of an existing customer in the database.
     *
     * @param userId      The user ID of the customer.
     * @param name        The updated name of the customer.
     * @param phoneNumber The updated phone number of the customer.
     * @param address     The updated address of the customer.
     * @throws UserNotFoundException If the customer with the given user ID is not found.
     */
    public void editProfile(int userId, String name, String phoneNumber, String address) throws UserNotFoundException;

    /**
     * Retrieves a list of all gyms available in the system.
     *
     * @return List of FlipFitGym objects representing gyms.
     */
    public List<Center> viewCenters();
    public List<PastBookings> viewPastBookings();
    public HashMap<String, Integer> viewSlots(int gymId, String date) throws GymNotFoundException;

    /**
     * Filters slots based on specific criteria (to be implemented).
     */
    public void filterSlots();
}
