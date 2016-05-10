package com.limbo.lands.service;

import com.limbo.lands.dao.UnionDao;
import com.limbo.lands.domain.E_union;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.domain.Union;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/21.
 */
public class UnionService {
    private UnionDao unionDao=new UnionDao();

    /**
     * 查询协会
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Union> findAllUnion(int pcode, int psize) {
        try {
            return  unionDao.findAllUnion(pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过协会名查询
     * @param unname
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Union> searchByUnname(String unname, int pcode, int psize){
        try {
            return unionDao.searchByUnname(unname,pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过u_id查询协会信息和该协会的会员信息
     * @param u_id
     * @return
     */
    public Union findByU_id(String u_id) {

        try {
            return unionDao.findByU_id(u_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public E_union findEn_UnDetail(String u_id, String en_id) {

        return unionDao.findEn_UnDetail(u_id,en_id);
    }

    /**
     * 审核状态
     * @param e_union
     * @param u_id
     * @param en_id
     */
    public void changeState(E_union e_union, String u_id, String en_id) {
        unionDao.changeState(e_union,u_id,en_id);
    }

    /**
     * 加载修改的协会信息到页面
     * @param u_id
     * @return
     */
    public Union loadModifyUnion(String u_id) {
        return unionDao.loadModifyUnion(u_id);
    }

    /**
     * 修改协会信息
     * @param form
     */
    public void modifyUnion(Union form) {
        unionDao.modifyUnion(form);

    }

    /**
     * 添加协会
     * @param form
     */
    public void addUnion(Union form) {
        unionDao.addUnion(form);
    }

    /**
     * 删除协会
     * @param u_id
     */
    public void deleteUnion(String u_id) {
        unionDao.deleteUnion(u_id);
    }

    /**
     * 删除会员
     * @param en_id
     */
    public void deleteEnterprise(String en_id) {
        unionDao.deleteEnterprise(en_id);
    }
}
