package com.sid.java.springbootmvchibernatedemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sid.java.springbootmvchibernatedemo.entity.*;
import com.sid.java.springbootmvchibernatedemo.repository.*;

@Service
public class SeedService {

    // inject seed DAO
    @Autowired
    private SeedDAO seedDAO;

    @Transactional
    public Seed getSeed(Long id) {
        return seedDAO.getSeed(id);
    }

    @Transactional
    public List<Seed> getSeeds() {
        return seedDAO.getSeeds();
    }
    
    @Transactional
    public void addSeed(final Seed seed) {
        seedDAO.addSeed(seed);
    }
    
    @Transactional
    public void saveSeed(Seed seed) {
        seedDAO.saveSeed(seed);
    }
    @Transactional
	public void updateSeed(final Seed seed) {
		seedDAO.updateSeed(seed);
	}
    @Transactional
    public void deleteSeed(Long id) {
        seedDAO.deleteSeed(id);
    }
}
