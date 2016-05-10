package com.limbo.lands.service;

import com.limbo.lands.dao.EnterpriseDao;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/18.
 */
public class EnterpriseService {
    private EnterpriseDao enterpriseDao=new EnterpriseDao();

    public List<Enterprise> getEnname(){
        return enterpriseDao.getEnname();
    }

    /**
     * 查询供货企业信息（去掉注销状态）
     *
     * @return
     */
    public PageBean<Enterprise> findEnterpriseByFlag(int pcode,int psize) {

        try {
            return  enterpriseDao.findEnterpriseByFlag(pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 通过enname查询企业
     * @param enname
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Enterprise> findEnterpriseByEnname(String enname, int pcode, int psize) {
        try {
            return enterpriseDao.findEnterpriseByEnname(enname,pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 查询企业明细
     * @param en_id
     * @return
     */
    public Enterprise findDetailByEn_id(String en_id) {
        return enterpriseDao.findDetailByEn_id(en_id);

    }

    /**
     * 修改企业信息
     * @param form
     * @return
     */
    public Enterprise modifyEnterprise(Enterprise form) {
        return enterpriseDao.modifyEnterprise(form);
    }

    /**
     * 修改供货企业的状态
     * @param en_id
     * @param flag
     * @return
     */
    public Enterprise changeFlag(String en_id, int flag) {

        return enterpriseDao.changeFlag(en_id,flag);
    }
}
