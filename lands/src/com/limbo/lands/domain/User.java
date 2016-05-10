package com.limbo.lands.domain;

import java.util.Date;

/**
 * Created by lenovo on 2016/4/21.
 * 用户表管理员和企业员工
 */
public class User {
    private String u_id;
    private Groups groups;  //所属角色组
    private String account;
    private String u_pass;
    private String u_name;
    private String link_phone;
    private String link_addr;
    private String link_email;
    private Date add_date;
    private String creator;
    private Enterprise enterprise;
    private int serialnum;//序号

    public String getU_id() {
        return u_id;
    }

    public void setU_id(String u_id) {
        this.u_id = u_id;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getU_pass() {
        return u_pass;
    }

    public void setU_pass(String u_pass) {
        this.u_pass = u_pass;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getLink_phone() {
        return link_phone;
    }

    public void setLink_phone(String link_phone) {
        this.link_phone = link_phone;
    }

    public String getLink_addr() {
        return link_addr;
    }

    public void setLink_addr(String link_addr) {
        this.link_addr = link_addr;
    }

    public String getLink_email() {
        return link_email;
    }

    public void setLink_email(String link_email) {
        this.link_email = link_email;
    }

    public Date getAdd_date() {
        return add_date;
    }

    public void setAdd_date(Date add_date) {
        this.add_date = add_date;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
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
        return "User{" +
                "u_id='" + u_id + '\'' +
                ", groups=" + groups +
                ", account='" + account + '\'' +
                ", u_pass='" + u_pass + '\'' +
                ", u_name='" + u_name + '\'' +
                ", link_phone='" + link_phone + '\'' +
                ", link_addr='" + link_addr + '\'' +
                ", link_email='" + link_email + '\'' +
                ", add_date=" + add_date +
                ", creator='" + creator + '\'' +
                ", enterprise=" + enterprise +
                ", serialnum=" + serialnum +
                '}';
    }
}
