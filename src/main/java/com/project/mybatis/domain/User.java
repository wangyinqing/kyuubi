package com.project.mybatis.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: jiazhuang
 * @Date: 19:13 2018/5/8
 */
public class User implements Serializable{
    private static final long serialVersionUID = 1L;

    private Long id;
    private String account;
    private String password;
    private String mobile;
    private String eptname;
    private String name;
    private String qq;
    private String email;
    private String eptaddress;
    private Long region;
    private Timestamp createTime;
    private Timestamp updateTime;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Timestamp updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", password='" + password + '\'' +
                ", mobile='" + mobile + '\'' +
                ", eptname='" + eptname + '\'' +
                ", name='" + name + '\'' +
                ", qq='" + qq + '\'' +
                ", email='" + email + '\'' +
                ", eptaddress='" + eptaddress + '\'' +
                ", region=" + region +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }

}
