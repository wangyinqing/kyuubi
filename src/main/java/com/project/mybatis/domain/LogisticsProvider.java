package com.project.mybatis.domain;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @Author: jiazhuang
 * @Description: 物流商
 * @Date: 16:39 2018/5/9
 */
public class LogisticsProvider implements Serializable {

    private final static long serialVersionUID = 1L;

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
        return "LogisticsProvider{" +
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
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                '}';
    }
}
