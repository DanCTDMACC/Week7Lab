package view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ListItem;

public class RemoveItem {

	public static void main(String[] args) {

		// Create an instance of the EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// 8 is the id of the item
		ListItem toRemove = em.find(ListItem.class, 8);
		em.remove(toRemove);
		
		// commit to save the action to the database
		em.getTransaction().commit();

		// Cleaning
		em.close();
		emfactory.close();

	}

}
