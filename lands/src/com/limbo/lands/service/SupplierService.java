package com.limbo.lands.service;

import com.limbo.lands.dao.SupplierDao;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.domain.Supplier;

import java.sql.SQLException;

/**
 * Created by lenovo on 2016/4/17.
 */
public class SupplierService {
    private SupplierDao supplierDao=new SupplierDao();

    public PageBean<Supplier> findAllSupplier(int pcode, int psize) {

        try {
            return supplierDao.findAllSupplier(pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Supplier findBySid(String sid) {

        return supplierDao.findBySid(sid);
    }

    /**
     * 供应商多条件搜索
     * @param supplierForm
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Supplier> findByEnnameAndsnameAndType(Supplier supplierForm, int pcode, int psize) {

        try {
            return  supplierDao.findByEnnameAndsnameAndType(supplierForm,pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
