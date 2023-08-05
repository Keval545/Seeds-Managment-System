package com.sid.java.springbootmvchibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.java.springbootmvchibernatedemo.entity.Order;
import com.sid.java.springbootmvchibernatedemo.repository.orderDAO;

@Service
public class OrderService {

    @Autowired
    private orderDAO orderDAO;

    @Transactional
    public Order getOrder(Long id) {
        return orderDAO.getOrder(id);
    }

    @Transactional
    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    @Transactional
    public List<Order> getOrders() {
        return orderDAO.getOrders();
    }

    @Transactional
    public void saveOrder(Order order) {
        orderDAO.saveOrder(order);
    }

    @Transactional
    public void addOrder(Order order) {
        orderDAO.addOrder(order);
    }

    @Transactional
    public void deleteOrder(Long id) {
        orderDAO.deleteOrder(id);
    }
}
