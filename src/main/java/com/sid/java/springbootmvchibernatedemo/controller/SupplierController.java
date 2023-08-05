package com.sid.java.springbootmvchibernatedemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.sid.java.springbootmvchibernatedemo.entity.Order;
import com.sid.java.springbootmvchibernatedemo.entity.Supplier;
import com.sid.java.springbootmvchibernatedemo.service.SupplierService;

@Controller
public class SupplierController {

    @Autowired
    private SupplierService SupplierService;

    @GetMapping("/Supplier/{id}")
    public String getSupplier(@PathVariable Long id, ModelMap SupplierModel) {
        Supplier Supplier = SupplierService.getSupplier(id);
        SupplierModel.addAttribute("Supplier", Supplier);
        return "Supplier";
    }

    @GetMapping("/Suppliers")
    public String getSuppliers(ModelMap SupplierModel) {
        List<Supplier> Suppliers = SupplierService.getSuppliers();
        SupplierModel.addAttribute("Suppliers", Suppliers);
        return "Suppliers";
    }

    @GetMapping("addSupplier")
    public String addPage() {
        return "addSupplier";
    }

    @PostMapping("/add/Supplier")
    public String addSupplier(@RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "address", required = true) String address,
            ModelMap SupplierModel) {
        Supplier Supplier = new Supplier();
        Supplier.setName(name);
        Supplier.setAddress(address);
        SupplierService.addSupplier(Supplier);
        SupplierModel.addAttribute("msg", "Supplier added successfully");
        List<Supplier> Suppliers = SupplierService.getSuppliers();
        SupplierModel.addAttribute("Suppliers", Suppliers);
        return "redirect:/Suppliers";
    }

    @GetMapping("update/Supplier/{id}")
    public String updatePage(@PathVariable("id")Long id, ModelMap SupplierModel) {
        SupplierModel.addAttribute("id", id);
        Supplier Supplier = SupplierService.getSupplier(id);
        SupplierModel.addAttribute("Supplier", Supplier);
        return "updateSupplier";
    }

    @PostMapping("/update/Supplier")
    public String updateSupplier(@RequestParam Long id,
            @RequestParam(value = "name", required = true) String name,
            @RequestParam(value = "address", required = true) String address,
            ModelMap SupplierModel) {
        Supplier supplier = new Supplier(id, name, address);
        SupplierService.updateSupplier(supplier);
        List<Supplier> suppliers = SupplierService.getSuppliers();
        SupplierModel.addAttribute("suppliers", suppliers);
        SupplierModel.addAttribute("id", id);
        SupplierModel.addAttribute("msg", "Supplier updated successfully");
        return "redirect:/Suppliers";
    }


    @GetMapping("/delete/Supplier/{id}")
    public String deleteSupplier(@PathVariable Long id, ModelMap SupplierModel) {
        SupplierService.deleteSupplier(id);
        List<Supplier> Suppliers = SupplierService.getSuppliers();
        SupplierModel.addAttribute("Suppliers", Suppliers);
        SupplierModel.addAttribute("msg", "Supplier deleted successfully");
        return "redirect:/Suppliers";
    }
}
