package com.project.dto;

/**
 * 物流商
 */
public class BizUser {

    private String eptName;

    private String contact;

    private String mobile;

    private String qq;

    private String eptType;

    private String license;

    private String permissionCode;

    private String taxLicense;

    private String transportPermission;

    public String getEptName() {
        return eptName;
    }

    public void setEptName(String eptName) {
        this.eptName = eptName;
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
                "eptName='" + eptName + '\'' +
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
