package com.moon.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author zgui
 * @function 封装响应内容
 * @createTime 2019/8/29 9:30
 */
public class Server03
{
    public static void main(String[] args)
    {
        Server03 server01 = new Server03 ();
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
            //获取客户端请求内容
            InputStream inputStream = client.getInputStream ();
            DataInputStream reader = new DataInputStream (inputStream);
            System.err.println (new StringBuilder (reader.readChar ()).toString ());

            Response response = new Response (client);
            //响应内容
            StringBuilder context = new StringBuilder ();
            response.println ("<html>");
            response.println ("<p>");
            response.println ("访问成功qq！");
            response.println ("</p>");
            response.println ("</html>");
            response.write (404);
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
