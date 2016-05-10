package com.limbo.lands.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.limbo.lands.domain.E_union;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.domain.Union;
import com.limbo.lands.service.PageBeanTools;
import com.limbo.lands.service.UnionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/21.
 */
@WebServlet(urlPatterns = "/UnionServlet")
public class UnionServlet extends BaseServlet {
    private UnionService unionService = new UnionService();
    private PageBeanTools pb = new PageBeanTools();

    /**
     * 查询所有的协会信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAllUnion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int psize = 10;
        PageBean<Union> pageUnionBean = new PageBean<Union>();
        //获取当前页码pcode
        int pcode = pb.getpcode(request);
        pageUnionBean = unionService.findAllUnion(pcode, psize);
        pageUnionBean.setUrl(pb.getPageUrl(request));
        request.setAttribute("pageBean", pageUnionBean);
        return "f:/jsps/union/union.jsp";
    }

    /**
     * 通过协会会名称查询
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String searchByUnname(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int psize = 10;
        String unname = request.getParameter("unname");
        PageBean<Union> pageUnionBean = new PageBean<Union>();
        //获取当前页码pcode
        int pcode = pb.getpcode(request);
        pageUnionBean = unionService.searchByUnname(unname, pcode, psize);
        pageUnionBean.setUrl(pb.getPageUrl(request));
        request.setAttribute("pageBean", pageUnionBean);
        //返回查询的输入unname
        request.setAttribute("unname", unname);

        return "f:/jsps/union/union.jsp";
    }


    /**
     * 查询协会信息和关联企业的信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String unionDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        Union union = new Union();
        union = unionService.findByU_id(u_id);
        request.setAttribute("union", union);
        return "f:/jsps/union/uniondetail.jsp";
    }

    /**
     * 加载修改协会信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String loadModifyUnion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        Union union = unionService.loadModifyUnion(u_id);
        request.setAttribute("union", union);
        return "f:/jsps/union/modifyunion.jsp";

    }

    /**
     * 修改协会信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String modifyUnion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //一键回去表单
        Union form = CommonUtils.toBean(request.getParameterMap(), Union.class);
        unionService.modifyUnion(form);
        request.setAttribute("success", "修改成功！请返回！");
        return "f:/success.jsp";

    }

    /**
     * 添加协会
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String addUnion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //一键获取表单
        Union form = CommonUtils.toBean(request.getParameterMap(), Union.class);
        //设置主键值
        String u_id = CommonUtils.uuid();
        form.setU_id(u_id);
        unionService.addUnion(form);
        //调用findAllUnion返回信息到union.jsp
        UnionServlet unionServlet=new UnionServlet();
        unionServlet.findAllUnion(request,response);
        return "f:/jsps/union/union.jsp";
    }

    /**
     * 删除协会
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */

    public String deleteUnion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        unionService.deleteUnion(u_id);
        //调用findAllUnion返回信息到union.jsp
        UnionServlet unionServlet=new UnionServlet();
        unionServlet.findAllUnion(request,response);
        return "f:/jsps/union/union.jsp";
    }

    /**
     * 查看某个会员的具体信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String en_unDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        String en_id = request.getParameter("en_id");
        String unname = request.getParameter("unname");

        E_union e_union = unionService.findEn_UnDetail(u_id, en_id);
        request.setAttribute("e_union", e_union);
        //返回协会名称
        request.setAttribute("unname", unname);
        return "f:/jsps/union/en_undetail.jsp";
    }

    /**
     * 加载要审核的会员信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String loadModifyEnterprise(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        String en_id = request.getParameter("en_id");
        String unname = request.getParameter("unname");

        E_union e_union = unionService.findEn_UnDetail(u_id, en_id);
        request.setAttribute("e_union", e_union);
        //返回协会名称和协会id
        request.setAttribute("u_id", u_id);
        request.setAttribute("unname", unname);
        return "f:/jsps/union/modifystate.jsp";
    }

    /**
     * 修改会员审核状态
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String changeState(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //一键封装表单  获取会员id和企业id
        E_union e_union = CommonUtils.toBean(request.getParameterMap(), E_union.class);
        String u_id = request.getParameter("u_id");
        String en_id = request.getParameter("en_id");

        if (e_union.getIdea() == null || e_union.getIdea().trim().isEmpty()) {
            request.setAttribute("msg", "意见不为空");
            return "f:/msg.jsp";
        }
        unionService.changeState(e_union, u_id, en_id);
        //返回当前页面
        UnionServlet unionServlet =new UnionServlet();
        unionServlet.unionDetail(request,response);
        return "f:/jsps/union/uniondetail.jsp";
    }

    /**
     * 删除某个协会的会员
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String deleteEnterprise(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String en_id=request.getParameter("en_id");
        String u_id = request.getParameter("u_id");
        unionService.deleteEnterprise(en_id);
        //返回当前页面
        UnionServlet unionServlet =new UnionServlet();
        unionServlet.unionDetail(request,response);
        return "f:/jsps/union/uniondetail.jsp";
    }

    /**
     * 添加会员
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String addVip(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        return null;
    }

}
