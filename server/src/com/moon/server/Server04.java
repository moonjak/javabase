package com.moon.server;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zgui
 * @function 封装请求内容
 * @createTime 2019/8/29 9:30
 */
public class Server04
{
    public static void main(String[] args)
    {
        Server04 server01 = new Server04 ();
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
            Request request = new Request (client);

            Response response = new Response (client);
            //响应内容
            response.println ("<html>");
            response.println ("<p>");
            response.println ("访问成功！" + request.getValue ("user"));
            response.println ("</p>");
            response.println ("</html>");
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
