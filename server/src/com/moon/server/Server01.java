package com.moon.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author zgui
 * @function 获取请求协议，与请求内容
 * @createTime 2019/8/29 9:30
 */
public class Server01
{
    public static void main(String[] args)
    {
        Server01 server01 = new Server01 ();
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
            BufferedReader reader = new BufferedReader (new InputStreamReader (inputStream));
            for (String a = ""; a != null; a = reader.readLine ())
            {
                System.err.println (a);
            }
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
