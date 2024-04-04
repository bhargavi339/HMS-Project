package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.FeedbackDao;
import com.customer.entity.Feedback;
import com.customer.util.HibernateUtil;

public class FeedbackDaoImpl implements FeedbackDao{
	public Feedback createFeedback(Feedback feedback) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(feedback);
		session.getTransaction().commit();
		return feedback;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Feedback>getAllFeedbacks(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM Feedback", Feedback.class).list();
		
		
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	 public void updateFeedback(Feedback feedback) {
	        try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            session.update(feedback); // Update existing feedback
	            session.getTransaction().commit();
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

	    public void deleteFeedback(Feedback feedback) {
	        try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            session.delete(feedback); // Delete the feedback
	            session.getTransaction().commit();
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }

//	    public Feedback getFeedbackById(String feedbackId) {
//	        try (Session session = HibernateUtil.getSession()) {
//	            session.beginTransaction();
//	            Feedback feedback = session.get(Feedback.class, feedbackId); // Get feedback by ID
//	            session.getTransaction().commit();
//	            return feedback;
//	        } catch (HibernateException e) {
//	            System.out.println(e);
//	        } catch (Exception e) {
//	            System.out.println(e);
//	        }
//	        return null;
//	    }
//	
	    public Feedback getFeedbackById(String feedbackId) {
	        try (Session session = HibernateUtil.getSession()) {
	            session.beginTransaction();
	            Feedback feedback = session.get(Feedback.class, feedbackId); // Get feedback by ID
	            session.getTransaction().commit();
	            return feedback;
	        } catch (HibernateException e) {
	            System.out.println(e);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	        return null;
	    }
}
