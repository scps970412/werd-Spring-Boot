package com.scps.werd.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scps.werd.model.Supplier;
import com.scps.werd.service.SupplierService;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    SupplierService supplierService;
    
    @PostMapping("/add")
    @ResponseBody
    public int add(Supplier supplier) {
        int id = supplierService.add(supplier);
        return id;
    }
}
