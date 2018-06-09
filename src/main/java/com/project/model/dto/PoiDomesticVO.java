package com.project.model.dto;

import java.util.List;

/**
 * @Author: jiazhuang
 * @Date: 12:25 2018/6/3
 */
public class PoiDomesticVO {
    Long id;
    String name;
    Long parentId;
    List<PoiDomesticVO> children;
    boolean selectable = true;

    public PoiDomesticVO(Long id, String name, Long parentId) {
        this.id = id;
        this.name = name;
        this.parentId = parentId;
    }

    public PoiDomesticVO(Long id, String name, Long parentId, List<PoiDomesticVO> children) {
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

    public List<PoiDomesticVO> getChildren() {
        return children;
    }

    public void setChildren(List<PoiDomesticVO> children) {
        this.children = children;
    }

    public boolean isSelectable() {
        return selectable;
    }

    public void setSelectable(boolean selectable) {
        this.selectable = selectable;
    }
}
