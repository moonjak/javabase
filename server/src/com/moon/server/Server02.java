package com.moon.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

/**
 * @author zgui
 * @function 发送响应内容
 * @createTime 2019/8/29 9:30
 */
public class Server02
{
    public static void main(String[] args)
    {
        Server02 server01 = new Server02 ();
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

            //响应内容
            StringBuilder context = new StringBuilder ();
            context.append ("<html>");
            context.append ("<p>");
            context.append ("访问成功！");
            context.append ("</p>");
            context.append ("</html>");

            StringBuilder response = new StringBuilder ();
            String blank = " ";
            String crlf = "\r\n";
            response.append ("HTTP/1.1").append (blank).append ("200").append (blank).append ("OK").append (crlf);
            response.append ("Date:").append (new Date ()).append (crlf);
            response.append ("Server:shsxt Server/0.0.1;charset=GBK").append (crlf);
            response.append ("Content-Type:text/html").append (crlf);
            response.append ("Content-length:").append (context.toString ().getBytes ().length).append (crlf);
            response.append (crlf);
            response.append (context.toString ());

            //获取输出流,写入到客户端
            OutputStream outputStream = client.getOutputStream ();
            BufferedWriter bw = new BufferedWriter (new OutputStreamWriter (outputStream));
            bw.write (response.toString ());
            bw.flush ();
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
