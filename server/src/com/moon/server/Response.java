package com.moon.server;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @author zgui
 * @function 响应消息封装
 * @createTime 2019/8/29 11:29
 */
public class Response
{
    private BufferedWriter bufferedWriter;
    //响应体
    private StringBuilder content;
    //响应头
    private StringBuilder responseHeader;
    //响应体字节长度
    private int len;

    private final String blank = " ";
    private final String crlf = "\r\n";

    private Response ()
    {
        content = new StringBuilder ();
        responseHeader = new StringBuilder ();
        len = 0;
    }
    public Response (Socket client)
    {
        this ();
        try
        {
            bufferedWriter = new BufferedWriter (new OutputStreamWriter (client.getOutputStream ()));
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
    }

    public Response (OutputStream outputStream)
    {
        this ();
        bufferedWriter = new BufferedWriter (new OutputStreamWriter (outputStream));
    }

    /**
     * 动态添加内容
     * */
    public Response print (String text)
    {
        content.append (text);
        len += text.getBytes ().length;
        return this;
    }

    public Response println (String text)
    {
        content.append (text).append (crlf);
        len += (text.getBytes ().length + crlf.getBytes ().length);
        return this;
    }
    /**
     * 创建消息头
     * */
    public void createResponseHeader (int code)
    {
        responseHeader.append ("HTTP/1.1").append (blank).append (code).append (blank);
        switch (code)
        {
            case 200:
                responseHeader.append ("OK").append (crlf);
                break;
            case 404:
                responseHeader.append ("NOT FOUND").append (crlf);
                break;
            case 505:
                responseHeader.append ("SERVER ERROR").append (crlf);
                break;
        }
        responseHeader.append ("Date:").append (new Date ()).append (crlf);
        responseHeader.append ("Server:shsxt Server/0.0.1;charset=GBK").append (crlf);
        responseHeader.append ("Content-Type:text/html").append (crlf);
        responseHeader.append ("Content-length:").append (len).append (crlf);
        responseHeader.append (crlf);
    }

    public void write (int code)
    {
        StringBuilder text = new StringBuilder ();
        createResponseHeader (code);
        text.append (responseHeader);
        text.append (content);
        try
        {
            bufferedWriter.write (text.toString ());
            bufferedWriter.flush ();
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
    }
}
