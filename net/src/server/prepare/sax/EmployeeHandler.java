package server.prepare.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeHandler extends DefaultHandler
{
    private List<Employee> employees;
    private Employee employee;
    /** 标签*/
    private String tag;
    /** 记录标签是否可以读值*/
    @Override
    public void startDocument() throws SAXException
    {
        employees = new ArrayList<Employee>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        tag = qName;
        if (qName.equals("employee"))
        {
            employee = new Employee();
        }
    }


    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {

        String s = new String(ch, start, length).trim();
        if (tag ==null || s.length() == 0)
        {
            return;
        }
        if (tag.equals("name"))
        {
            employee.setName(s);
        }
        else if (tag.equals("sex"))
        {
            employee.setSex(s);
        }
        else if (tag.equals("age"))
        {
            employee.setAge(s);
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equals("employee"))
        {
            employees.add(employee);
        }
    }

    @Override
    public void endDocument() throws SAXException
    {
        System.out.println("---解析文档结束---");
    }

    public List<Employee> getEmployees()
    {
        return employees;
    }
}
