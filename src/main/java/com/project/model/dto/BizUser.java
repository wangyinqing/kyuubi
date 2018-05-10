package com.project.model.dto;

/**
 * 物流商
 */
public class BizUser {

    private String account;

    private String password;

    private String eptname;

    private Integer status;

    private String contact;

    private String mobile;

    private String qq;

    private String eptType;

    private String license;

    private String permissionCode;

    private String taxLicense;

    private String transportPermission;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEptname() {
        return eptname;
    }

    public void setEptname(String eptname) {
        this.eptname = eptname;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEptType() {
        return eptType;
    }

    public void setEptType(String eptType) {
        this.eptType = eptType;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getPermissionCode() {
        return permissionCode;
    }

    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode;
    }

    public String getTaxLicense() {
        return taxLicense;
    }

    public void setTaxLicense(String taxLicense) {
        this.taxLicense = taxLicense;
    }

    public String getTransportPermission() {
        return transportPermission;
    }

    public void setTransportPermission(String transportPermission) {
        this.transportPermission = transportPermission;
    }

    @Override
    public String toString() {
        return "BizUser{" +
                "eptName='" + eptname + '\'' +
                ", contact='" + contact + '\'' +
                ", mobile='" + mobile + '\'' +
                ", qq='" + qq + '\'' +
                ", eptType='" + eptType + '\'' +
                ", license='" + license + '\'' +
                ", permissionCode='" + permissionCode + '\'' +
                ", taxLicense='" + taxLicense + '\'' +
                ", transportPermission='" + transportPermission + '\'' +
                '}';
    }
}
