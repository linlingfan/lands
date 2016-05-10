package com.limbo.lands.domain;

/**
 * Created by lenovo on 2016/4/17.
 */
public class Client {
    private String cl_id;
    private String clname;
    private String address;
    private String zipcode;
    private String phone;
    private int type;//类型 1为个人 2为单位
    private String contacts;
    private Enterprise enterprise;
    private int serialnum;//序列号

    public String getCl_id() {
        return cl_id;
    }

    public void setCl_id(String cl_id) {
        this.cl_id = cl_id;
    }

    public String getClname() {
        return clname;
    }

    public void setClname(String clname) {
        this.clname = clname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public int getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(int serialnum) {
        this.serialnum = serialnum;
    }

    @Override
    public String toString() {
        return "Client{" +
                "cl_id='" + cl_id + '\'' +
                ", clname='" + clname + '\'' +
                ", address='" + address + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phone='" + phone + '\'' +
                ", type=" + type +
                ", contacts='" + contacts + '\'' +
                ", enterprise=" + enterprise +
                ", serialnum=" + serialnum +
                '}';
    }
}
