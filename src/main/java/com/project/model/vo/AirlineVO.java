package com.project.model.vo;

/**
 * @Author: jiazhuang
 * @Date: 13:29 2018/6/10
 */
public class AirlineVO {
    private Long id;
    private String airlineName;
    private String shortName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    @Override
    public String toString() {
        return "AirlineVO{" +
                "id=" + id +
                ", airlineName='" + airlineName + '\'' +
                ", shortName='" + shortName + '\'' +
                '}';
    }
}
