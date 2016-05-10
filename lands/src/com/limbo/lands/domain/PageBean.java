package com.limbo.lands.domain;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by lenovo on 2016/4/15.
 * 分页的bean
 */
public class PageBean<T> {
    private int pall;//总记录条数
    private int psize;//每一页条数
    private int precord;//总页数
    private int pcode;//当前页码
    private List<T> beanList;  //当前页的记录

    private String url;//它就是url后的条件！(按条件查询时候,要保存当前的条件信息)

    /**
     * 计算总页数
     * @return
     */
    public int getPrecord() {
        // 通过总记录数和每页记录数来计算总页数
        int precord = pall / psize;
        return pall%psize==0 ? precord : precord+1;
    }

//    public int getPrecord() {
//        return precord;
//    }

//    public void setPrecord(int precord) {
//        this.precord = precord;
//    }

    public int getPall() {
        return pall;
    }

    public void setPall(int pall) {
        this.pall = pall;
    }

    public int getPsize() {
        return psize;
    }

    public void setPsize(int psize) {
        this.psize = psize;
    }

    public int getPcode() {
        return pcode;
    }

    public void setPcode(int pcode) {
        this.pcode = pcode;
    }

    public List<T> getBeanList() {
        return beanList;
    }

    public void setBeanList(List<T> beanList) {
        this.beanList = beanList;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "pall=" + pall +
                ", psize=" + psize +
                ", precord=" + precord +
                ", pcode=" + pcode +
                ", beanList=" + beanList +
                ", url='" + url + '\'' +
                '}';
    }
}
