package com.sid.java.springbootmvchibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.java.springbootmvchibernatedemo.entity.Farmer;
import com.sid.java.springbootmvchibernatedemo.service.FarmerService;

@Controller
public class FarmerController {

    @Autowired
    private FarmerService FarmerService;

    @GetMapping("/Farmer/{id}")
    public String getFarmer(@PathVariable Long id, ModelMap FarmerModel) {
        Farmer Farmer = FarmerService.getFarmer(id);
        FarmerModel.addAttribute("Farmer", Farmer);
        return "Farmer";
    }

    @GetMapping("/Farmers")
    public String getFarmers(ModelMap FarmerModel) {
        List<Farmer> Farmers = FarmerService.getFarmers();
        FarmerModel.addAttribute("Farmers", Farmers);
        return "Farmers";
    }

    @GetMapping("addFarmer")
    public String addPage() {
        return "addFarmer";
    }

    @PostMapping("/add/Farmer")
    public String addFarmer(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "address", required = true) String address,
            ModelMap FarmerModel) {
        Farmer Farmer = new Farmer();
        Farmer.setName(name);
        Farmer.setAddress(address);
        FarmerService.addFarmer(Farmer);
        FarmerModel.addAttribute("msg", "Farmer added successfully");
        List<Farmer> Farmers = FarmerService.getFarmers();
        FarmerModel.addAttribute("Farmers", Farmers);
        return "redirect:/Farmers";
    }

    @GetMapping("update/Farmer/{id}")
    public String updatePage(@PathVariable("id")Long id, ModelMap FarmerModel) {
        FarmerModel.addAttribute("id", id);
        Farmer Farmer = FarmerService.getFarmer(id);
        FarmerModel.addAttribute("Farmer", Farmer);
        return "updateFarmer";
    }

    @PostMapping("/update/Farmer")
    public String updateFarmer(@RequestParam Long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "address", required = true) String address,
            @RequestParam(value = "orders", required = false) List<Integer> orderIds,
            ModelMap farmerModel) {
        Farmer farmer = new Farmer(id, name, address, null); 
        FarmerService.updateFarmer(farmer);
        List<Farmer> farmers = FarmerService.getFarmers();
        farmerModel.addAttribute("farmers", farmers);
        farmerModel.addAttribute("id", id);
        farmerModel.addAttribute("msg", "Farmer updated successfully");
        return "redirect:/Farmers";
    }


    @GetMapping("/delete/Farmer/{id}")
    public String deleteFarmer(@PathVariable Long id, ModelMap FarmerModel) {
        FarmerService.deleteFarmer(id);
        List<Farmer> Farmers = FarmerService.getFarmers();
        FarmerModel.addAttribute("Farmers", Farmers);
        FarmerModel.addAttribute("msg", "Farmer deleted successfully");
        return "redirect:/Farmers";
    }
}
