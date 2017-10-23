package com.sporla.sporla.entity;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path("users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON) 
@Stateless
public class UserController {

	@PersistenceContext
	private EntityManager entityManagerr;

	@GET
	@Path("getById/{id}") 
	public Userr getUser(@PathParam("id") Integer id) {
		return entityManagerr.find(Userr.class, id);
	}

	@PUT
	@Path("save")
	public boolean save(Userr user) {
		Userr userr = new Userr();
		userr.setName(user.getName());
		entityManagerr.persist(userr);
		return true;
	}

	@PUT
	@Path("update")
	public boolean update(Userr user) {
		Userr u = entityManagerr.find(Userr.class, user.getId());
		u = user;
		entityManagerr.persist(u);
		return true;
	}
	
	
}
