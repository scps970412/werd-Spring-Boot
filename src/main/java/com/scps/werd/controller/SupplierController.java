package com.scps.werd.controller;

import java.sql.SQLException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.scps.werd.model.SearchCondition;
import com.scps.werd.model.Supplier;
import com.scps.werd.model.SupplierSearchResult;
import com.scps.werd.service.SupplierService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody Supplier supplier) throws SQLException {
        String id = supplierService.add(supplier);
        return id;
    }

    @PostMapping("/update")
    @ResponseBody
    public ResponseEntity<Integer> update(@Valid @RequestBody Supplier supplier) {
        //        int o_count = supplierService.updata(supplier);
//        return o_count;
//        throw new Exception("123");
        return ResponseEntity.ok(2);
    }

    @PostMapping("/delete")
    @ResponseBody
    public boolean delete(@RequestBody Supplier supplier) throws SQLException {
        boolean isDelete = supplierService.delete(supplier);
        return isDelete;
    }

    @PostMapping("/deleteIds")
    @ResponseBody
    public boolean deleteIds(@RequestBody String[] ids) throws SQLException {
        Supplier supplier = new Supplier();
        boolean isdelete = false;
        for (String id : ids) {
            supplier.setId(id);
            supplier.setUpdater("WRH");
            isdelete = supplierService.delete(supplier);
        }
        return isdelete;
    }

    @PostMapping("/getById")
    @ResponseBody
    public Supplier getById(@RequestBody Supplier supplier) throws SQLException {
        Supplier outSupplier = supplierService.getById(supplier.getId());
        return outSupplier;
    }

    @PostMapping("/getAll")
    @ResponseBody
    public List<Supplier> getAll() throws SQLException {
        List<Supplier> suppliers = supplierService.getAll();
        return suppliers;
    }

    @PostMapping("/getPagination")
    @ResponseBody
    public SupplierSearchResult getPagination(@RequestBody SearchCondition searchCondition) throws SQLException {
        SupplierSearchResult supplierSearchResult = new SupplierSearchResult();
        supplierSearchResult = supplierService.getPagination(searchCondition);
        return supplierSearchResult;
    }
    
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
