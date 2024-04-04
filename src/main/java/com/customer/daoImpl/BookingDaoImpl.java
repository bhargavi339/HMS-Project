package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.BookingDao;
import com.customer.entity.Bookings;
import com.customer.util.HibernateUtil;

public class BookingDaoImpl implements BookingDao{
		public Bookings createBooking(Bookings booking) {
			try(Session session=HibernateUtil.getSession()) {
			session.beginTransaction();
			session.save(booking);
			session.getTransaction().commit();
			return booking;
			}
			catch(HibernateException e) {
				System.out.println(e);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return null;
		}
		public List<Bookings>getAllBookings(){
			try(Session session=HibernateUtil.getSession()) {
			return session.createQuery("FROM Bookings", Bookings.class).list();
			}
			catch(HibernateException e) {
				System.out.println(e);
			}
			catch(Exception e) {
				System.out.println(e);
			}
			return null;
		}
		 public void updateBooking(Bookings booking) {
		        try (Session session = HibernateUtil.getSession()) {
		            session.beginTransaction();
		            session.update(booking); // Update existing booking
		            session.getTransaction().commit();
		        } catch (HibernateException e) {
		            System.out.println(e);
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }

		    public void deleteBooking(Bookings booking) {
		        try (Session session = HibernateUtil.getSession()) {
		            session.beginTransaction();
		            session.delete(booking); // Delete the booking
		            session.getTransaction().commit();
		        } catch (HibernateException e) {
		            System.out.println(e);
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		    }

		    public Bookings getBookingById(String bookingId) {
		        try (Session session = HibernateUtil.getSession()) {
		            session.beginTransaction();
		            Bookings booking = session.get(Bookings.class, bookingId); // Get booking by ID
		            session.getTransaction().commit();
		            return booking;
		        } catch (HibernateException e) {
		            System.out.println(e);
		        } catch (Exception e) {
		            System.out.println(e);
		        }
		        return null;
		    }
}
