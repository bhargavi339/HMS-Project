package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.CheckInDao;
import com.customer.entity.CheckIns;
import com.customer.util.HibernateUtil;

public class CheckInDaoImpl implements CheckInDao{
	public CheckIns createCheckIn(CheckIns checkIn) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(checkIn);
		session.getTransaction().commit();
		return checkIn;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	@Override
	public List<CheckIns> getAllcheckIns() {
		// TODO Auto-generated method stub
		try(Session session=HibernateUtil.getSession()) {
			return session.createQuery("FROM CheckIns", CheckIns.class).list();
			}
			catch(HibernateException e) {
				System.out.println(e);
			}
			catch(Exception e) {
				System.out.println(e);
			}
		return null;
	}
	
	public void updateCheckIn(CheckIns checkIn) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(checkIn); // Update existing check-in
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCheckIn(CheckIns checkIn) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(checkIn); // Delete the check-in
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public CheckIns getCheckInById(String checkInId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            CheckIns checkIn = session.get(CheckIns.class, checkInId); // Get check-in by ID
            session.getTransaction().commit();
            return checkIn;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	
}
