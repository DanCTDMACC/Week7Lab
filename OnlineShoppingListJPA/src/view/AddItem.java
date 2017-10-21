package view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ListItem;

public class AddItem {

	public static void main(String[] args) {

		// Create an instance of the EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// Create the entity based off the object
		ListItem toAdd = new ListItem("Target", "Coffee");

		// Put the item in the database
		em.persist(toAdd);
		em.getTransaction().commit();

		// Cleaning
		em.close();
		emfactory.close();
	}

}
