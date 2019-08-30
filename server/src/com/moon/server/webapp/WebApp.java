package com.moon.server.webapp;

import com.moon.server.Servlet;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * @author zgui
 * @function
 * @createTime 2019/8/30 14:16
 */
public class WebApp
{
    private static WebContext webContext;
    static
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

    /**
     * 根据url实列化servlet对象
     * */
    public static Servlet newInstanceServlet (String url)
    {
        Servlet servlet = null;
        try
        {
            url = "/" + url;
            String clzByUrl = webContext.getClzByUrl (url);
            //实列化servlet对象
            Class<?> aClass = Class.forName (clzByUrl);
            servlet = (Servlet) aClass.getConstructor ().newInstance ();
        }
        catch (Exception e)
        {
            e.printStackTrace ();
        }
        return servlet;
    }
}
