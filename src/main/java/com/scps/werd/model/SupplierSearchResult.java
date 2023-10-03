package com.scps.werd.model;

import java.util.List;

public class SupplierSearchResult {
    private List<Supplier> suppliers;
    private Integer total;
    
    public List<Supplier> getSuppliers() {
        return suppliers;
    }
    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }
    public Integer getTotal() {
        return total;
    }
    public void setTotal(Integer total) {
        this.total = total;
    }
}
