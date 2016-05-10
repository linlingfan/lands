package com.limbo.lands.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.service.EnterpriseService;
import com.limbo.lands.service.PageBeanTools;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lenovo on 2016/4/19.
 */
@WebServlet(urlPatterns = "/EnterpriseServlet")
public class EnterpriseServlet extends BaseServlet {
    private PageBeanTools pbt = new PageBeanTools();
    private EnterpriseService enterpriseService = new EnterpriseService();

    /**
     * 查询所有企业
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAllEnterprise(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int psize = 10;
        int pcode = pbt.getpcode(request);
        PageBean<Enterprise> enterprisePageBean = new PageBean<Enterprise>();
        enterprisePageBean = enterpriseService.findEnterpriseByFlag(pcode, psize);//flag状态2为正常，3为暂停，4注销（不显示）
        //获取url
        enterprisePageBean.setUrl(pbt.getPageUrl(request));
        request.setAttribute("pageBean", enterprisePageBean);

        return "f:/jsps/enterprise/enterprise.jsp";

    }

    /**
     * 企业名查询（模糊查询）
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String searchByEnname(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int psize = 10;
        int pcode = pbt.getpcode(request);
        //得到表单ennam
        String enname = request.getParameter("enname");
        PageBean<Enterprise> enterprisePageBean = new PageBean<Enterprise>();
        enterprisePageBean = enterpriseService.findEnterpriseByEnname(enname, pcode, psize);
        enterprisePageBean.setUrl(pbt.getPageUrl(request));
        request.setAttribute("pageBean", enterprisePageBean);
        //enname值返回
        request.setAttribute("enname", enname);

        return "f:/jsps/enterprise/enterprise.jsp";
    }

    /**
     * 企业明细信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String enterpriseDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String en_id = request.getParameter("en_id");
        Enterprise enterprise = enterpriseService.findDetailByEn_id(en_id);
        request.setAttribute("enterprise", enterprise);
        return "f:/jsps/enterprise/enterprisedetail.jsp";
    }

    /**
     * 加载要修改的信息到修改页面去
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String loadModifyEnterprise(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        EnterpriseServlet enterpriseServlet = new EnterpriseServlet();
        enterpriseServlet.enterpriseDetail(request, response);
        return "f:/jsps/enterprise/modify.jsp";

    }

    /**
     * 修改企业信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String modifyEnterprise(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取修改后的表单一键封装
        Enterprise form = CommonUtils.toBean(request.getParameterMap(), Enterprise.class);
        Enterprise enterprise = enterpriseService.modifyEnterprise(form);
        request.setAttribute("enterprise", form);
        request.setAttribute("success", "修改成功！");
        return "f:/jsps/enterprise/modify.jsp";
    }

    /**
     * 更改企业状态(flag)
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String changeState(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String en_id = request.getParameter("en_id");
        int flag = Integer.parseInt(request.getParameter("flag"));
        Enterprise enterprise=enterpriseService.changeFlag(en_id,flag);
        //重新加载信息到enterprise.jsp
        EnterpriseServlet enterpriseServlet=new EnterpriseServlet();
        enterpriseServlet.findAllEnterprise(request,response);
        return "f:/jsps/enterprise/enterprise.jsp";
    }


}
