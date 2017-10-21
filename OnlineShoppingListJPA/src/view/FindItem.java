package view;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.ListItem;

public class FindItem {

	public static void main(String[] args) {

		// Create an instance of the EntityManagerFactory
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("OnlineShoppingListJPA");
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();

		// 1 is the id of the item
		ListItem found = em.find(ListItem.class, 1);
		System.out.println(found.getStore() + ": " + found.getItem());

		// Cleaning
		em.close();
		emfactory.close();

	}

}
