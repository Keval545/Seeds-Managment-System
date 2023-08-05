package com.sid.java.springbootmvchibernatedemo.controller;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.java.springbootmvchibernatedemo.entity.Seed;
import com.sid.java.springbootmvchibernatedemo.service.SeedService;

@Controller
public class SeedController {

    @Autowired
    private SeedService seedService;

    @GetMapping("/seed/{id}")
    public String getSeed(@PathVariable Long id, ModelMap seedModel) {
        Seed seed = seedService.getSeed(id);
        seedModel.addAttribute("seed", seed);
        return "seed";
    }

    @GetMapping("/seeds")
    public String getSeeds(ModelMap seedModel) {
        List<Seed> seeds = seedService.getSeeds();
        seedModel.addAttribute("seeds", seeds);
        return "seeds";
    }

    @GetMapping("addSeed")
    public String addPage() {
        return "addSeed";
    }

    @PostMapping("/add/seed")
    public String addSeed(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "quantity", required = true) int quantity,
            @RequestParam(value = "price", required = true) int price,
            @RequestParam(value = "purchaseDate", required = true) Date purchaseDate,
            ModelMap seedModel) {
        Seed seed = new Seed();
        seed.setName(name);
        seed.setDescription(description);
        seed.setQuantity(quantity);
        seed.setPrice(price);
        seed.setPurchaseDate(purchaseDate);
        seedService.addSeed(seed);
        seedModel.addAttribute("msg", "Seed added successfully");
        List<Seed> seeds = seedService.getSeeds();
        seedModel.addAttribute("seeds", seeds);
        return "redirect:/seeds";
    }

    @GetMapping("update/seed/{id}")
    public String updatePage(@PathVariable("id")Long id, ModelMap seedModel) {
        seedModel.addAttribute("id", id);
        Seed seed = seedService.getSeed(id);
        seedModel.addAttribute("seed", seed);
        return "updateseed";
    }

    @PostMapping("/update/seed")
    public String updateSeed(@RequestParam Long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "description", required = true) String description,
            @RequestParam(value = "quantity", required = true) int quantity,
            @RequestParam(value = "price", required = true) int price,
            @RequestParam(value = "purchaseDate", required = true) Date purchaseDate,
            ModelMap seedModel) {
        Seed seed = new Seed(id, name, description, quantity, price, purchaseDate);
        seedService.updateSeed(seed);
        List<Seed> seeds = seedService.getSeeds();
        seedModel.addAttribute("seeds", seeds);
        seedModel.addAttribute("id", id);
        seedModel.addAttribute("msg", "Seed updated successfully");
        return "redirect:/seeds";
    }

    @GetMapping("/delete/seed/{id}")
    public String deleteSeed(@PathVariable Long id, ModelMap seedModel) {
        seedService.deleteSeed(id);
        List<Seed> seeds = seedService.getSeeds();
        seedModel.addAttribute("seeds", seeds);
        seedModel.addAttribute("msg", "Seed deleted successfully");
        return "redirect:/seeds";
    }
}
