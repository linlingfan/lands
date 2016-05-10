package com.limbo.lands.service;

import com.limbo.lands.dao.LandDao;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.Land;
import com.limbo.lands.domain.PageBean;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/15.
 */
public class LandService {
    private LandDao landDao=new LandDao();

    /**
     * 查询所有的产地信息
     * @return
     */
//    public  List<Land> findAll() {
//        return landDao.findAll();
//    }

    /**
     * 查询产地所有相关的企业名称
     * @return
     */
    public List<Enterprise> findEnterpriseName(){
        return landDao.findEnterpriseName();
    }


    /**
     * 通过lid查看产地明细
     * @param lid
     * @return
     */
    public Land findByLid(String lid) {

        return landDao.findByLid(lid);
    }

    /**
     * 使用分页查询
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Land> findAllNew(int pcode, int psize) {

        try {
            return landDao.findAllNew(pcode, psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过企业名称和产地查询产地信息
     * @param landform
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Land> findByEnnameAndLname(Land landform, int pcode, int psize) {

        try {
            return landDao.findByEnnameAndLname(landform,pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
