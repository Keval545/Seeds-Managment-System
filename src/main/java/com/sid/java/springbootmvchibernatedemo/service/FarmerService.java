package com.sid.java.springbootmvchibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.java.springbootmvchibernatedemo.entity.*;
import com.sid.java.springbootmvchibernatedemo.repository.*;

@Service
public class FarmerService {

    // inject Farmer DAO
    @Autowired
    private FarmerDAO FarmerDAO;

    @Transactional
    public Farmer getFarmer(Long id) {
        return FarmerDAO.getFarmer(id);
    }

    @Transactional
    public List<Farmer> getFarmers() {
        return FarmerDAO.getFarmers();
    }
    
    @Transactional
    public void addFarmer(final Farmer Farmer) {
        FarmerDAO.addFarmer(Farmer);
    }
    
    @Transactional
    public void saveFarmer(Farmer Farmer) {
        FarmerDAO.saveFarmer(Farmer);
    }
    @Transactional
	public void updateFarmer(final Farmer Farmer) {
		FarmerDAO.updateFarmer(Farmer);
	}
    @Transactional
    public void deleteFarmer(Long id) {
        FarmerDAO.deleteFarmer(id);
    }
}
