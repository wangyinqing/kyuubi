package com.project.model.vo;

/**
 * @Author: jiazhuang
 * @Date: 14:03 2018/6/10
 */
public class BizTypeVO {
    private int id;
    private String name;

    public BizTypeVO() {
    }

    public BizTypeVO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "BizTypeVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
