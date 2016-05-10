package com.limbo.lands.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.limbo.lands.domain.*;
import com.limbo.lands.service.EnterpriseService;
import com.limbo.lands.service.PageBeanTools;
import com.limbo.lands.service.SupplierService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/17.
 */
@WebServlet(urlPatterns = "/SupplierServlet")
public class SupplierServlet extends BaseServlet {
    private SupplierService supplierService = new SupplierService();
    private EnterpriseService enterpriseService=new EnterpriseService();
    private PageBeanTools pageBeanTools=new PageBeanTools();

    /**
     * 查询所有供应商
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAllSupplier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int psize=10;
        int pcode=pageBeanTools.getpcode(request);
        PageBean<Supplier> pageSupplierBean=new PageBean<Supplier>();
        //查询和设置地址
        pageSupplierBean=supplierService.findAllSupplier(pcode,psize);
        pageSupplierBean.setUrl(pageBeanTools.getPageUrl(request));
        request.setAttribute("pageBean",pageSupplierBean);
        //企业下拉框(从企业表里获得，可能有些没供应商)也可以直接在供应商里查找
        List<Enterprise> enterpriseList=enterpriseService.getEnname();
        request.setAttribute("ennameList",enterpriseList);
        return "f:/jsps/supplier/supplier.jsp";
    }

    /**
     * 供应商明细
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String supplierDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取sid 通过id查询
        String sid=request.getParameter("sid");
        Supplier supplier=supplierService.findBySid(sid);
        request.setAttribute("supplier",supplier);
        return "f:/jsps/supplier/supplierdetail.jsp";
    }

    /**
     * 多条件查询供应商
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String searchSupplier(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //一键封装
        Supplier supplierForm= CommonUtils.toBean(request.getParameterMap(),Supplier.class);
        //获取en_id 保存在Enterprise对象里
        Enterprise enterprise=new Enterprise();
        enterprise.setEn_id(request.getParameter("enname"));
        supplierForm.setEnterprise(enterprise);

        //设置每页记录数为10 存到PageBean里
        int psize = 10;
        //获得从链接里的当前页，点击时默认第一页
        int pcode = pageBeanTools.getpcode(request);
        PageBean<Supplier> supplierPageBean = supplierService.findByEnnameAndsnameAndType(supplierForm, pcode, psize);
        //设置url
        supplierPageBean.setUrl(pageBeanTools.getPageUrl(request));
        request.setAttribute("pageBean", supplierPageBean);
        //获取企业名称并返回（下拉框）
        List<Enterprise> enterpriseList=enterpriseService.getEnname();
        request.setAttribute("ennameList",enterpriseList);
        //返回供应商的搜索名
        request.setAttribute("sname", supplierForm.getSname());
        //返回之前提交的企业名select显示
        request.setAttribute("en_id",request.getParameter("enname"));
        //返回之前提交的类型select显示
        request.setAttribute("type",request.getParameter("type"));
        return "f:/jsps/supplier/supplier.jsp";

    }


}

