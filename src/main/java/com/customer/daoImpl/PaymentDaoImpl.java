package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.PaymentDao;
import com.customer.entity.Payments;
import com.customer.util.HibernateUtil;

public class PaymentDaoImpl implements PaymentDao{
	public Payments createPayment(Payments payment) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(payment);
		session.getTransaction().commit();
		return payment;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Payments>getAllPayments(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM Payments", Payments.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void updatePayment(Payments payment) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(payment); // Update existing payment
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deletePayment(Payments payment) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(payment); // Delete the payment
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Payments getPaymentById(String paymentId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Payments payment = session.get(Payments.class, paymentId); // Get payment by ID
            session.getTransaction().commit();
            return payment;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
