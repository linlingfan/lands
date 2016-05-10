package com.limbo.lands.domain;

/**
 * Created by lenovo on 2016/4/17.
 *
 * 供应商
 */
public class Supplier {
    private String sid;
    private String sname;
    private int type;//供应商类型1为个人，2为单位
    private String contacts;//联系人
    private Enterprise enterprise;//所供应的企业id
    private String id_code;//身份证
    private String phone;
    private String zipcode;
    private String address;
    private int serialnum;//序列号

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
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

    public String getId_code() {
        return id_code;
    }

    public void setId_code(String id_code) {
        this.id_code = id_code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(int serialnum) {
        this.serialnum = serialnum;
    }

    @Override
    public String toString() {
        return "SupplierDao{" +
                "sid='" + sid + '\'' +
                ", sname='" + sname + '\'' +
                ", type=" + type +
                ", contacts='" + contacts + '\'' +
                ", enterprise=" + enterprise +
                ", id_code='" + id_code + '\'' +
                ", phone='" + phone + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", address='" + address + '\'' +
                ", serialnum=" + serialnum +
                '}';
    }
}
