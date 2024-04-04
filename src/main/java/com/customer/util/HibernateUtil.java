package com.customer.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.customer.entity.Bookings;
import com.customer.entity.CheckIns;
import com.customer.entity.CheckOuts;
import com.customer.entity.Customers;
import com.customer.entity.Employees;
import com.customer.entity.Feedback;
import com.customer.entity.Hotels;
import com.customer.entity.Inventory;
import com.customer.entity.Payments;
import com.customer.entity.RoomPrice;
import com.customer.entity.Rooms;
import com.customer.entity.Services;
import com.customer.entity.ServicesTaken;

public class HibernateUtil {
private final static SessionFactory sessionFactory=buildSessionFactory();
private static SessionFactory buildSessionFactory() {
	try {
		return new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Customers.class)
				.addAnnotatedClass(Hotels.class)
				.addAnnotatedClass(Employees.class)
				.addAnnotatedClass(Rooms.class)
				.addAnnotatedClass(RoomPrice.class)
				.addAnnotatedClass(Payments.class)
				.addAnnotatedClass(Services.class)
				.addAnnotatedClass(Bookings.class)
				.addAnnotatedClass(ServicesTaken.class)
				.addAnnotatedClass(Feedback.class)
				.addAnnotatedClass(CheckIns.class)
				.addAnnotatedClass(CheckOuts.class)
				.addAnnotatedClass(Inventory.class)
				.buildSessionFactory();
	}
	catch(Throwable e) {
		throw new ExceptionInInitializerError(e);
	}
}
public static SessionFactory getSessionFactory() {
	return sessionFactory;
}
public static Session getSession() {
	return getSessionFactory().openSession();
}
}
