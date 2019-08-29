package server.servlet;

import org.xml.sax.SAXException;
import server.prepare.sax.Employee;
import server.prepare.sax.EmployeeHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.List;

/**
 * sax解析
 * */
public class XmlTest
{
    public static void main(String[] args) throws Exception
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
                .getResourceAsStream("server/servlet/web.xml"), handler);
        List<Entry> entryList = handler.getEntryList();
        List<Mapping> mappingList = handler.getMappingList();


        WebContext webContext = new WebContext(entryList, mappingList);
        //根据url获取类路径
        String className = webContext.getClzByUrl("/log");
        //通过反射获取类与对象
        Class<?> aClass = Class.forName(className);
        Servlet servlet = (Servlet) aClass.getConstructor().newInstance();
        //调用对象方法
        servlet.start();

    }

}
