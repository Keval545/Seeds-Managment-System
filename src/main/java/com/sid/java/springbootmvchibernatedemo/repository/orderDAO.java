package com.sid.java.springbootmvchibernatedemo.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sid.java.springbootmvchibernatedemo.entity.Order;

@Repository
public class orderDAO{

    // define field for entity manager
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public orderDAO(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    public Order getOrder(Long id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // retrieve order by id
        Order order = currentSession.get(Order.class, id);

        currentSession.close();

        return order;
    }

    @Transactional
    public void updateOrder(Order order) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.merge(order);
        currentSession.close();
    }

    public List<Order> getOrders() {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // create a query
        TypedQuery<Order> theQuery =
                currentSession.createQuery("from Order", Order.class);

        // execute query and get result list
        List<Order> orders = theQuery.getResultList();

        currentSession.close();

        return orders;
    }

    @Transactional
    public void saveOrder(Order order) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // save or update the order
        currentSession.saveOrUpdate(order);

        currentSession.close();
    }

    @Transactional
    public void addOrder(Order order) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.persist(order);
        currentSession.close();
    }

    @Transactional
    public void deleteOrder(Long id) {
        // get the current hibernate session
        Session currentSession = entityManager.unwrap(Session.class);

        // delete object with primary key
        TypedQuery<Order> theQuery =
                currentSession.createQuery("delete from Order where id=:orderId");
        theQuery.setParameter("orderId", id);

        theQuery.executeUpdate();

        currentSession.close();
    }

}
