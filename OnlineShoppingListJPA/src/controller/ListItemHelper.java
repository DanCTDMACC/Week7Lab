package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.ListItem;

public class ListItemHelper {

	public void insertItem(ListItem li) {

		// Create an instance of the EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Put the item into the database
		em.persist(li);
		em.getTransaction().commit();

		// Cleaning
		em.close();
		emfactory.close();
	}

	public List<ListItem> showAllItems() {
		List<ListItem> list = null;

		// Create an instance of the EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();

		try {
			TypedQuery<ListItem> typedQuery = em.createQuery("SELECT li FROM ListItem li", ListItem.class);
			list = typedQuery.getResultList();
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			em.close();
			emfactory.close();
		}

		return list;
	}

	public ListItem searchForItemById(Integer tempId) {

		// Create an instance of the EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Find the item in the database.
		ListItem result = em.find(ListItem.class, tempId);

		// Cleaning
		em.close();
		emfactory.close();

		return result;
	}

	public void deleteItem(ListItem itemToDelete) {

		// Create an instance of the EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Find the item to delete in the database.
		ListItem toRemove = em.find(ListItem.class, itemToDelete.getId());
		
		// Issue a command to delete.
		em.remove(toRemove);

		// commit to save the action to the database
		em.getTransaction().commit();

		// Cleaning
		em.close();
		emfactory.close();
	}

	public void updateItem(ListItem itemToUpdate) {

		// Create an instance of the EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// find the item in the database with the same id.
		ListItem updatingItem = em.find(ListItem.class, itemToUpdate.getId());
		
		// Update the fields.
		updatingItem.setStore(itemToUpdate.getStore());
		updatingItem.setItem(itemToUpdate.getItem());

		// commit to save the action to the database
		em.getTransaction().commit();

		// Cleaning
		em.close();
		emfactory.close();
	}
}
