package com.project.model.vo;

/**
 * @Author: jiazhuang
 * @Date: 16:00 2018/6/9
 */
public class FreightTypeVO {
    private Long id;
    private String name;
    private Integer type;

    public FreightTypeVO() {
    }

    public FreightTypeVO(Long id, String name, Integer type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "FreightTypeVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                '}';
    }
}
