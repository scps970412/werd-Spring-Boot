package com.scps.werd.model;

public class SearchCondition {
    /** 顯示筆數 */
    private int pageSize;
    /** 頁數 */
    private int page;
    /** 供應商 */
    private String supplier;
    /** 統編 */
    private String unifiedBusinessNo;
    /** 地址 */
    private String address;
    /** 電子信箱 */
    private String email;
    /** 負責人/聯絡人 */
    private String name;
    /** 負責人電話/聯絡人電話 */
    private String phone;
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        this.page = page;
    }
    public String getSupplier() {
        return supplier;
    }
    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    public String getUnifiedBusinessNo() {
        return unifiedBusinessNo;
    }
    public void setUnifiedBusinessNo(String unifiedBusinessNo) {
        this.unifiedBusinessNo = unifiedBusinessNo;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
