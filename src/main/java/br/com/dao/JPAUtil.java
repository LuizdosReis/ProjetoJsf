package br.com.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("livraria");
	
	
	public EntityManager getEntityManeger(){
		return entityManagerFactory.createEntityManager();
	}

}
