package com.customer.daoImpl;

import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import com.customer.dao.CustomerDao;
import com.customer.entity.Customers;
import com.customer.entity.Hotels;
import com.customer.util.HibernateUtil;

public class CustomerDaoImpl implements CustomerDao {
	public Customers createCustomer(Customers customer) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();
		return customer;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Customers>getAllCustomers(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM Customers", Customers.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}

	 public void updateCustomer(Customers customer) {
	        try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            session.update(customer); // Update existing customer
	            session.getTransaction().commit();
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	 public void deleteCustomer(Customers customer) {
	        try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            session.delete(customer); // Delete the customer
	            session.getTransaction().commit();
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	  public Customers getCustomerById(String customerID) {
	            try (Session session = HibernateUtil.getSession()) {
	                session.beginTransaction();
	                Customers customer = session.get(Customers.class, customerID); // Get customer by ID
	                session.getTransaction().commit();
	                return customer;
	            } catch (HibernateException e) {
	                System.out.println(e);
	            } catch (Exception e) {
	                System.out.println(e);
	            }
	            return null;
	        }
	  @Override
	  public void bookHotel(Hotels hotelID)
	  {
		  try (Session session = HibernateUtil.getSession()) {
              session.beginTransaction();
              // Get customer by ID
              List<Customers> customersList=session.createQuery("FROM Customers", Customers.class).list();
              hotelID.setCustomers(customersList);
              customersList.set;
              session.save(customersList );
              session.save(hotelID);
              session.getTransaction().commit();
              
          } catch (HibernateException e) {
              System.out.println(e);
          } catch (Exception e) {
              System.out.println(e);
          }
	  }
}
