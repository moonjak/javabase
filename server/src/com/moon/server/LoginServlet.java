package com.moon.server;

/**
 * @author zgui
 * @function 登陆servlet
 * @createTime 2019/8/30 10:37
 */
public class LoginServlet implements Servlet
{
    @Override
    public void service (Request request, Response response)
    {
        //响应内容
        response.println ("<html>");
        response.println ("<p>");
        response.println ("登陆页面！" + request.getValue ("user"));
        response.println ("</p>");
        response.println ("</html>");
    }
}
