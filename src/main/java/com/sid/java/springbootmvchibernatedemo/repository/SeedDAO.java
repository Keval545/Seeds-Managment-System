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
public class SeedDAO{

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public SeedDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Seed getSeed(Long id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// retrieve seed by id
		Seed seed = currentSession.get(Seed.class, id);

		currentSession.close();

		return seed;
	}
	
	@Transactional
	public void updateSeed(final Seed seed) {
	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
	currentSession.merge(seed);
	currentSession.close();
	}
	public List<Seed> getSeeds() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		TypedQuery<Seed> theQuery =
				currentSession.createQuery("from Seed", Seed.class);

		// execute query and get result list
		List<Seed> seeds = theQuery.getResultList();

		currentSession.close();

		return seeds;
	}

	@Transactional
	public void saveSeed(Seed seed) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save or update the seed
		currentSession.saveOrUpdate(seed);

		currentSession.close();
	}
	
	@Transactional
	public void addSeed(final Seed seed) {
	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
	currentSession.persist(seed);
	currentSession.close();
	}
	
	@Transactional
	public void deleteSeed(Long id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		TypedQuery<Seed> theQuery =
				currentSession.createQuery("delete from Seed where id=:seedId");
		theQuery.setParameter("seedId", id);

		theQuery.executeUpdate();

		currentSession.close();
	}

}
