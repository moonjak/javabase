package server.prepare;

import org.xml.sax.SAXException;
import server.prepare.sax.Employee;
import server.prepare.sax.EmployeeHandler;
import server.prepare.sax.PHandler;

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
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException
    {
        //1.获取解析工厂
        SAXParserFactory saxfac = SAXParserFactory.newInstance();
        //2.从工厂中获取解析器
        SAXParser saxparser = saxfac.newSAXParser();
        //3.编写处理器

        //4.加载文档Document注册处理器
        EmployeeHandler handler = new EmployeeHandler();
        //5.解析
        saxparser.parse(Thread.currentThread().getContextClassLoader()
                .getResourceAsStream("server/prepare/p.xml"), handler);
        List<Employee> employees = handler.getEmployees();
        System.err.println(employees);


    }

}
