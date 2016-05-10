package com.limbo.lands.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.Land;
import com.limbo.lands.domain.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/15.
 * <p/>
 * 地产管理的dao层
 */
public class LandDao {
    private QueryRunner qr = new TxQueryRunner();

//    /**
//     * 查询所有的产地
//     *
//     * @return
//     */
//    public List<Land> findAll() {
//
//        String sql = "select * from land";
//        List<Land> landList = null;
//        Land land = null;  //声明一个空引用，在循环里使用
//        try {
//            landList = qr.query(sql, new BeanListHandler<Land>(Land.class));
//            //存入序列号 和设置所属企业
//            for (int i = 0; i < landList.size(); i++) {
//                land = landList.get(i);  //获取对当前对象的引用
//                land.setSerialnum(i + 1);
//                //获取每个地名对应关联的企业名字
//                loadEnterprise(land);
//            }
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//        return landList;
//    }

    /**
     * 加载Enterprise信息并set到land对象里
     *
     * @param land
     */
    public void loadEnterprise(Land land) {
        //查询enterprise信息 关联land
        String sql = "select * FROM enterprise WHERE en_id in(\n" +
                "SELECT enterprise_id from land where lid=?)";
        try {
            List<Enterprise> enterpriseList = qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class), land.getLid());
            for (Enterprise enterprise : enterpriseList) {
                land.setEnterprise(enterprise);  //将得到的enterprise对象里的信息存入land里
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 在land中查询企业名称（去重）
     */
    public List<Enterprise> findEnterpriseName() {
        String sql = " SELECT DISTINCT enname ,en_id FROM enterprise WHERE en_id in (\n" +
                "SELECT enterprise_id FROM land )";
        try {
            List<Enterprise> landEnnameList = qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class));
            return landEnnameList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

//    /**
//     * 通过企业名称(id)和产地名称查询产地信息
//     * (产地名称不为空时)
//     *
//     * @return
//     */
//    public List<Land> findByEnnameAndLname(String en_id, String landname) throws SQLException {
//
//        String sql = "SELECT * FROM land where enterprise_id=? and lname like ?";
//        landname = landname + '%';  //模糊查询
//        Object[] params = {en_id, landname};
//        System.out.println(landname);
//        List<Land> landList = qr.query(sql, new BeanListHandler<Land>(Land.class), params);
//        System.out.println(landList);
//        //将序号和企业名赋值进去
//        Land land = null;
//        for (int i = 0; i < landList.size(); i++) {
//            land = landList.get(i);  //获取对当前对象的引用
//            land.setSerialnum(i + 1);
//            loadEnterprise(land);
//        }
//        return landList;
//    }
//
//    /**
//     * 通过企业名称和产地名称查询产地信息
//     * (产地名称为空时)
//     *
//     * @return
//     */
//    public List<Land> findByEnname(String en_id) throws SQLException {
//        String sql = "SELECT * FROM land where enterprise_id=?";
//        Object[] params = {en_id};
//        List<Land> landList = qr.query(sql, new BeanListHandler<Land>(Land.class), params);
//        //将序号和企业名赋值进去
//        Land land = null;
//        for (int i = 0; i < landList.size(); i++) {
//            land = landList.get(i);  //获取对当前对象的引用
//            land.setSerialnum(i + 1);
//            loadEnterprise(land);
//        }
//        return landList;
//    }

    /**
     * 通过lid查询产地明细
     *
     * @param lid
     * @return
     */
    public Land findByLid(String lid) {
        String sql = "select * from land where lid=?";
        try {
            Land land = (Land) qr.query(sql, new BeanHandler<Land>(Land.class), lid);
            return land;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 使用分页查询
     *
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Land> findAllNew(int pcode, int psize) throws SQLException {
        /*
         *得到PageBean对象pageBean
         * 设置pcode和psize
         * 得到pall总记录数
         * 计算总页数precord
         * 得到land的beanList
         * 返回pageBean
         */
        PageBean<Land> pageBean = new PageBean<Land>();
        pageBean.setPcode(pcode);
        pageBean.setPsize(psize);

        //查询总的记录数  返回number
        String sql = "select count(*)from land";
        Number num = (Number) qr.query(sql, new ScalarHandler());
        int pall = num.intValue();
        pageBean.setPall(pall);
//        // 计算总页数precord
//        int precord;
//        if (pall / 10 > 0 || pall % 10 > 0) {
//            precord = pall / 10 + 1;
//        } else if (pall / 10 == 0 || pall % 10 == 0) {
//            precord = 1;
//        } else {
//            precord = pall / 10;
//        }
//        pageBean.setPrecord(precord);

        //得到land的BeanList
        sql = "select * from land limit ?,?";
        Object[] params = {(pcode - 1) * psize, psize};
        List<Land> landBeanList = qr.query(sql, new BeanListHandler<Land>(Land.class), params);
        //存入序列号 和设置所属企业
        Land land = null;  //声明一个空引用，在循环里使用
        int index = (pcode - 1) * psize + 1; //设置当前页码第一个序号
        for (int i = 0; i < landBeanList.size(); i++) {
            land = landBeanList.get(i);  //获取对当前对象的引用
            land.setSerialnum(index);
            index++;
            //获取每个地名对应关联的企业名字
            loadEnterprise(land);
        }
        pageBean.setBeanList(landBeanList);
        return pageBean;
    }

    /**
     * 通过企业名称（企业id）和产地名称查询产地信息
     *
     * @param landform
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Land> findByEnnameAndLname(Land landform, int pcode, int psize) throws SQLException {
        PageBean<Land> pageBean = new PageBean<Land>();
        pageBean.setPcode(pcode);
        pageBean.setPsize(psize);
        /**
         * 判断lname是否为空调用不同的sql语句
         */
        String sql = null;
        if (landform.getLname() == null || landform.getLname().trim().isEmpty()) {
            //查询总的记录数  返回number
            sql = "select count(*)FROM land where enterprise_id=?";
            Object[]params={landform.getEnterprise().getEn_id()};
            Number num = (Number) qr.query(sql, new ScalarHandler(),params);
            int pall = num.intValue();
            pageBean.setPall(pall);
//            // 计算总页数precord
//            int precord;
//            if (pall / 10 > 0 || pall % 10 > 0) {
//                precord = pall / 10 + 1;
//            } else if (pall / 10 == 0 || pall % 10 == 0) {
//                precord = 1;
//            } else {
//                precord = pall / 10;
//            }
//            pageBean.setPrecord(precord);
            //查询记录
            sql = "SELECT * FROM land where enterprise_id=? limit ?,?";
            Object[] params2 = {landform.getEnterprise().getEn_id(), (pcode - 1) * psize, psize};
            List<Land> landBeanList = qr.query(sql, new BeanListHandler<Land>(Land.class), params2);
            //存入序列号 和设置所属企业
            Land land = null;  //声明一个空引用，在循环里使用
            int index = (pcode - 1) * psize + 1; //设置当前页码第一个序号
            for (int i = 0; i < landBeanList.size(); i++) {
                land = landBeanList.get(i);  //获取对当前对象的引用
                land.setSerialnum(index);
                index++;
                //获取每个地名对应关联的企业名字
                loadEnterprise(land);
            }
            pageBean.setBeanList(landBeanList);
            System.out.println(pageBean);
            return pageBean;

        } else {
            //查询总的记录数  返回number
            sql = "select count(*)FROM land where enterprise_id=? and lname like ?";
            Object[]params={landform.getEnterprise().getEn_id(),landform.getLname()+'%'};
            Number num = (Number) qr.query(sql, new ScalarHandler(),params);
            int pall = num.intValue();
            pageBean.setPall(pall);
//            // 计算总页数precord
//            int precord;
//            if (pall / 10 > 0 || pall % 10 > 0) {
//                precord = pall / 10 + 1;
//            } else if (pall / 10 == 0 || pall % 10 == 0) {
//                precord = 1;
//            } else {
//                precord = pall / 10;
//            }
//            pageBean.setPrecord(precord);
            //查询记录
            sql = "SELECT * FROM land where enterprise_id=? and lname like ? limit ?,?";
            Object[] params2 = {landform.getEnterprise().getEn_id(),landform.getLname()+ '%',(pcode - 1) * psize, psize};
            List<Land> landBeanList = qr.query(sql, new BeanListHandler<Land>(Land.class), params2);
            //存入序列号 和设置所属企业
            Land land = null;  //声明一个空引用，在循环里使用
            int index = (pcode - 1) * psize + 1; //设置当前页码第一个序号
            for (int i = 0; i < landBeanList.size(); i++) {
                land = landBeanList.get(i);  //获取对当前对象的引用
                land.setSerialnum(index);
                index++;
                //获取每个地名对应关联的企业名字
                loadEnterprise(land);
            }
            pageBean.setBeanList(landBeanList);
            return pageBean;
        }
    }

}
