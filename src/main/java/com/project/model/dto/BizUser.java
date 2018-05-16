package com.project.model.dto;

/**
 * 物流商
 */
public class BizUser {

    private Long id;

    private String account;

    private String password;

    private String eptname;

    private Integer status;

    private String contact;

    private String mobile;

    private String qq;

    private String eptType;

    private String license;

    private String transportPermission;


    private boolean licenseVisible = false;

    private boolean permissionCodeVisible = false;

    private boolean taxLicenseVisible = false;

    private boolean transportPermissionVisible = false;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getTransportPermission() {
        return transportPermission;
    }

    public void setTransportPermission(String transportPermission) {
        this.transportPermission = transportPermission;
    }

    public boolean isLicenseVisible() {
        return licenseVisible;
    }

    public boolean isPermissionCodeVisible() {
        return permissionCodeVisible;
    }

    public boolean isTaxLicenseVisible() {
        return taxLicenseVisible;
    }

    public boolean isTransportPermissionVisible() {
        return transportPermissionVisible;
    }

    @Override
    public String toString() {
        return "BizUser{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", eptname='" + eptname + '\'' +
                ", status=" + status +
                ", contact='" + contact + '\'' +
                ", mobile='" + mobile + '\'' +
                ", qq='" + qq + '\'' +
                ", eptType='" + eptType + '\'' +
                ", license='" + license + '\'' +
                ", transportPermission='" + transportPermission + '\'' +
                ", licenseVisible=" + licenseVisible +
                ", permissionCodeVisible=" + permissionCodeVisible +
                ", taxLicenseVisible=" + taxLicenseVisible +
                ", transportPermissionVisible=" + transportPermissionVisible +
                '}';
    }
}
