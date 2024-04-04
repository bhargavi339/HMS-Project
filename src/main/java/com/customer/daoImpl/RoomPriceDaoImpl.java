package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.RoomPriceDao;
import com.customer.entity.RoomPrice;
import com.customer.util.HibernateUtil;

public class RoomPriceDaoImpl implements RoomPriceDao{
	public RoomPrice createRoomPrice(RoomPrice roomPrice) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(roomPrice);
		session.getTransaction().commit();
		return roomPrice;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<RoomPrice>getAllRoomPrice(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM RoomPrice", RoomPrice.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void updateRoomPrice(RoomPrice roomPrice) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(roomPrice); // Update existing room price
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteRoomPrice(RoomPrice roomPrice) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(roomPrice); // Delete the room price
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public RoomPrice getRoomPriceById(String generatedPriceId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            RoomPrice roomPrice = session.get(RoomPrice.class, generatedPriceId); // Get room price by ID
            session.getTransaction().commit();
            return roomPrice;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
