package com.limbo.lands.service;

import javax.servlet.http.HttpServletRequest;
import com.limbo.lands.domain.PageBean;
/**
 * Created by lenovo on 2016/4/17.
 * 分页共用代码
 */
public class PageBeanTools {
    /**
     * 获取当前页吗的函数
     */
    public int getpcode(HttpServletRequest request) {
        String pcode = request.getParameter("pcode");
        if (pcode == null || pcode.trim().isEmpty() || Integer.parseInt(pcode)==0) {  //trim()去掉字符串两边空格
            return 1;  //为空时默认当前页码为1
        }
        return Integer.parseInt(pcode);
    }
    /**
     * 截取url
     * /项目名/Servlet路径?参数字符串
     * @param request
     * @return
     */
    public String getPageUrl(HttpServletRequest request) {
        String contextPath = request.getContextPath();//获取项目名
        String servletPath = request.getServletPath();//获取servletPath，即/CustomerServlet
        String queryString = request.getQueryString();//获取问号之后的参数部份  对于post方法传的参数，getQueryString（）得不到，它只对get方法得到的数据有效。
        //  判断参数部份中是否包含pc这个参数，如果包含，需要截取下去，不要这一部份。
        if (queryString.contains("&pcode=")) {
            int index = queryString.lastIndexOf("&pcode=");
            queryString = queryString.substring(0, index);
        }
        return contextPath + servletPath + "?" + queryString;
    }
}
