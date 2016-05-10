package com.limbo.lands.domain;

import java.util.List;

/**
 * Created by lenovo on 2016/4/21.
 * 多对多关系表（企业和协会）
 */
public class E_union {
    private int id;
    private Union union;
    private Enterprise enterprise;
    private int state;//审核状态1.为审核通过，2为正在申请，3审核不通过
    private String idea;//审核意见

    public String getIdea() {
        return idea;
    }

    public void setIdea(String idea) {
        this.idea = idea;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Union getUnion() {
        return union;
    }

    public void setUnion(Union union) {
        this.union = union;
    }

    public Enterprise getEnterprise() {
        return enterprise;
    }

    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "E_union{" +
                "id=" + id +
                ", union=" + union +
                ", enterprise=" + enterprise +
                ", state=" + state +
                ", idea='" + idea + '\'' +
                '}';
    }
}

