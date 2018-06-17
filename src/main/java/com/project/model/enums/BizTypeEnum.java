package com.project.model.enums;

public enum BizTypeEnum {
    FBA(1, "FBA"),
    NORMAL(2, "大宗普货");

    private int value;
    private String name;

    BizTypeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }

    public static String getNameByValue(int value) {
        for (BizTypeEnum item : BizTypeEnum.values()) {
            if (value == item.getValue()) {
                return item.getName();
            }
        }
        return null;
    }
}
