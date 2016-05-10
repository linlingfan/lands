package com.limbo.lands.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.limbo.lands.domain.*;
import com.sun.istack.internal.NotNull;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/21.
 */
public class UnionDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 查询协会
     *
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Union> findAllUnion(int pcode, int psize) throws SQLException {
        PageBean<Union> pb = new PageBean<Union>();
        pb.setPcode(pcode);
        pb.setPsize(psize);

        String sql = "select count(*) from unions";
        Number num = (Number) qr.query(sql, new ScalarHandler());
        int pall = num.intValue();
        pb.setPall(pall);

        sql = "select * from unions limit ?,?";
        Object[] params = {(pcode - 1) * psize, psize};
        List<Union> unionList = qr.query(sql, new BeanListHandler<Union>(Union.class), params);
        //给信息序列号赋值
        //Union union=null;
        int index = (pcode - 1) * psize + 1;
        for (int i = 0; i < unionList.size(); i++) {
            unionList.get(i).setSerialnum(index);
            index++;
        }
        pb.setBeanList(unionList);
        return pb;
    }

    public PageBean<Union> searchByUnname(String unname, int pcode, int psize) throws SQLException {
        PageBean<Union> pb = new PageBean<Union>();
        pb.setPcode(pcode);
        pb.setPsize(psize);

        String sql = "select count(*) from unions where unname like ?";
        Number num = (Number) qr.query(sql, new ScalarHandler(), unname + "%");
        int pall = num.intValue();
        pb.setPall(pall);

        sql = "select * from unions where unname like ? limit ?,?";
        Object[] params = {unname + "%", (pcode - 1) * psize, psize};
        List<Union> unionList = qr.query(sql, new BeanListHandler<Union>(Union.class), params);
        //设置序号
        int index = (pcode - 1) * psize + 1;
        for (int i = 0; i < unionList.size(); i++) {
            unionList.get(i).setSerialnum(index);
            index++;
        }
        pb.setBeanList(unionList);
        return pb;
    }

    /**
     * 通过u_id查询协会
     *
     * @param u_id
     * @return
     */

    public Union findByU_id(String u_id) throws SQLException {
        /**
         * 通过u_id查询union
         * 在查询在e_union表里的该u_id关联的企业id
         * 查询对应企业id的企业信息
         * 将信息保存到Union的e_union属性里
         */
        String sql = "select * from unions where u_id=?";
        Union union = qr.query(sql, new BeanHandler<Union>(Union.class), u_id);
        union.setE_unionList(loadEnterpriseToE_union(union));
        return union;
    }

    /**
     * 加载所有关联的企业信息到e_union中并且set到union对象里
     *
     * @param
     */
    public List<E_union> loadEnterpriseToE_union(Union union) {
        //查询enterprise信息 关联land
        String sql1 = "select * from e_union where u_id=?";
        String sql = "select * FROM enterprise where en_id in (select en_id from e_union where u_id=?)";
        try {
            List<E_union> e_unionList = qr.query(sql1, new BeanListHandler<E_union>(E_union.class), union.getU_id());
            Enterprise enterprise = null;
            List<Enterprise> enterpriseList = qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class), union.getU_id());
            for (int i = 0; i < e_unionList.size(); i++) {
                enterprise = enterpriseList.get(i);
                enterprise.setSerialnum(i + 1);  //设置序号
//                System.out.println(enterprise);
                //将enterpriseList的enterprise对象信息放到e_unionList的e_union属性对象里（不能直接使用上面的引用的e_union空对象会空指针异常）
                e_unionList.get(i).setEnterprise(enterprise);
            }

            return e_unionList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 会员具体信息
     *
     * @param u_id
     * @param en_id
     * @return
     */
    public E_union findEn_UnDetail(String u_id, String en_id) {

        String sql1 = "select * from enterprise where en_id=?";
        String sql2 = "select * from e_union where u_id=? and en_id=?";
        try {
            Enterprise enterprise = qr.query(sql1, new BeanHandler<Enterprise>(Enterprise.class), en_id);
            E_union e_union = qr.query(sql2,new BeanHandler<E_union>(E_union.class),u_id,en_id);
            e_union.setEnterprise(enterprise);
            return e_union;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 修改审核状态（或审核）
     * @param e_union
     * @param u_id
     * @param en_id
     */
    public void changeState(E_union e_union, String u_id, String en_id) {
        String sql="update e_union set state=?,idea=? where u_id=? and en_id=?";
        Object []parems={e_union.getState(),e_union.getIdea(),u_id,en_id};
        try {
            qr.update(sql,parems);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 吉奥在要修改的协会信息
     * @param u_id
     * @return
     */
    public Union loadModifyUnion(String u_id) {
        String sql="select * from unions where u_id=?";
        try {
            Union union=qr.query(sql,new BeanHandler<Union>(Union.class),u_id);
            return union;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 修改协会信息
     * @param form
     */
    public void modifyUnion(Union form) {
        String sql="update unions set unname=?,address=?,contacts=?,phone=? where u_id=?";
        Object []params={form.getUnname(),form.getAddress(),form.getContacts(),form.getPhone(),form.getU_id()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * 添加协会
     * @param form
     */
    public void addUnion(Union form) {
        String sql ="insert into unions(unname,address,contacts,phone,u_id) values(?,?,?,?,?)";
        Object []params={form.getUnname(),form.getAddress(),form.getContacts(),form.getPhone(),form.getU_id()};
        try {
            qr.update(sql,params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除协会
     * 关联表相应数据也应删除
     * @param u_id
     */
    public void deleteUnion(String u_id) {
        String sql1="delete from unions where u_id=?";
        String sql2="delete from e_union where u_id=?";
        try {
            qr.update(sql2,u_id);
            qr.update(sql1,u_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 删除会员
     * @param en_id
     */
    public void deleteEnterprise(String en_id) {
        String sql="delete from e_union where en_id=?";
        try {
            qr.update(sql,en_id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
