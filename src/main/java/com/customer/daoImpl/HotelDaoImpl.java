package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.HotelDao;
import com.customer.entity.Hotels;
import com.customer.util.HibernateUtil;

public class HotelDaoImpl implements HotelDao{
	public Hotels createHotel(Hotels hotel) {
	try(Session session=HibernateUtil.getSession()) {
	session.beginTransaction();
		session.save(hotel);
	session.getTransaction().commit();
	return hotel;
	}
		catch(HibernateException e) {
		System.out.println(e);
		}
	catch(Exception e) {
			System.out.println(e);
	}		return null;
	}
	public List<Hotels>getAllHotels(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM Hotels", Hotels.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void updateHotel(Hotels hotel) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(hotel); // Update existing hotel
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteHotel(Hotels hotel) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(hotel); // Delete the hotel
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Hotels getHotelById(String hotelId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Hotels hotel = session.get(Hotels.class, hotelId); // Get hotel by ID
            session.getTransaction().commit();
            return hotel;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
