package com.customer.dao;

import java.util.List;

import com.customer.entity.CheckIns;

public interface CheckInDao {
	CheckIns createCheckIn(CheckIns checkIn);
	 CheckIns getCheckInById(String checkInID);
	 List<CheckIns> getAllcheckIns();
	 void updateCheckIn(CheckIns checkIn);
	 void deleteCheckIn(CheckIns checkIn);
}
