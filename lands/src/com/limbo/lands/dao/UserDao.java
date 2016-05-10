package com.limbo.lands.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.Groups;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.domain.User;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/5/6.
 */
public class UserDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 查询所有的企业员工
     *
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<User> findAllEnt(int pcode, int psize) throws SQLException {
        PageBean<User> pb = new PageBean<User>();
        pb.setPcode(pcode);
        pb.setPsize(psize);

        //设置总页数
        String sql = "select count(*) from user where group_id in ('1000000001','1000010001') ";
        Number num = (Number) qr.query(sql, new ScalarHandler());
        int pall = num.intValue();
        pb.setPall(pall);

        sql = "select * from user where group_id in ('1000000001','1000010001') limit ?,? ";
        Object[] params = {(pcode - 1) * psize, psize};
        List<User> userList = qr.query(sql, new BeanListHandler<User>(User.class), params);
        //给信息序列号赋值
        User user = null;
        int index = (pcode - 1) * psize + 1;
        for (int i = 0; i < userList.size(); i++) {
            user = userList.get(i);//获得当前引用
            loadGroupName(user);//将 用户组信息加载到user里
            loadEnterprise(user);//加载企业信息
            userList.get(i).setSerialnum(index); //设置序号
            index++;
        }
        pb.setBeanList(userList);
        return pb;
    }

    /**
     * 通过id查询用户组的组名,并加载到User里
     */
    public void loadGroupName(User user) {
        String sql = "select * from groups where gid in (select group_id from user where u_id=?)";
        try {
            Groups groups = qr.query(sql, new BeanHandler<Groups>(Groups.class), user.getU_id());
            user.setGroups(groups);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载企业信息到用户里
     *
     * @param user
     */
    public void loadEnterprise(User user) {
        //查询关联表enterprise信息
        String sql = "select * FROM enterprise WHERE en_id in(\n" +
                "SELECT enterprise_id from user where u_id=?)";
        try {
            Enterprise enterprise = qr.query(sql, new BeanHandler<Enterprise>(Enterprise.class), user.getU_id());
            user.setEnterprise(enterprise);  //将得到的enterprise对象里的信息存入supplier里
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 企业员工信息
     *
     * @param u_id
     * @return
     */
    public User findEntByU_id(String u_id) {
        String sql = "select * from user where u_id=?";
        try {
            User user = qr.query(sql, new BeanHandler<User>(User.class), u_id);
            loadGroupName(user);
            loadEnterprise(user);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 修改员工
     *
     * @param form
     */
    public void modifyEnt(User form) {
        String sql = "update user set u_name=?,u_pass=?,link_phone=?,link_email=?,link_addr=? where u_id=?";
        Object[] params = {form.getU_name(), form.getU_pass(), form.getLink_phone(),
                form.getLink_email(), form.getLink_addr(), form.getU_id()
        };
        try {
            qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除企业员工
     *
     * @param u_id
     */
    public void deleteEntById(String u_id) {

        String sql = "delete from user where u_id=?";
        try {
            qr.update(sql, u_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * 查询所有的政府人员
     *
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<User> findAllGov(int pcode, int psize) throws SQLException {
        PageBean<User> pb = new PageBean<User>();
        pb.setPcode(pcode);
        pb.setPsize(psize);
        //设置总页数
        String sql = "select count(*) from user where group_id in ('1000000000','1000020001')";
        Number num = (Number) qr.query(sql, new ScalarHandler());
        int pall = num.intValue();
        pb.setPall(pall);

        sql = "select * from user where group_id in ('1000000000','1000020001') limit ?,? ";
        Object[] params = {(pcode - 1) * psize, psize};
        List<User> userList = qr.query(sql, new BeanListHandler<User>(User.class), params);
        //给信息序列号赋值
        User user = null;
        int index = (pcode - 1) * psize + 1;
        for (int i = 0; i < userList.size(); i++) {
            user = userList.get(i);//获得当前引用
            loadGroupName(user);//将 用户组信息加载到user里
            userList.get(i).setSerialnum(index); //设置序号
            index++;
        }
        pb.setBeanList(userList);
        return pb;



    }

    /**
     * id查询政府人员信息
     * @param u_id
     * @return
     */
    public User findGovByU_id(String u_id) {
        String sql = "select * from user where u_id=?";
        try {
            User user = qr.query(sql, new BeanHandler<User>(User.class), u_id);
            loadGroupName(user);
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 修改管理员密码
     * @param u_id
     * @param newpass
     */
    public void modifyPass(String u_id, String newpass) {
        String sql="update user set u_pass=? where u_id=?";
        try {
            qr.update(sql,newpass,u_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

