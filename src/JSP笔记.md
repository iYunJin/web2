#### JSP
1. 原理：本质上是一个Servlet
2. 脚本：申明java代码方式
   1. \<%...%>:内容会直接放到_jspService()方法之中
   2. \<%=..%>:定义的java代码，会输出到页面上
   3. \<%!...%>∶定义的java代码，在jsp转换后的java类的成员位置。
   4. JSP的内置对象
      * 不需要创建，可以直接使用
      * 一共9个内置对象
        1. request
        2. response
        3. out：字符输出流
<br><br>

### Session
1. 概念：服务器会话技术，在一次会话中多次的请求间共享数据，数据保存在服务器端
2. 快速入门
   * 获取HttpSession对象
     1. HttpSession session = request.getSession();
   * 使用HttpSession对象
     1. Object getAttribute(String name);
     2. void setAttribute(String name,Object value);
     3. void removeAttribute(String name);
     
3. 原理
   * Session的实现是依赖于Cookie的。
4. 细节
   1. 当客户端关闭后，服务器不关闭，两次获取session是否同一个？
      * 默认情况下不是。
   2. 客户端不关闭，服务器关闭，两次获取的session是否同一个？
      * 不是同一个
   3. session的失效时间？
      1. 服务器关闭
      2. session调用invalidate()
      3. session默认失效时间30分钟