package com.scps.werd.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Supplier {
    /** 建立人員 */
    private String creator;
    /** 更新人員 */
    private String updater;
    /** 備註 */
    @Size(max = 200, message = "備註不得超過200字")
    private String remark;
    /** 供應商ID */
    @Size(max = 10, message = "供應商ID不得超過10字")
    private String id;
    /** 供應商 */
    @Size(max = 30, message = "供應商不得超過30字")
    @NotBlank(message = "供應商為必填")
    private String supplier;
    /** 統一編號 */
    @Size(max = 8, min = 8, message = "統一編號必須為8字")
    @Pattern(regexp = "^[0-9]+$", message = "統一編號必須是數字")
    @NotBlank(message = "統一編號為必填")
    private String unifiedBusinessNo;
    /** 電子郵件 */
    @Email(message = "電子郵件格是錯誤")
    @Size(max = 50, message = "電子郵件不得超過50字")
    @NotBlank(message = "電子郵件為必填")
    private String email;
    /** 供應商地址 1 */
    @Size(max = 100, message = "供應商地址1不得超過100字")
    @NotBlank(message = "供應商地址為必填")
    private String address1;
    /** 供應商地址 2 */
    @Size(max = 100, message = "供應商地址2不得超過100字")
    private String address2;
    /** 負責人 */
    @Size(max = 20, message = "負責人不得超過20字")
    @NotBlank(message = "負責人為必填")
    private String head;
    /** 負責人電話 1 */
    @Size(max = 20, message = "負責人電話1不得超過20字")
    private String headPhone1;
    /** 負責人電話 2 */
    @Size(max = 20, message = "負責人電話2不得超過20字")
    private String headPhone2;
    /** 聯絡人 */
    @Size(max = 20, message = "聯絡人不得超過20字")
    private String contactPerson;
    /** 聯絡人電話 1 */
    @Size(max = 20, message = "聯絡人電話1不得超過20字")
    @NotBlank(message = "聯絡人為必填")
    private String contactPersonPhone1;
    /** 聯絡人電話 2 */
    @Size(max = 20, message = "聯絡人電話2不得超過20字")
    private String contactPersonPhone2;
    /** 其他聯絡方式 1 */
    @Size(max = 100, message = "其他聯絡方式1不得超過100字")
    private String otherContact1;
    /** 其他聯絡方式 2 */
    @Size(max = 100, message = "其他聯絡方式2不得超過100字")
    private String otherContact2;
}
