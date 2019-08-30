package com.moon.server;

import com.moon.server.webapp.Entry;
import com.moon.server.webapp.Mapping;
import com.moon.server.webapp.WebContext;
import com.moon.server.webapp.WebHandler;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;

/**
 * @author zgui
 * @function 整合web.xml
 * @createTime 2019/8/29 9:30
 */
public class Server06
{
    public static void main(String[] args)
    {
        Server06 server01 = new Server06 ();
        server01.start ();
    }

    private ServerSocket socket;

    private WebContext webContext;
    //状态码
    private int code = 200;
    public void start ()
    {
        try
        {
            socket = new ServerSocket (8888);
            System.err.println ("服务器启动。。。");
            initWebContext();
            receive ();
        }
        catch (IOException e)
        {
            System.err.println ("服务器失败。。。");
            e.printStackTrace ();
        }
    }

    private void initWebContext ()
    {
        try
        {
            //1.获取解析工厂
            SAXParserFactory saxfac = SAXParserFactory.newInstance();
            //2.从工厂中获取解析器
            SAXParser saxparser = saxfac.newSAXParser();
            //3.编写处理器
            //4.加载文档Document注册处理器
            WebHandler handler = new WebHandler();
            //5.解析
            saxparser.parse(Thread.currentThread().getContextClassLoader()
                                          .getResourceAsStream("com/moon/server/webapp/web.xml"), handler);
            List<Entry> entryList = handler.getEntryList();
            List<Mapping> mappingList = handler.getMappingList();
            webContext = new WebContext(entryList, mappingList);
        }
        catch (ParserConfigurationException e)
        {
            e.printStackTrace ();
        }
        catch (SAXException e)
        {
            e.printStackTrace ();
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
    }

    public void receive ()
    {
        Response response = null;
        try
        {
            Socket client = socket.accept ();
            System.err.println ("一个客户端建立连接。。。");
            //请求消息封装
            Request request = new Request (client);
            //响应消息封装
            response = new Response (client);
            //根据url实列化servlet对象
            Servlet servlet = newInstanceServlet (request.getUrl ());
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
        }

    }

    /**
     * 根据url实列化servlet对象
     * */
    private Servlet newInstanceServlet (String url) throws Exception
    {
        Servlet servlet = null;
        try
        {
            url = "/" + url;
            String clzByUrl = webContext.getClzByUrl (url);
            if (clzByUrl == null)
            {
                return null;
            }
            //实列化servlet对象
            Class<?> aClass = Class.forName (clzByUrl);
            servlet = (Servlet) aClass.getConstructor ().newInstance ();
        }
        catch (Exception e)
        {
            throw new Exception ("未找到servlet");
        }
        return servlet;
    }

    public void stop ()
    {

    }
}
