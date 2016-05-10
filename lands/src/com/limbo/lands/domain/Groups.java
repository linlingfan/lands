package com.limbo.lands.domain;

/**
 * Created by lenovo on 2016/5/6.
 * 所属角色组
 */
public class Groups {
    private String gid;
    private String g_name;

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    @Override
    public String toString() {
        return "GroupsDao{" +
                "gid='" + gid + '\'' +
                ", g_name='" + g_name + '\'' +
                '}';
    }
}
