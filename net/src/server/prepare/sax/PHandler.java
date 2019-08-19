package server.prepare.sax;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PHandler extends DefaultHandler
{
    @Override
    public void startDocument() throws SAXException
    {
        System.out.println("---解析文档开始---");
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        System.out.println(qName + "--->解析开始");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException
    {
        String s = new String(ch, start, length).trim();
        if (s.length() == 0)
        {
            System.out.println("内容为：" + null);

        }
        else
        {
            System.out.println("内容为：" + s);
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        System.out.println(qName + "--->解析结束");
    }

    @Override
    public void endDocument() throws SAXException
    {
        System.out.println("---解析文档结束---");
    }
}
