package com.moon.server;

import com.moon.server.webapp.WebApp;

import java.io.IOException;
import java.net.Socket;

/**
 * @author zgui
 * @function 分发器
 * @createTime 2019/8/30 14:04
 */
public class Dispatcher implements Runnable
{
    private Socket client;

    private int code = 200;

    public Dispatcher (Socket client)
    {
        this.client = client;
    }

    @Override
    public void run ()
    {
        Response response = null;
        try
        {
            System.err.println ("一个客户端建立连接。。。");
            //请求消息封装
            Request request = new Request (client);
            //响应消息封装
            response = new Response (client);
            //根据url实列化servlet对象
            Servlet servlet = WebApp.newInstanceServlet (request.getUrl ());
            if (servlet == null)
            {
                code = 404;
                return;
            }
            //调用service方法
            servlet.service (request, response);
        }
        catch (Exception e)
        {
            code = 505;
            System.err.println ("一个客户端建立连接失败。。。");
            e.printStackTrace ();
        }
        finally
        {
            //响应推送
            response.write (code);
            release ();
        }
    }

    private void release ()
    {
        try
        {
            client.close ();
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
    }
}
