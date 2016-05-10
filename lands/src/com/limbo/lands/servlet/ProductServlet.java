package com.limbo.lands.servlet;

import cn.itcast.servlet.BaseServlet;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.domain.Product;
import com.limbo.lands.service.PageBeanTools;
import com.limbo.lands.service.ProductService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2016/4/17.
 */
@WebServlet(urlPatterns = "/ProductServlet")
public class ProductServlet extends BaseServlet {
    private ProductService productService = new ProductService();
    private PageBeanTools pageBeanTools = new PageBeanTools();

    /**
     * 查询所有产品
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAllProduct(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int psize = 10;
        int pcode = pageBeanTools.getpcode(request);
        PageBean<Product> pageProductBean = new PageBean<Product>();
        //查询和设置地址
        pageProductBean = productService.findAllProduct(pcode, psize);
        pageProductBean.setUrl(pageBeanTools.getPageUrl(request));
        request.setAttribute("pageBean", pageProductBean);
        return "f:/jsps/product/product.jsp";
    }

    /**
     * 按产品名称查询（模糊查询）
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findProductByPname(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String pname = request.getParameter("pname");
        int psize = 10;
        int pcode = pageBeanTools.getpcode(request);

        PageBean<Product> pageProductBean = productService.findProductByPname(pcode, psize, pname);
        //设置url
        pageProductBean.setUrl(pageBeanTools.getPageUrl(request));
        request.setAttribute("pageBean", pageProductBean);
        //将查询输入的值返回
        request.setAttribute("pname", pname);
        return "f:/jsps/product/product.jsp";
    }

    /**
     * 产品明细
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String productDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取产品id
        String pid = request.getParameter("pid");
        Product product = productService.findByPid(pid);
        request.setAttribute("product", product);
        return "f:/jsps/product/productdetail.jsp";
    }

}

