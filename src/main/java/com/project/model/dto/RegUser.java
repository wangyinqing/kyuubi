package com.project.model.dto;

/**
 * @author wangyinqing
 */
public class RegUser {

    private String account;
    private String password;
    private String mobile;
    private String eptname;
    private String name;

    private String qq;
    private String email;
    private String eptaddress;
    private Long region;

    private String validationCode;

    private int regType = 1;

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

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEptname() {
        return eptname;
    }

    public void setEptname(String eptname) {
        this.eptname = eptname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEptaddress() {
        return eptaddress;
    }

    public void setEptaddress(String eptaddress) {
        this.eptaddress = eptaddress;
    }

    public Long getRegion() {
        return region;
    }

    public void setRegion(Long region) {
        this.region = region;
    }

    public int getRegType() {
        return regType;
    }

    public void setRegType(int regType) {
        this.regType = regType;
    }

    public String getValidationCode() {
        return validationCode;
    }

    public void setValidationCode(String validationCode) {
        this.validationCode = validationCode;
    }

    @Override
    public String toString() {
        return "RegUser{" +
                "account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", eptname='" + eptname + '\'' +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", eptaddress='" + eptaddress + '\'' +
                ", region=" + region +
                ", regType=" + regType +
                '}';
    }
}