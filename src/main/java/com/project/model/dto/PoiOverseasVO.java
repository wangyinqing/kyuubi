package com.project.model.dto;

/**
 * @Author: jiazhuang
 * @Date: 16:18 2018/6/3
 */
public class PoiOverseasVO {
    private Long id;
    private String name;
    private String shortName;
    private Integer businessType;
    boolean selectable = true;

    public PoiOverseasVO(Long id, String name, String shortName) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
    }

    public PoiOverseasVO(Long id, String name, String shortName, Integer businessType) {
        this.id = id;
        this.name = name;
        this.shortName = shortName;
        this.businessType = businessType;
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

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public Integer getBusinessType() {
        return businessType;
    }

    public void setBusinessType(Integer businessType) {
        this.businessType = businessType;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }

    @Override
    public String toString() {
        return "PoiOverseasVO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", shortName='" + shortName + '\'' +
                ", businessType=" + businessType +
                ", selectable=" + selectable +
                '}';
    }
}
