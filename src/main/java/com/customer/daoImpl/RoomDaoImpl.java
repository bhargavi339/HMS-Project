package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.RoomDao;
import com.customer.entity.Rooms;
import com.customer.util.HibernateUtil;

public class RoomDaoImpl implements RoomDao {
	public Rooms createRoom(Rooms room) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(room);
		session.getTransaction().commit();
		return room;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Rooms>getAllRooms(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM Rooms", Rooms.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	 public void updateRoom(Rooms room) {
	        try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            session.update(room); // Update existing room
	            session.getTransaction().commit();
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	    public void deleteRoom(Rooms room) {
	        try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            session.delete(room); // Delete the room
	            session.getTransaction().commit();
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	    public Rooms getRoomById(String roomNumber) {
	        try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            Rooms room = session.get(Rooms.class, roomNumber); // Get room by room number
	            session.getTransaction().commit();
	            return room;
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	    }
}
