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
public class SupplierDAO{

	// define field for entity manager
	private EntityManager entityManager;

	// set up constructor injection
	@Autowired
	public SupplierDAO(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}

	public Supplier getSupplier(Long id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// retrieve Supplier by id
		Supplier Supplier = currentSession.get(Supplier.class, id);

		currentSession.close();

		return Supplier;
	}
	@Transactional
	public void updateSupplier(final Supplier Supplier) {
	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
	currentSession.merge(Supplier);
	currentSession.close();
	}
	public List<Supplier> getSuppliers() {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// create a query
		TypedQuery<Supplier> theQuery =
				currentSession.createQuery("from Supplier", Supplier.class);

		// execute query and get result list
		List<Supplier> Suppliers = theQuery.getResultList();

		currentSession.close();

		return Suppliers;
	}

	@Transactional
	public void saveSupplier(Supplier Supplier) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// save or update the Supplier
		currentSession.saveOrUpdate(Supplier);

		currentSession.close();
	}
	
	@Transactional
	public void addSupplier(final Supplier Supplier) {
	// get the current hibernate session
	Session currentSession = entityManager.unwrap(Session.class);
	currentSession.persist(Supplier);
	currentSession.close();
	}
	
	@Transactional
	public void deleteSupplier(Long id) {
		// get the current hibernate session
		Session currentSession = entityManager.unwrap(Session.class);

		// delete object with primary key
		TypedQuery<Supplier> theQuery =
				currentSession.createQuery("delete from Supplier where id=:SupplierId");
		theQuery.setParameter("SupplierId", id);

		theQuery.executeUpdate();

		currentSession.close();
	}

}
