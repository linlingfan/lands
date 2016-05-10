package com.limbo.lands.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.limbo.lands.domain.*;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/4/17.
 */
public class SupplierDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 查询所有供应商
     *
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Supplier> findAllSupplier(int pcode, int psize) throws SQLException {
        PageBean<Supplier> pb = new PageBean<Supplier>();
        pb.setPcode(pcode);
        pb.setPsize(psize);
        //查询总记录数返回number
        String sql = "select count(*) from supplier";
        Number number = (Number) qr.query(sql, new ScalarHandler());
        int pall = number.intValue();
        pb.setPall(pall);
        //查询product，得到product的beanList
        sql = "select * from supplier limit ?,?";
        List<Supplier> supplierList = qr.query(sql, new BeanListHandler<Supplier>(Supplier.class), (pcode - 1) * psize, psize);
        /**
         * 将加载（对象属性）land和elements里的属性值到product对象里
         * 声明一个空的Product引用 循环使用
         * 给序列号赋值
         */
        Supplier supplier = null;
        int index = (pcode - 1) * psize + 1;//设置当前页码的第一个序号
        for (int i = 0; i < supplierList.size(); i++) {
            supplier = supplierList.get(i);  //获取对当前对象的引用
            supplier.setSerialnum(index);  //设置序号
            index++;
            //将加载（对象属性）land和elements里的属性值到supplier对象里
            loadEnterprise(supplier);
        }
        pb.setBeanList(supplierList);
        return pb;
    }

    /**
     * 加载企业信息到供应商
     *
     * @param supplier
     */
    public void loadEnterprise(Supplier supplier) {
        //查询关联表enterprise信息
        String sql = "select * FROM enterprise WHERE en_id in(\n" +
                "SELECT enterprise_id from supplier where sid=?)";
        try {
            List<Enterprise> enterpriseList = qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class), supplier.getSid());
            for (Enterprise enterprise : enterpriseList) {
                supplier.setEnterprise(enterprise);  //将得到的enterprise对象里的信息存入supplier里
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 供应商明细
     *
     * @param sid
     * @return
     */
    public Supplier findBySid(String sid) {
        String sql = "select * from supplier where sid=?";
        try {
            Supplier supplier = qr.query(sql, new BeanHandler<Supplier>(Supplier.class), sid);
            loadEnterprise(supplier);
            return supplier;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 供应商多条件搜索
     *
     * @param supplierForm
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Supplier> findByEnnameAndsnameAndType(Supplier supplierForm, int pcode, int psize) throws SQLException {
        PageBean<Supplier> pb = new PageBean<Supplier>();
        pb.setPcode(pcode);
        pb.setPsize(psize);
        /**
         * 得到pall
         * 给出要拼接的sql模板（前面部分）
         * 判断条件
         */
        StringBuilder cutsql = new StringBuilder("select count(*) from supplier ");
        StringBuilder wheresql = new StringBuilder("where 1=1 ");//用来拼接
        //存放参数params
        List<Object> params = new ArrayList<Object>();
        String sname = supplierForm.getSname();
        if (sname != null && !sname.trim().isEmpty()) {
            wheresql.append("and sname like ? ");
            params.add("%" + sname + "%");
        }
        int type = supplierForm.getType();
        if (type != 0) {
            wheresql.append("and type=? ");
            params.add(type);
        }
        String en_id = supplierForm.getEnterprise().getEn_id();
        if (en_id != null && !en_id.isEmpty()) {
            wheresql.append("and enterprise_id=? ");
            params.add(en_id);
        }
        //执行cutsql语句 得到count（*）
        Number num = (Number) qr.query(cutsql.append(wheresql).toString(), new ScalarHandler(), params.toArray());
        int pall = num.intValue();
        pb.setPall(pall);

        //查询信息
        StringBuilder sql = new StringBuilder("select * from supplier ");
        //给出limit的拼接sql
        StringBuilder limitsql = new StringBuilder(" limit ?,?");
        params.add((pcode - 1) * psize);
        params.add(psize);
        List<Supplier> supplierList = qr.query(sql.append(wheresql).append(limitsql).toString(), new BeanListHandler<Supplier>(Supplier.class), params.toArray());
        Supplier supplier = null;
        //设置序号
        int index = (pcode - 1) * psize + 1;//设置当前页码的第一个序号
        for (int i = 0; i < supplierList.size(); i++) {
            supplier = supplierList.get(i);  //获取对当前对象的引用
            supplier.setSerialnum(index);  //设置序号
            index++;
            //将加载（对象属性）land和elements里的属性值到supplier对象里
            loadEnterprise(supplier);
        }
        pb.setBeanList(supplierList);
        return pb;

    }
}
