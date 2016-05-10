package com.limbo.lands.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.limbo.lands.domain.Groups;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/5/6.
 */
public class GroupsDao {
    private QueryRunner qr=new TxQueryRunner();

    /**
     * 获取角色分组的名称和id
     * @return
     */
    public List<Groups> getG_name() {
        String sql = "select * from groups";
        try {
            return qr.query(sql, new BeanListHandler<Groups>(Groups.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
