package com.scps.werd.model;

import lombok.Data;

@Data
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
}
