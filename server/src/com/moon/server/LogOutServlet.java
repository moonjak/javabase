package com.moon.server;

/**
 * @author zgui
 * @function 登出servlet
 * @createTime 2019/8/30 10:38
 */
public class LogOutServlet implements Servlet
{
    @Override
    public void service (Request request, Response response)
    {
        //响应内容
        response.println ("<html>");
        response.println ("<p>");
        response.println ("注销成功！" + request.getValue ("user"));
        response.println ("</p>");
        response.println ("</html>");
    }
}
