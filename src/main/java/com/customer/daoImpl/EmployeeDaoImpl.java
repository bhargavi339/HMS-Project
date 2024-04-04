package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.EmployeeDao;
import com.customer.entity.Employees;
import com.customer.util.HibernateUtil;

public class EmployeeDaoImpl implements EmployeeDao{

	public Employees createEmployee(Employees employee) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(employee);
		session.getTransaction().commit();
		return employee;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Employees>getAllEmployees(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM Employees", Employees.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void updateEmployee(Employees employee) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(employee); // Update existing employee
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteEmployee(Employees employee) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(employee); // Delete the employee
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Employees getEmployeeById(String employeeId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Employees employee = session.get(Employees.class, employeeId); // Get employee by ID
            session.getTransaction().commit();
            return employee;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
