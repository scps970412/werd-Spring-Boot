package com.scps.werd.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scps.werd.model.Supplier;
import com.scps.werd.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    
    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody Supplier supplier) {        
        String id = supplierService.add(supplier);
        return id;
    }
    
    @PostMapping("/tryAddPs")
    @ResponseBody
    public String tryAddPs(@RequestBody Supplier supplier) throws SQLException
    {
        String id =  supplierService.tryAddPs(supplier);
        return id;
    }
}
