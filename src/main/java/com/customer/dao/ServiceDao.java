package com.customer.dao;

import java.util.List;

import com.customer.entity.Services;

public interface ServiceDao {
	Services createService(Services  service);
	 Services getServicesById(int serviceToUpdate);
	 List<Services> getAllServices();
	 void updateService(Services service);
	 void deleteService(Services service);
}
