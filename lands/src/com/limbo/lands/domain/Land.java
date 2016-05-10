package com.limbo.lands.domain;

/**
 * Created by lenovo on 2016/4/15.
 * 产地表
 */
public class Land {
    private String lid;
    private String lname;
    private Enterprise enterprise;  //相关联的企业
    private String description;
    private String dimensional_id;//二维码
    private String area;   //所属地区
    private String plantarea;  //种植面积
    private String position;   //位置
    private int serialnum;//序列号

    public String getLid() {
        return lid;
    }

    public void setLid(String lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensional_id() {
        return dimensional_id;
    }

    public void setDimensional_id(String dimensional_id) {
        this.dimensional_id = dimensional_id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPlantarea() {
        return plantarea;
    }

    public void setPlantarea(String plantarea) {
        this.plantarea = plantarea;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(int serialnum) {
        this.serialnum = serialnum;
    }

    @Override
    public String toString() {
        return "Land{" +
                "lid='" + lid + '\'' +
                ", lname='" + lname + '\'' +
                ", enterprise=" + enterprise +
                ", description='" + description + '\'' +
                ", dimensional_id='" + dimensional_id + '\'' +
                ", area='" + area + '\'' +
                ", plantarea='" + plantarea + '\'' +
                ", position='" + position + '\'' +
                ", serialnum=" + serialnum +
                '}';
    }
}
