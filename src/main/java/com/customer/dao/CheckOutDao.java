package com.customer.dao;

import java.util.List;

import com.customer.entity.CheckOuts;

public interface CheckOutDao {
	CheckOuts createCheckOut(CheckOuts checkOut);
	 CheckOuts getCheckOutById(String checkOutID);
	 List<CheckOuts> getAllcheckOuts();
	 void updateCheckOut(CheckOuts checkOut);
	 void deleteCheckOut(CheckOuts checkOut);
}
