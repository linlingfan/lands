package com.limbo.lands.domain;

/**
 * Created by lenovo on 2016/4/15.
 * 企业表
 */
public class Enterprise {
    private String en_id;
    private String enname;
    private String address;
    private String contacts; //法人代表
    private String phone;
    private int flag;//标记供货状态 2正常，3暂停，4注销   审核状态 2为审核通过，3为没通过，4正在申请
    private String zipcode;//邮编
    private String description;
    private String audit_desc;//审核具体情况
    private String ba_certificate_code;//工商登记号
    private String tax_certificate_code; //税务登记号
    private String qs_code;//qs食品安全认证
    private String tax_amount;//年缴税金额
    private String tea_land_area;//茶园面积
    private int serialnum;//序列号

    public int getSerialnum() {
        return serialnum;
    }

    public void setSerialnum(int serialnum) {
        this.serialnum = serialnum;
    }

    public String getEn_id() {
        return en_id;
    }

    public void setEn_id(String en_id) {
        this.en_id = en_id;
    }

    public String getEnname() {
        return enname;
    }

    public void setEnname(String enname) {
        this.enname = enname;
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

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAudit_desc() {
        return audit_desc;
    }

    public void setAudit_desc(String audit_desc) {
        this.audit_desc = audit_desc;
    }

    public String getBa_certificate_code() {
        return ba_certificate_code;
    }

    public void setBa_certificate_code(String ba_certificate_code) {
        this.ba_certificate_code = ba_certificate_code;
    }

    public String getTax_certificate_code() {
        return tax_certificate_code;
    }

    public void setTax_certificate_code(String tax_certificate_code) {
        this.tax_certificate_code = tax_certificate_code;
    }

    public String getQs_code() {
        return qs_code;
    }

    public void setQs_code(String qs_code) {
        this.qs_code = qs_code;
    }

    public String getTax_amount() {
        return tax_amount;
    }

    public void setTax_amount(String tax_amount) {
        this.tax_amount = tax_amount;
    }

    public String getTea_land_area() {
        return tea_land_area;
    }

    public void setTea_land_area(String tea_land_area) {
        this.tea_land_area = tea_land_area;
    }

    @Override
    public String toString() {
        return "EnterpriseDao{" +
                "en_id='" + en_id + '\'' +
                ", enname='" + enname + '\'' +
                ", address='" + address + '\'' +
                ", contacts='" + contacts + '\'' +
                ", phone='" + phone + '\'' +
                ", flag=" + flag +
                ", zipcode='" + zipcode + '\'' +
                ", description='" + description + '\'' +
                ", audit_desc='" + audit_desc + '\'' +
                ", ba_certificate_code='" + ba_certificate_code + '\'' +
                ", tax_certificate_code='" + tax_certificate_code + '\'' +
                ", qs_code='" + qs_code + '\'' +
                ", tax_amount='" + tax_amount + '\'' +
                ", tea_land_area='" + tea_land_area + '\'' +
                '}';
    }
}
