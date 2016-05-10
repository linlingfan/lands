package com.limbo.lands.service;

import com.limbo.lands.dao.ProductDao;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.domain.Product;

import java.sql.SQLException;

/**
 * Created by lenovo on 2016/4/17.
 */
public class ProductService {
    private ProductDao productDao=new ProductDao();

    /**
     * 查询产品
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Product> findAllProduct(int pcode, int psize) {
        try {
            return productDao.findAllProduct(pcode,psize);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 通过产品名称查询
     * @param pcode
     * @param psize
     * @param pname
     * @return
     */
    public PageBean<Product> findProductByPname(int pcode, int psize, String pname) {
        try {
            return productDao.findProductByPname(pcode, psize, pname);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 产品明细
     * @param pid
     * @return
     */
    public Product findByPid(String pid) {

        try {
            return productDao.findByPid(pid);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
