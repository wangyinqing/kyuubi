package com.project.model.dto;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 12:25 2018/6/3
 */
public class PoiDomesticEntity {
    Long id;
    String name;
    Long parentId;
    List<PoiDomesticEntity> children;
    boolean selectable = true;

    public PoiDomesticEntity(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public PoiDomesticEntity(Long id, String name, Long parentId, List<PoiDomesticEntity> children) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
        this.children = children;
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

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public List<PoiDomesticEntity> getChildren() {
        return children;
    }

    public void setChildren(List<PoiDomesticEntity> children) {
        this.children = children;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }
}
