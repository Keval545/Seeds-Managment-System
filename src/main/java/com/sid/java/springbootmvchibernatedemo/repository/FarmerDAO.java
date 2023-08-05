package com.sid.java.springbootmvchibernatedemo.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sid.java.springbootmvchibernatedemo.entity.*;

@Repository
public class FarmerDAO{

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public FarmerDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Farmer getFarmer(Long id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// retrieve Farmer by id
		Farmer Farmer = currentSession.get(Farmer.class, id);

		currentSession.close();

		return Farmer;
	}
	@Transactional
	public void updateFarmer(final Farmer Farmer) {
	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
	currentSession.merge(Farmer);
	currentSession.close();
	}
	public List<Farmer> getFarmers() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		TypedQuery<Farmer> theQuery =
				currentSession.createQuery("from Farmer", Farmer.class);

		// execute query and get result list
		List<Farmer> Farmers = theQuery.getResultList();

		currentSession.close();

		return Farmers;
	}

	@Transactional
	public void saveFarmer(Farmer Farmer) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save or update the Farmer
		currentSession.saveOrUpdate(Farmer);

		currentSession.close();
	}
	
	@Transactional
	public void addFarmer(final Farmer Farmer) {
	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
	currentSession.persist(Farmer);
	currentSession.close();
	}
	
	@Transactional
	public void deleteFarmer(Long id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		TypedQuery<Farmer> theQuery =
				currentSession.createQuery("delete from Farmer where id=:FarmerId");
		theQuery.setParameter("FarmerId", id);

		theQuery.executeUpdate();

		currentSession.close();
	}

}
