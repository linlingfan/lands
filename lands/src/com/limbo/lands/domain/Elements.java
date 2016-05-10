package com.limbo.lands.domain;

/**
 * Created by lenovo on 2016/4/17.
 *
 * 根元素表（溯源操作和产品类型）
 */
public class Elements {
    private String el_id;
    private String elname;
    private String description;
    private String belongid;
    private String type;
    private String f8;
    private String f9;
    private String f10;

    public String getEl_id() {
        return el_id;
    }

    public void setEl_id(String el_id) {
        this.el_id = el_id;
    }

    public String getElname() {
        return elname;
    }

    public void setElname(String elname) {
        this.elname = elname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBelongid() {
        return belongid;
    }

    public void setBelongid(String belongid) {
        this.belongid = belongid;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getF8() {
        return f8;
    }

    public void setF8(String f8) {
        this.f8 = f8;
    }

    public String getF9() {
        return f9;
    }

    public void setF9(String f9) {
        this.f9 = f9;
    }

    public String getF10() {
        return f10;
    }

    public void setF10(String f10) {
        this.f10 = f10;
    }

    @Override
    public String toString() {
        return "Elements{" +
                "el_id='" + el_id + '\'' +
                ", elname='" + elname + '\'' +
                ", description='" + description + '\'' +
                ", belongid='" + belongid + '\'' +
                ", type='" + type + '\'' +
                ", f8='" + f8 + '\'' +
                ", f9='" + f9 + '\'' +
                ", f10='" + f10 + '\'' +
                '}';
    }
}
