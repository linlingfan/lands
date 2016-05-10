package com.limbo.lands.service;

import com.limbo.lands.dao.UserDao;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.domain.User;

import java.sql.SQLException;

/**
 * Created by lenovo on 2016/5/6.
 */
public class UserService {
    private UserDao userDao=new UserDao();

    /**
     * 查询所有的企业员工
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<User> findAllEnt(int pcode, int psize) {
        try {
            return userDao.findAllEnt(pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查看企业员工信息
     * @param u_id
     * @return
     */
    public User findEntByU_id(String u_id) {
        return userDao.findEntByU_id(u_id);
    }

    /**
     * 修改员工
     * @param form
     */
    public void modifyEnt(User form) {
        userDao.modifyEnt(form);
    }

    /**
     * 删除员工
     * @param u_id
     */
    public void deleteEntById(String u_id) {
        userDao.deleteEntById(u_id);
    }

    /**
     * 政府人员
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<User> findAllGov(int pcode, int psize) {
        try {
            return userDao.findAllGov(pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 通过id查询政府人员信息
     * @param u_id
     * @return
     */
    public User findGovByU_id(String u_id) {
        return userDao.findGovByU_id(u_id);
    }

    /**
     * 修改管理员密码
     * @param u_id
     * @param newpass
     */
    public void modifyPass(String u_id, String newpass) {
        userDao.modifyPass(u_id,newpass);
    }
}
