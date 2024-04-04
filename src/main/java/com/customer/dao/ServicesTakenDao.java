package com.customer.dao;

import java.util.List;

import com.customer.entity.ServicesTaken;

public interface ServicesTakenDao {
	ServicesTaken createServicesTaken(ServicesTaken servicesTaken);
	 ServicesTaken getServicesTakenById(String servicesTakenID);
	 List<ServicesTaken> getAllServicesTaken();
	 void updateServicesTaken(ServicesTaken servicesTaken);
	 void deleteServicesTaken(ServicesTaken servicesTaken);
}
