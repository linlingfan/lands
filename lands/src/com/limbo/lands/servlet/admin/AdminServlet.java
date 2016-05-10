package com.limbo.lands.servlet.admin;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.Groups;
import com.limbo.lands.domain.User;
import com.limbo.lands.service.UserService;
import com.limbo.lands.servlet.UserServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/5/8.
 */
@WebServlet(urlPatterns = "/AdminServlet")
public class AdminServlet extends BaseServlet {
    private UserService userService = new UserService();

    /**
     * 通过id查看管理员信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAdminByU_id(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String u_id = "1000000000";  //要获取session里的用户id

        User user = userService.findEntByU_id(u_id);//在同一张表里直接调用
        request.setAttribute("user", user);
        return "f:/jsps/user/admin/admindetail.jsp";
    }

    /**
     * 加载要修改的个人信息
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String loadModifyAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = "1000000000";
        User user = userService.findEntByU_id(u_id);
        request.setAttribute("user", user);
        return "f:/jsps/user/admin/modifyadmin.jsp";
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
    public String modifyAdmin(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User form = CommonUtils.toBean(request.getParameterMap(), User.class);
        userService.modifyEnt(form);
        AdminServlet adminServlet = new AdminServlet();
        adminServlet.findAdminByU_id(request, response);
        return "f:/jsps/user/admin/admindetail.jsp";
    }

    /**
     * 修改密码
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String modifyPass(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String u_id = "1000000000";
        //得到管理员密码
        User user = userService.findEntByU_id(u_id);
        String u_pass = user.getU_pass();
        //获取表单的三个密码
        String oldpass = request.getParameter("oldpass");
        String newpass = request.getParameter("newpass");
        String repass = request.getParameter("repass");

        List<String> list = new ArrayList<String>();
        list.add(oldpass);
        list.add(newpass);
        list.add(repass);
        if (oldpass.isEmpty()) {
            request.setAttribute("msg1", "密码不为空！");
            request.setAttribute("list", list);
            return "f:/jsps/user/admin/modifypass.jsp";
        } else if (!oldpass.equals(u_pass))

        {
            request.setAttribute("msg1", "旧密码不正确！");
            request.setAttribute("list", list);
            return "f:/jsps/user/admin/modifypass.jsp";

        } else if (newpass.length() < 6) {
            request.setAttribute("msg2", "密码不能少于6个字符，汉字算2个字符！");
            request.setAttribute("list", list);
            return "f:/jsps/user/admin/modifypass.jsp";
        } else if (!newpass.equals(repass)) {
            request.setAttribute("msg3", "两次密码不一致！");
            request.setAttribute("list", list);
            return "f:/jsps/user/admin/modifypass.jsp";
        } else
            userService.modifyPass(u_id, newpass);
        request.setAttribute("success", "修改成功！");
        return "f:/jsps/user/admin/modifypass.jsp";
    }

}
