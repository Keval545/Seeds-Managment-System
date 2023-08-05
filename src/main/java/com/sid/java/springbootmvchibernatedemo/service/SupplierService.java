package com.sid.java.springbootmvchibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.java.springbootmvchibernatedemo.entity.*;
import com.sid.java.springbootmvchibernatedemo.repository.*;

@Service
public class SupplierService {

    // inject Supplier DAO
    @Autowired
    private SupplierDAO SupplierDAO;

    @Transactional
    public Supplier getSupplier(Long id) {
        return SupplierDAO.getSupplier(id);
    }

    @Transactional
    public List<Supplier> getSuppliers() {
        return SupplierDAO.getSuppliers();
    }
    
    @Transactional
    public void addSupplier(final Supplier Supplier) {
        SupplierDAO.addSupplier(Supplier);
    }
    
    @Transactional
    public void saveSupplier(Supplier Supplier) {
        SupplierDAO.saveSupplier(Supplier);
    }
    @Transactional
	public void updateSupplier(final Supplier Supplier) {
		SupplierDAO.updateSupplier(Supplier);
	}
    @Transactional
    public void deleteSupplier(Long id) {
        SupplierDAO.deleteSupplier(id);
    }
}
