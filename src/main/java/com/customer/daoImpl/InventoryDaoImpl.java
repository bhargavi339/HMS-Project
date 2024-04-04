package com.customer.daoImpl;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.customer.dao.InventoryDao;
import com.customer.entity.Inventory;
import com.customer.util.HibernateUtil;

public class InventoryDaoImpl implements InventoryDao{
	public Inventory createInventory(Inventory inventory) {
		try(Session session=HibernateUtil.getSession()) {
		session.beginTransaction();
		session.save(inventory);
		session.getTransaction().commit();
		return inventory;
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public List<Inventory>getAllInventory(){
		try(Session session=HibernateUtil.getSession()) {
		return session.createQuery("FROM Inventory", Inventory.class).list();
		}
		catch(HibernateException e) {
			System.out.println(e);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public void updateInventory(Inventory inventory) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.update(inventory); // Update existing inventory
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void deleteInventory(Inventory inventory) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            session.delete(inventory); // Delete the inventory
            session.getTransaction().commit();
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public Inventory getInventoryById(String goodsId) {
        try (Session session = HibernateUtil.getSession()) {
            session.beginTransaction();
            Inventory inventory = session.get(Inventory.class, goodsId); // Get inventory by ID
            session.getTransaction().commit();
            return inventory;
        } catch (HibernateException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
        return null;
    }

}
