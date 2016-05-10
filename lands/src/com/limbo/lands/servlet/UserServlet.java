package com.limbo.lands.servlet;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.limbo.lands.domain.*;
import com.limbo.lands.service.EnterpriseService;
import com.limbo.lands.service.GroupService;
import com.limbo.lands.service.PageBeanTools;
import com.limbo.lands.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lenovo on 2016/5/6.
 */
@WebServlet(urlPatterns = "/UserServlet")
public class UserServlet extends BaseServlet {
    private UserService userService = new UserService();
    private EnterpriseService enterpriseService = new EnterpriseService();
    private GroupService groupService = new GroupService();
    private PageBeanTools pb = new PageBeanTools();

    /**
     * 查询所有的企业员工
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAllEnt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int psize = 10;
        PageBean<User> pageBeanUser = new PageBean<User>();
        //获取当前页码pcode
        int pcode = pb.getpcode(request);
        pageBeanUser = userService.findAllEnt(pcode, psize);
        pageBeanUser.setUrl(pb.getPageUrl(request));
        request.setAttribute("pageBean", pageBeanUser);
        //获取企业并返回
        List<Enterprise> enterpriseList = enterpriseService.getEnname();
        request.setAttribute("ennameList", enterpriseList);
        //获取角色组返回
        List<Groups> groupsList = groupService.getG_name();
        request.setAttribute("G_nameList", groupsList);

        return "f:/jsps/user/ent/ent_employee.jsp";
    }

    /**
     * 通过id查看企业人员信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findEntByU_id(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        User user = userService.findEntByU_id(u_id);
        request.setAttribute("user", user);
        return "f:/jsps/user/ent/entdetail.jsp";
    }

    /**
     * 加载要修改的信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String loadModifyEnt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        User user = userService.findEntByU_id(u_id);
        request.setAttribute("user", user);
        return "f:/jsps/user/ent/modifyEnt.jsp";
    }

    /**
     * 修改提交修改信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String modifyEnt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        String u_id = request.getParameter("u_id");
        String reu_pass = request.getParameter("reu_pass");
        if (!form.getU_pass().equals(reu_pass)) {
            String enname = request.getParameter("enname");
            Enterprise enterprise = new Enterprise();
            enterprise.setEnname(enname);

            String g_name = request.getParameter("g_name");
            Groups groups = new Groups();
            groups.setG_name(g_name);

            String account = request.getParameter("account");
            form.setAccount(account);
            form.setEnterprise(enterprise);
            form.setGroups(groups);
            request.setAttribute("user", form);
            request.setAttribute("reu_pass", reu_pass);
            request.setAttribute("msg", "密码不一致！");
            return "f:/jsps/user/ent/modifyEnt.jsp";
        }
        userService.modifyEnt(form);
        UserServlet userServlet = new UserServlet();
        userServlet.findAllEnt(request, response);
        return "f:/jsps/user/ent/ent_employee.jsp";
    }

    /**
     * 删除企业员工
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String deleteEnt(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String u_id = request.getParameter("u_id");
        userService.deleteEntById(u_id);
        //查询所有员工返回
        UserServlet userServlet = new UserServlet();
        userServlet.findAllEnt(request, response);
        return "f:/jsps/user/ent/ent_employee.jsp";
    }


    /**
     * 查询所有政府人员
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAllGov(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {
        int psize = 10;
        PageBean<User> pageBeanUser = new PageBean<User>();
        //获取当前页码pcode
        int pcode = pb.getpcode(request);
        pageBeanUser = userService.findAllGov(pcode, psize);
        pageBeanUser.setUrl(pb.getPageUrl(request));
        request.setAttribute("pageBean", pageBeanUser);
        //获取角色组返回
        List<Groups> groupsList = groupService.getG_name();
        request.setAttribute("G_nameList", groupsList);
        return "f:/jsps/user/gov/gov.jsp";
    }

    /**
     * 通过id查看政府人员信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findGovByU_id(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        User user = userService.findGovByU_id(u_id);
        request.setAttribute("user", user);
        return "f:/jsps/user/gov/govdetail.jsp";
    }

    /**
     * 加载要修改政府员工的信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String loadModifyGov(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        User user = userService.findEntByU_id(u_id);//同一个表直接调用加载修改企业员工的方法
        request.setAttribute("user", user);
        return "f:/jsps/user/gov/modifyGov.jsp";
    }

    /**
     * 修改提交的政府员工信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String modifyGov(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        String u_id = request.getParameter("u_id");
        String reu_pass = request.getParameter("reu_pass");
        if (!form.getU_pass().equals(reu_pass)) {
            String g_name = request.getParameter("g_name");
            Groups groups = new Groups();
            groups.setG_name(g_name);

            String account = request.getParameter("account");
            form.setAccount(account);
            form.setGroups(groups);
            request.setAttribute("user", form);
            request.setAttribute("reu_pass", reu_pass);
            request.setAttribute("msg", "密码不一致！");
            return "f:/jsps/user/gov/modifyGov.jsp";
        }
        userService.modifyEnt(form);//同一个表直接调用修改企业员工的方法
        UserServlet userServlet = new UserServlet();
        userServlet.findAllGov(request, response);
        return "f:/jsps/user/gov/gov.jsp";
    }


    /**
     * 删除政府员工
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String deleteGov(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = request.getParameter("u_id");
        userService.deleteEntById(u_id);  //在同一个表里
        //查询所有员工返回
        UserServlet userServlet = new UserServlet();
        userServlet.findAllGov(request, response);
        return "f:/jsps/user/gov/gov.jsp";

    }


}
