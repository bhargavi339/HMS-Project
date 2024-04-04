package com.customer.dao;

import java.util.List;

import com.customer.entity.Payments;

public interface PaymentDao {
	Payments createPayment(Payments payment);
	 Payments getPaymentById(String paymentID);
	 List<Payments> getAllPayments();
	 void updatePayment(Payments payment);
	 void deletePayment(Payments payment);
}
