package com.limbo.lands.dao;

import cn.itcast.jdbc.TxQueryRunner;
import com.limbo.lands.domain.Elements;
import com.limbo.lands.domain.Land;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.domain.Product;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/17.
 */
public class ProductDao {
    private QueryRunner qr = new TxQueryRunner();

    /**
     * 查询产品
     *
     * @param pcode
     * @param psize
     * @return
     */
    public PageBean<Product> findAllProduct(int pcode, int psize) throws SQLException {
        PageBean<Product> pb = new PageBean<Product>();
        pb.setPcode(pcode);
        pb.setPsize(psize);

        //查询总记录数返回number
        String sql = "select count(*) from product";
        Number number = (Number) qr.query(sql, new ScalarHandler());
        int pall = number.intValue();
        pb.setPall(pall);

        //查询product，得到product的beanList
        sql = "select * from product limit ?,?";
        List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class), (pcode - 1) * psize, psize);
        /**
         * 将加载（对象属性）land和elements里的属性值到product对象里
         * 声明一个空的Product引用 循环使用
         * 给序列号赋值
         */
        Product product = null;
        int index = (pcode - 1) * psize + 1;//设置当前页码的第一个序号
        for (int i = 0; i < productList.size(); i++) {
            product = productList.get(i);  //获取对当前对象的引用
            product.setSerialnum(index);  //设置序号
            index++;
            //将加载（对象属性）land和elements里的属性值到product对象里
            loadLandToProduct(product);
            loadElementsToProduct(product);
        }
        pb.setBeanList(productList);
        return pb;
    }

    /**
     * 加载product里与elements关联的信息。
     *
     * @param product
     */
    public void loadElementsToProduct(Product product) {
        String sql = "select * from elements where el_id in (select teatype_id from product where pid=?)";
        try {
            //获取关联表elements里的属性值，并且赋值给product的elements属性里
            Elements elements = qr.query(sql, new BeanHandler<Elements>(Elements.class), product.getPid());
            product.setElements(elements);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 加载product里与land表关联的信息。
     *
     * @param product
     */
    public void loadLandToProduct(Product product) {
        String sql = "select * from land where lid in (select land_id from product where pid=?)";
        try {
            //获取关联表land里的属性值，并且赋值给product的land属性里
            Land land = qr.query(sql, new BeanHandler<Land>(Land.class), product.getPid());
            product.setLand(land);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 按产品名称查询
     *
     * @param pcode
     * @param psize
     * @param pname
     * @return
     */
    public PageBean<Product> findProductByPname(int pcode, int psize, String pname) throws SQLException {
        PageBean<Product> pb = new PageBean<Product>();
        pb.setPcode(pcode);
        pb.setPsize(psize);

        //查询总记录数返回number
        String sql = "select count(*) from product where pname like ?";
        Number number = (Number) qr.query(sql, new ScalarHandler(), pname + '%');
        int pall = number.intValue();
        pb.setPall(pall);

        //查询product，得到product的beanList
        sql = "select * from product where pname like ? limit ?,?";
        List<Product> productList = qr.query(sql, new BeanListHandler<Product>(Product.class), pname + '%', (pcode - 1) * psize, psize);
        /**
         * 将加载（对象属性）land和elements里的属性值到product对象里
         * 声明一个空的Product引用 循环使用
         * 给序列号赋值
         */
        Product product = null;
        int index = (pcode - 1) * psize + 1;//设置当前页码的第一个序号
        for (int i = 0; i < productList.size(); i++) {
            product = productList.get(i);  //获取对当前对象的引用
            product.setSerialnum(index);  //设置序号
            index++;
            //将加载（对象属性）land和elements里的属性值到product对象里
            loadLandToProduct(product);
            loadElementsToProduct(product);
        }
        pb.setBeanList(productList);
        return pb;
    }

    /**
     * 通过pid查询产品明细
     *
     * @param pid
     * @return
     */
    public Product findByPid(String pid) throws SQLException {
        String sql = "select * from product where pid=?";
        Product product=qr.query(sql,new BeanHandler<Product>(Product.class),pid);
        loadElementsToProduct(product);
        loadLandToProduct(product);
        return product;
    }
}
