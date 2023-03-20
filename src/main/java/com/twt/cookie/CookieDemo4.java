package com.twt.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 *
 * Cookie快速入门
 */
@WebServlet("/CookieDemo4")
public class CookieDemo4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie c1 = new Cookie("msg","hello");
        //设置cookie存活时间
        c1.setMaxAge(300);//持久化cookie到硬盘，30s后删除
        response.addCookie(c1);

    }
}
