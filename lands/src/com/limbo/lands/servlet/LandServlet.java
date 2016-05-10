package com.limbo.lands.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.Land;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.service.LandService;
import com.limbo.lands.service.PageBeanTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/15.
 */
@WebServlet(urlPatterns = "/LandServlet")
public class LandServlet extends BaseServlet {
    private LandService landService = new LandService();
    private PageBeanTools pageBeanTools=new PageBeanTools();


    /**
     * 查询所有土地资源
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAllLand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 分页设计
         */
        //设置每页记录数为10 存到PageBean里
        int psize = 10;
        //获得从链接里的当前页，点击时默认第一页
        int pcode = pageBeanTools.getpcode(request);
        PageBean<Land> pageLandBean = landService.findAllNew(pcode, psize);
        //设置url
        pageLandBean.setUrl(pageBeanTools.getPageUrl(request));
        request.setAttribute("pageBean", pageLandBean);
        //下拉框里的企业名称
        List<Enterprise> ennameList = landService.findEnterpriseName();
        request.setAttribute("ennameList", ennameList);
        return "f:/jsps/land.jsp";
    }

    /**
     * 通过产地名称和企业名称查询产地信息(企业名实际为企业id)
     * 模糊查询
     * 产地名称为空时也可以查询！（判断是否为空）
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String searchLand(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        /**
         * 获取页面传来的产地名称和企业id]
         * 将表单的en_id和landname一键封装
         */
        Land landform= CommonUtils.toBean(request.getParameterMap(),Land.class);
        Enterprise enterprise=new Enterprise();
        enterprise.setEn_id(request.getParameter("enname"));
        landform.setEnterprise(enterprise);

        /**
         * 分页处理
         */
        //设置每页记录数为10 存到PageBean里
        int psize = 10;
        //获得从链接里的当前页，点击时默认第一页
        int pcode = pageBeanTools.getpcode(request);
        PageBean<Land> landPageBean = landService.findByEnnameAndLname(landform,pcode,psize);
        //设置url
        landPageBean.setUrl(pageBeanTools.getPageUrl(request));
        request.setAttribute("pageBean", landPageBean);
        //获取企业名称和土地名称并返回
        List<Enterprise> ennameList = landService.findEnterpriseName();
        request.setAttribute("lname", landform.getLname());
        request.setAttribute("ennameList", ennameList);
        request.setAttribute("en_id",request.getParameter("enname"));
        return "f:/jsps/land.jsp";
    }

    /**
     * 通过lid（产地id）查看该产地的明细
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String landDetail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String lid = request.getParameter("lid");
        Land landList = landService.findByLid(lid);
        request.setAttribute("landList", landList);
        return "f:/jsps/landdetail.jsp";
    }
}
