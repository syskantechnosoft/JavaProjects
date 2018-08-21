package com.uhg.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.uhg.jpa.bean.User;

public class JPACRUDDemo {

	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("Day7JPA");
		EntityManager em = emf.createEntityManager();

		// Insert Operation
		User user = new User();
		user.setUserid(121);
		user.setUsername("JPAUser");
		user.setPassword("jpauser123");

		em.getTransaction().begin();
		em.persist(user);
		em.getTransaction().commit();
		System.out.println("1 Record Inserted!!");

		// Edit/Update Operation
		em.getTransaction().begin();
		User user2 = em.find(User.class, 121);
		user2.setUsername("JPA_Updated");
		em.persist(user2);
		em.getTransaction().commit();
		System.out.println("1 Record Updated!!!");

		// Read Operation
		em.getTransaction().begin();

		TypedQuery<User> typedQuery = em.createNamedQuery("User.findAll", User.class);
		System.out.println("User Table Contents");
		List<User> userList = typedQuery.getResultList();
		for (User user3 : userList) {
			System.out.println(user3);
		}
		em.getTransaction().commit();
		System.out.println("\n");

		// Delete Operation
		em.getTransaction().begin();
		User user1 = em.find(User.class, 121);
		em.remove(user1);
		em.getTransaction().commit();
		System.out.println("1 Record Deleted!!!");
	}

}
