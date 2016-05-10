package com.limbo.lands.service;

import com.limbo.lands.dao.GroupsDao;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.Groups;

import java.util.List;

/**
 * Created by lenovo on 2016/5/6.
 */
public class GroupService {
    private GroupsDao groupsDao=new GroupsDao();

    /**
     * 查询角色分组名称和id
     * @return
     */
    public List<Groups> getG_name(){
        return groupsDao.getG_name();
    }
}
