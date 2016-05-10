package com.limbo.lands.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/4/18.
 */
public class EnterpriseDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 得到所有的企业名称（顺便都保存在list里）
     *
     * @return
     */
    public List<Enterprise> getEnname() {
        String sql = "select * from enterprise";
        // List<Enterprise> enterpriseList = new ArrayList<Enterprise>();
        try {
            return qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 查询供货企业信息
     *
     * @return
     */
    public PageBean<Enterprise> findEnterpriseByFlag(int pcode, int psize) throws SQLException {
        PageBean<Enterprise> pb = new PageBean<Enterprise>();
        pb.setPcode(pcode);
        pb.setPsize(psize);
        //获取pall
        String sql = "select count(*) from enterprise where flag!=4";
        Number num = (Number) qr.query(sql, new ScalarHandler());
        int pall = num.intValue();
        pb.setPall(pall);

        sql = "select * from enterprise where flag!=4 limit ?,?";
        Object[] params = {(pcode - 1) * psize, psize};
        List<Enterprise> enterpriseList = qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class), params);
        //设置序号
        int index = (pcode - 1) * psize + 1; //当前页的序号
        for (Enterprise enterprise : enterpriseList) {
            enterprise.setSerialnum(index);
            index++;
        }
        pb.setBeanList(enterpriseList);
        return pb;
    }

    /**
     * 通过名字enname查询企业
     *
     * @param enname
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Enterprise> findEnterpriseByEnname(String enname, int pcode, int psize) throws SQLException {
        PageBean<Enterprise> pb = new PageBean<Enterprise>();
        pb.setPcode(pcode);
        pb.setPsize(psize);
        //获取pall
        String sql = "select count(*) from enterprise where flag!=4 and enname like ?";
        Number num = (Number) qr.query(sql, new ScalarHandler(), enname + "%");
        int pall = num.intValue();
        pb.setPall(pall);

        sql = "select * from enterprise where flag!=4 and enname like ? limit ?,?";
        Object[] params = {enname + "%", (pcode - 1) * psize, psize};
        List<Enterprise> enterpriseList = qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class), params);
        //设置序号
        int index = (pcode - 1) * psize + 1; //当前页的序号
        for (Enterprise enterprise : enterpriseList) {
            enterprise.setSerialnum(index);
            index++;
        }
        pb.setBeanList(enterpriseList);

        return pb;
    }

    /**
     * 企业明细
     *
     * @param en_id
     * @return
     */
    public Enterprise findDetailByEn_id(String en_id) {
        String sql = "select * from enterprise where en_id=?";
        try {
            Enterprise enterprise = qr.query(sql, new BeanHandler<Enterprise>(Enterprise.class), en_id);
            System.out.println(enterprise);
            return enterprise;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 修改企业信息
     *
     * @param form
     * @return
     */
    public Enterprise modifyEnterprise(Enterprise form) {
        String sql = "update enterprise " +
                "set enname=?,contacts=?,phone=?,zipcode=?,address=?,description=? where en_id=?";
        Object[] params = {form.getEnname(), form.getContacts(), form.getPhone(),
                form.getZipcode(), form.getAddress(), form.getDescription(), form.getEn_id()};
        try {
            qr.update(sql, params);
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    /**
     * 修改企业状态
     *
     * @param en_id
     * @param flag
     * @return
     */
    public Enterprise changeFlag(String en_id, int flag) {
        String sql = "update enterprise set flag=? where en_id=?";
        try {
            qr.update(sql,flag,en_id);
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
