package com.limbo.lands.servlet;

import cn.itcast.servlet.BaseServlet;
import com.limbo.lands.domain.Client;
import com.limbo.lands.domain.Enterprise;
import com.limbo.lands.domain.PageBean;
import com.limbo.lands.service.ClientService;
import com.limbo.lands.service.EnterpriseService;
import com.limbo.lands.service.PageBeanTools;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by lenovo on 2016/4/17.
 */
@WebServlet(urlPatterns = "/ClientServlet")
public class ClientServlet extends BaseServlet {
    private ClientService clientService=new ClientService();
    private PageBeanTools pbt=new PageBeanTools();
    private EnterpriseService enterpriseService=new EnterpriseService();


    /**
     * 查询客户的信息
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String findAllClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int psize=10;
        int pcode=pbt.getpcode(request);
        PageBean<Client> clientPageBean=new PageBean<Client>();
        clientPageBean= clientService.findAllClient(pcode,psize);
        clientPageBean.setUrl(pbt.getPageUrl(request));
        request.setAttribute("pageBean",clientPageBean);

        //获得企业名称
        List<Enterprise> enterpriseList= enterpriseService.getEnname();
        request.setAttribute("ennameList",enterpriseList);
        return "f:/jsps/client/client.jsp";
    }

    /**
     * 通过企业名称和客户名称查询
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
    public String searchClient(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 分页
         * 获取表单en_id和clname
         */
        String en_id=request.getParameter("enname");
        String clname=request.getParameter("clname");
        int psize=10;
        int pcode=pbt.getpcode(request);

        PageBean<Client> clientPageBean=new PageBean<Client>();
        clientPageBean= clientService.findClientByClnameAndEnname(pcode, psize, en_id, clname);
        clientPageBean.setUrl(pbt.getPageUrl(request));
        request.setAttribute("pageBean",clientPageBean);

        //获得企业名称
        List<Enterprise> enterpriseList= enterpriseService.getEnname();
        request.setAttribute("ennameList",enterpriseList);
        //返回企业名称也是en_id
        request.setAttribute("en_id",en_id);
        //返回clname客户名
        request.setAttribute("clname",clname);
        return "f:/jsps/client/client.jsp";
    }

    public String clientDetail(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String cl_id=request.getParameter("cl_id");
        Client client=clientService.findClientDetail(cl_id);
        request.setAttribute("client",client);
        return "/jsps/client/clientdetail.jsp";
    }
}
