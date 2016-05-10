package com.limbo.lands.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.limbo.lands.domain.Client;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.PageBean;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import javax.lang.model.element.Element;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/4/17.
 */
public class ClientDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 查询客户信息
     *
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Client> findAllClient(int pcode, int psize) throws SQLException {
        PageBean<Client> pb = new PageBean<Client>();
        pb.setPcode(pcode);
        pb.setPsize(psize);

        //获取pall总条数
        String sql = "select count(*) from client";
        Number num = (Number) qr.query(sql, new ScalarHandler());
        int pall = num.intValue();
        pb.setPall(pall);
        //获取客户信息
        sql = "select * from client limit ?,?";
        List<Client> clientList = qr.query(sql, new BeanListHandler<Client>(Client.class), (pcode - 1) * psize, psize);
        //为Client里的enterprise对象赋值
        Client client = null;//空引用
        int index = psize * (pcode - 1) + 1;//当前页码第一个序号
        for (int i = 0; i < clientList.size(); i++) {
            client = clientList.get(i);
            client.setSerialnum(index);
            index++;
            loadEnterprise(client);
        }
        pb.setBeanList(clientList);
        return pb;
    }

    /**
     * 加载企业信息
     *
     * @param client
     */
    public void loadEnterprise(Client client) {
        //查询关联表enterprise信息
        String sql = "select * FROM enterprise WHERE en_id in(\n" +
                "SELECT enterprise_id from client where cl_id=?)";
        try {
            List<Enterprise> enterpriseList = qr.query(sql, new BeanListHandler<Enterprise>(Enterprise.class), client.getCl_id());
            for (Enterprise enterprise : enterpriseList) {
                client.setEnterprise(enterprise);  //将得到的enterprise对象里的信息存入supplier里
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 条件查询客户信息
     *
     * @param pcode
     * @param psize
     * @param en_id
     * @param clname
     * @return
     */
    public PageBean<Client> findClientByClnameAndEnname(int pcode, int psize, String en_id, String clname) throws SQLException {
        PageBean<Client> pb = new PageBean<Client>();
        pb.setPcode(pcode);
        pb.setPsize(psize);

        /**
         * 创建拼接cutsql的模板
         * 多条件查询
         */
        StringBuilder cutsql = new StringBuilder("select count(*) from client ");
        StringBuilder wheresql = new StringBuilder("where 1=1 ");
        List<Object> params = new ArrayList<Object>();
        if (en_id != "请选择" && !en_id.trim().isEmpty()) {
            wheresql.append("and enterprise_id=? ");
            params.add(en_id);
        }
        if (clname != null && !clname.trim().isEmpty()) {
            wheresql.append("and clname like ? ");
            params.add(clname + "%");
        }

        Number number = (Number) qr.query(cutsql.append(wheresql).toString(), new ScalarHandler(), params.toArray());
        int pall = number.intValue();
        pb.setPall(pall);

        //查询具体信息
        StringBuilder sql = new StringBuilder("select * from client ");
        StringBuilder limitsql = new StringBuilder("limit ?,? ");
        params.add((pcode - 1) * psize);
        params.add(psize);
        List<Client> clientList = qr.query(sql.append(wheresql).append(limitsql).toString(), new BeanListHandler<Client>(Client.class), params.toArray());
        //为clientList赋值
        Client client = null;
        int index = (pcode - 1) * psize + 1;//设置当前页码的第一个序号
        for (int i = 0; i < clientList.size(); i++) {
            client = clientList.get(i);  //获取对当前对象的引用
            client.setSerialnum(index);  //设置序号
            index++;
            //将加载（对象属性）land和elements里的属性值到supplier对象里
            loadEnterprise(client);
        }
        pb.setBeanList(clientList);
        System.out.println(pb);
        return pb;

    }

    /**
     * 客户明细
     * @param cl_id
     * @return
     */
    public Client findClenDetail(String cl_id) {
        String sql="select * from client where cl_id=?";
        try {
            Client client=qr.query(sql,new BeanHandler<Client>(Client.class),cl_id);
            return client;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
