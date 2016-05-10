package com.limbo.lands.domain;

import java.util.List;

/**
 * Created by lenovo on 2016/4/21.
 * 协会表
 */
public class Union {
    private String unname;
    private String address;
    private String contacts;
    private String phone;
    private int serialnum;//序列号
    private String u_id;
    private List<E_union> e_unionList;//关系表  属性

    public List<E_union> getE_unionList() {
        return e_unionList;
    }

    public void setE_unionList(List<E_union> e_unionList) {
        this.e_unionList = e_unionList;
    }

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public String getUnname() {
        return unname;
    }

    public void setUnname(String unname) {
        this.unname = unname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(int serialnum) {
        this.serialnum = serialnum;
    }

    @Override
    public String toString() {
        return "Union{" +
                "unname='" + unname + '\'' +
                ", address='" + address + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", serialnum=" + serialnum +
                ", u_id='" + u_id + '\'' +
                ", e_unionList=" + e_unionList +
                '}';
    }
}
