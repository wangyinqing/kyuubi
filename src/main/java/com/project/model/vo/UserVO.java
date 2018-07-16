package com.project.model.vo;

/**
 * @Author: jiazhuang
 * @Date: 23:30 2018/6/28
 */
public class UserVO {
    private String account;
    private String mobile;
    private String eptname;
    private String name;
    private String email;
    private String eptaddress;
    private Long region;
    private Integer regType;
    private Integer orderCount;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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

    public Integer getRegType() {
        return regType;
    }

    public void setRegType(Integer regType) {
        this.regType = regType;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    @Override
    public String toString() {
        return "UserVO{" +
                "account='" + account + '\'' +
                ", mobile='" + mobile + '\'' +
                ", eptname='" + eptname + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", eptaddress='" + eptaddress + '\'' +
                ", region=" + region +
                ", regType=" + regType +
                ", orderCount=" + orderCount +
                '}';
    }
}
