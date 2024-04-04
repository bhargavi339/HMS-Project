package com.customer.dao;

import java.util.List;
import com.customer.entity.Customers;
import com.customer.entity.Hotels;

public interface CustomerDao {
 Customers createCustomer(Customers customer);
 List<Customers>getAllCustomers();
 Customers getCustomerById(String customerID);
 void updateCustomer(Customers customer);
 void deleteCustomer(Customers Customer);
 void bookHotel(Hotels hotelID);
}