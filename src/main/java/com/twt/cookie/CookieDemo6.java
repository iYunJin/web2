package com.twt.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * Cookie快速入门
 */
@WebServlet("/CookieDemo6")
public class CookieDemo6 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        if (cookies != null){
            for (Cookie c:cookies){
                String name = c.getName();
                if("lastTime".equals(name)){
                    flag = true;
                    String value = c.getValue();
                    //设置cookie的value
                    Date date= new Date();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                    String value2 = sdf.format(date);
                    value2 = URLEncoder.encode(value2, StandardCharsets.UTF_8);

                    c.setValue(value2);
                    //设置cookie存活时间
                    c.setMaxAge(60*60*24);
                    response.addCookie(c);
                    value = URLDecoder.decode(value,StandardCharsets.UTF_8);
                    //响应数据
                    response.setContentType("text/html;charset=utf-8");
                    response.getWriter().write("<h1>欢迎回来，您上次访问时间"+value+"</h1>");
                    break;
                }
            }

        }
        if (cookies==null || !flag){
            Date date= new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
            String value = sdf.format(date);
            value = URLEncoder.encode(value, StandardCharsets.UTF_8);
            Cookie cookie = new Cookie("lastTime",value);
            cookie.setMaxAge(60*60*24);
            response.addCookie(cookie);
            response.setContentType("text/html;charset=utf-8");
            response.getWriter().write("<h1>欢迎首次访问</h1>");
        }

    }
}
