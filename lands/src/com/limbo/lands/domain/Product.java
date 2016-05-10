package com.limbo.lands.domain;

import java.util.Date;


/**
 * Created by lenovo on 2016/4/17.
 * 产品表
 */
public class Product {
    private String pid;
    private String pname;
    private Elements elements;
    private Land land;  //所属地块
    private String flag;//产品状态 正常
    private Date production_date; //出厂日期
    private String quantity;
    private int serialnum;//序列号

    public int getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(int serialnum) {
        this.serialnum = serialnum;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Elements getElements() {
        return elements;
    }

    public void setElements(Elements elements) {
        this.elements = elements;
    }

    public Land getLand() {
        return land;
    }

    public void setLand(Land land) {
        this.land = land;
    }

    public Date getProduction_date() {
        return production_date;
    }

    public void setProduction_date(Date production_date) {
        this.production_date = production_date;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "pid='" + pid + '\'' +
                ", pname='" + pname + '\'' +
                ", elements=" + elements +
                ", land=" + land +
                ", flag='" + flag + '\'' +
                ", production_date=" + production_date +
                ", quantity='" + quantity + '\'' +
                ", serialnum=" + serialnum +
                '}';
    }
}
