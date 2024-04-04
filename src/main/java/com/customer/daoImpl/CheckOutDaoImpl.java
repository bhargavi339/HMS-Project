package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.CheckOutDao;
import com.customer.entity.CheckOuts;
import com.customer.util.HibernateUtil;

public class CheckOutDaoImpl implements CheckOutDao{
	public CheckOuts createCheckOut(CheckOuts checkOut) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(checkOut);
		session.getTransaction().commit();
		return checkOut;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<CheckOuts> getAllcheckOuts() {
        try (Session session = HibernateUtil.getSession()) {
            return session.createQuery("FROM CheckOuts", CheckOuts.class).list();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
	public void updateCheckOut(CheckOuts checkOut) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(checkOut); // Update existing check-out
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteCheckOut(CheckOuts checkOut) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(checkOut); // Delete the check-out
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public CheckOuts getCheckOutById(String checkOutId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            CheckOuts checkOut = session.get(CheckOuts.class, checkOutId); // Get check-out by ID
            session.getTransaction().commit();
            return checkOut;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
