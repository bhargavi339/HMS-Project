package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.ServicesTakenDao;
import com.customer.entity.ServicesTaken;
import com.customer.util.HibernateUtil;

public class ServicesTakenDaoImpl implements ServicesTakenDao {
	public ServicesTaken createServicesTaken(ServicesTaken servicesTaken) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(servicesTaken);
		session.getTransaction().commit();
		return servicesTaken;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<ServicesTaken>getAllServicesTaken(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM ServicesTaken", ServicesTaken.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void updateServicesTaken(ServicesTaken servicesTaken) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(servicesTaken); // Update existing services taken
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteServicesTaken(ServicesTaken servicesTaken) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(servicesTaken); // Delete the services taken
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public ServicesTaken getServicesTakenById(String servicesTakenId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            ServicesTaken servicesTaken = session.get(ServicesTaken.class, servicesTakenId); // Get services taken by ID
            session.getTransaction().commit();
            return servicesTaken;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
