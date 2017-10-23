package com.sporla.sporla.test;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sporla.sporla.entity.Userr;

@Singleton
@Startup
public class StartUpBean {

	@PersistenceContext
	private EntityManager entityManager;
	
	@PostConstruct
	public void deneme() {
		
		
		Userr user = new Userr(); 
		user.setName("kutsi");
		entityManager.persist(user );
	}
}
