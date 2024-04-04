package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.ServiceDao;
import com.customer.entity.Services;
import com.customer.util.HibernateUtil;

public class ServiceDaoImpl implements ServiceDao{
	public Services createService(Services service) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(service);
		session.getTransaction().commit();
		return service;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Services>getAllServices(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM Services", Services.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void updateService(Services service) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(service); // Update existing service
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteService(Services service) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(service); // Delete the service
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
	@Override
	public Services getServicesById(int serviceSerialNumber) {
		// TODO Auto-generated method stub
		 try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            Services service = session.get(Services.class, serviceSerialNumber); // Get service by ID
	            session.getTransaction().commit();
	            return service;
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
		return null;
	}
}
