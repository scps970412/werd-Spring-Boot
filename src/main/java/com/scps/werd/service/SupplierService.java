package com.scps.werd.service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.scps.werd.model.Supplier;

public class SupplierService {
    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public int add(Supplier supplier) {
        // TODO Auto-generated method stub
        jdbcTemplate.setDataSource(dataSource);
        jdbcTemplate.update("");
        return 0;
    }

}
