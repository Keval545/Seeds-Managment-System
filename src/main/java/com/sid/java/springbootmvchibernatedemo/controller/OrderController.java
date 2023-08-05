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

import com.sid.java.springbootmvchibernatedemo.entity.Farmer;
import com.sid.java.springbootmvchibernatedemo.entity.Order;
import com.sid.java.springbootmvchibernatedemo.entity.Seed;
import com.sid.java.springbootmvchibernatedemo.entity.Supplier;
import com.sid.java.springbootmvchibernatedemo.service.OrderService;
import com.sid.java.springbootmvchibernatedemo.service.SeedService;
import com.sid.java.springbootmvchibernatedemo.service.FarmerService;
import com.sid.java.springbootmvchibernatedemo.service.SupplierService;

@Controller
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private SeedService seedService;

    @Autowired
    private FarmerService farmerService;

    @Autowired
    private SupplierService supplierService;

    @GetMapping("/order/{id}")
    public String getOrder(@PathVariable Long id, ModelMap orderModel) {
        Order order = orderService.getOrder(id);
        orderModel.addAttribute("order", order);
        return "order";
    }

    @GetMapping("/orders")
    public String getOrders(ModelMap orderModel) {
        List<Order> orders = orderService.getOrders();
        orderModel.addAttribute("orders", orders);
        return "orders";
    }

    @GetMapping("/addOrder")
    public String addPage(ModelMap orderModel) {
    	List<Seed> seeds = seedService.getSeeds();
    	List<Farmer> farmers = farmerService.getFarmers();
    	List<Supplier> suppliers = supplierService.getSuppliers();
    	orderModel.addAttribute("seeds", seeds);
    	orderModel.addAttribute("farmers", farmers);
    	orderModel.addAttribute("suppliers", suppliers);
        return "addOrder";
    }

    @PostMapping("/add/order")
    public String addOrder(@RequestParam(value = "seed_id", required = true) Long seed_id,
            @RequestParam(value = "farmer_id", required = true) Long farmer_id,
            @RequestParam(value = "supplier_id", required = true) Long supplier_id,
            @RequestParam(value = "orderDate", required = true) String orderDate,
            @RequestParam(value = "quantity", required = true) Integer quantity,
            ModelMap orderModel) {
        Order order = new Order();
        order.setSeed(seedService.getSeed(seed_id));
        order.setFarmer(farmerService.getFarmer(farmer_id));
        order.setSupplier(supplierService.getSupplier(supplier_id));
        order.setOrderDate(orderDate);
        order.setQuantity(quantity);
        int totalPrice = quantity*seedService.getSeed(seed_id).getPrice();
        order.setPrice(totalPrice);
        orderService.addOrder(order);
        orderModel.addAttribute("msg", "Order added successfully");
        List<Order> orders = orderService.getOrders();
        orderModel.addAttribute("orders", orders);
        return "redirect:/orders";
    }

    @GetMapping("/update/order/{id}")
    public String updatePage(@PathVariable("id") Long id, ModelMap orderModel) {
    	List<Seed> seeds = seedService.getSeeds();
    	List<Farmer> farmers = farmerService.getFarmers();
    	List<Supplier> suppliers = supplierService.getSuppliers();
    	orderModel.addAttribute("seeds", seeds);
    	orderModel.addAttribute("farmers", farmers);
    	orderModel.addAttribute("suppliers", suppliers);
        orderModel.addAttribute("id", id);
        Order order = orderService.getOrder(id);
        orderModel.addAttribute("order", order);
        return "updateOrder";
    }
    @GetMapping("/delete/order/{id}")
    public String deleteOrder(@PathVariable("id") Long id, ModelMap orderModel) {
        orderService.deleteOrder(id);
        orderModel.addAttribute("msg", "Order deleted successfully");
        List<Order> orders = orderService.getOrders();
        orderModel.addAttribute("orders", orders);
        return "redirect:/orders";
    }
    
    @PostMapping("/update/order")
    public String updateOrder(@RequestParam(value = "order_id", required = true) Long order_id,
            @RequestParam(value = "seed_id", required = true) Long seed_id,
            @RequestParam(value = "farmer_id", required = true) Long farmer_id,
            @RequestParam(value = "supplier_id", required = true) Long supplier_id,
            @RequestParam(value = "orderDate", required = true) String orderDate,
            @RequestParam(value = "quantity", required = true) Integer quantity,
            ModelMap orderModel) {
        Order order = orderService.getOrder(order_id);
        order.setSeed(seedService.getSeed(seed_id));
        order.setFarmer(farmerService.getFarmer(farmer_id));
        order.setSupplier(supplierService.getSupplier(supplier_id));
        order.setOrderDate(orderDate);
        order.setQuantity(quantity);
        int totalPrice = quantity*seedService.getSeed(seed_id).getPrice();
        order.setPrice(totalPrice);
        orderService.updateOrder(order);
        orderModel.addAttribute("msg", "Order updated successfully");
        List<Order> orders = orderService.getOrders();
        orderModel.addAttribute("orders", orders);
        return "redirect:/orders";
    }

}
