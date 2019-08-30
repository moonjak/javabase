package com.moon.server;

import com.moon.server.webapp.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @author zgui
 * @function 加入多线程，分发器dispatcher
 * @createTime 2019/8/29 9:30
 */
public class Server07
{
    public static void main(String[] args)
    {
        Server07 server01 = new Server07 ();
        server01.start ();
    }

    private ServerSocket socket;

    private WebContext webContext;
    //状态码
    private int code = 200;

    private boolean isRunning = true;
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
            while (isRunning)
            {
                Socket client = socket.accept ();
                new Thread (new Dispatcher (client)).start ();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace ();
            stop ();
        }

    }


    public void stop ()
    {
        isRunning = false;
        try
        {
            socket.close ();
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
    }
}
