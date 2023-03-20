<%@ page import="java.util.Date" %>
<%@ page import="java.text.SimpleDateFormat" %>
<%@ page import="java.net.URLEncoder" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<%@ page import="java.net.URLDecoder" %><%--
  Created by IntelliJ IDEA.
  User: 14560
  Date: 2023/3/20
  Time: 16:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java"  buffer="none" %>
<html>
<head>
    <title>TwT</title>
</head>
<body>
    <%
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
    %>

            <h1>欢迎回来，您上次访问时间<%=value%></h1>
    <%
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
    %>
        <h1>欢迎首次访问</h1>
    <%
      }
    %>
</body>
</html>
