package com.project.model;

/**
 * @Author: jiazhuang
 * @Date: 16:27 2018/5/10
 */
public enum UserStatusEnum {
    PENDING(0, "待审核"),
    APPROVED(1, "审核通过"),
    REJECTED(2, "审核未通过"),
    DELETED(3, "已删除");

    private int value;
    private String description;

    UserStatusEnum(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
