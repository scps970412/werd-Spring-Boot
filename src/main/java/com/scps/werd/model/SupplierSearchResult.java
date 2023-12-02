package com.scps.werd.model;

import java.util.List;

import lombok.Data;

@Data
public class SupplierSearchResult {
    /** 資料集 */
    private List<Supplier> suppliers;
    /** 總比數 */
    private Integer total;
}
