package com.moon.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zgui
 * @function servlet引入
 * @createTime 2019/8/29 9:30
 */
public class Server05
{
    public static void main(String[] args)
    {
        Server05 server01 = new Server05 ();
        server01.start ();
    }

    private ServerSocket socket;


    public void start ()
    {
        try
        {
            socket = new ServerSocket (8888);
            System.err.println ("服务器启动。。。");

            receive ();
        }
        catch (IOException e)
        {
            System.err.println ("服务器失败。。。");
            e.printStackTrace ();
        }
    }

    public void receive ()
    {
        try
        {
            Socket client = socket.accept ();
            System.err.println ("一个客户端建立连接。。。");
            //请求消息封装
            Request request = new Request (client);
            //响应消息封装
            Response response = new Response (client);
            //创建servlet
            Servlet servlet = new LoginServlet ();
            servlet.service (request, response);
            response.write (200);
        }
        catch (IOException e)
        {
            System.err.println ("一个客户端建立连接失败。。。");
            e.printStackTrace ();
        }
    }

    public void stop ()
    {

    }
}
