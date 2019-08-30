package com.moon.server.webapp;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

/**
 * web.xml解析器
 * */
public class WebHandler extends DefaultHandler
{
    private List<Entry> entryList;
    private List<Mapping> mappingList;
    private Entry entry;
    private Mapping mapping;
    /** 标签*/
    private String tag;
    /** 记录标签是否是Mapping*/
    private boolean isMapping = false;
    @Override
    public void startDocument() throws SAXException
    {
        entryList = new ArrayList<Entry>();
        mappingList = new ArrayList<Mapping>();
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException
    {
        tag = qName;
        if (qName.equals("servlet"))
        {
            entry = new Entry();
            isMapping = false;
        }
        else if (qName.equals("servlet-mapping"))
        {
            mapping = new Mapping();
            isMapping = true;
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
        if (!isMapping)
        {
            if (tag.equals("servlet-name"))
            {
                entry.setName(s);
            }
            else if (tag.equals("servlet-class"))
            {
                entry.setClz(s);
            }
        }
        else
        {
            if (tag.equals("servlet-name"))
            {
                mapping.setName(s);
            }
            else if (tag.equals("url-pattern"))
            {
                mapping.addPattern(s);
            }
        }

    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException
    {
        if (qName.equals("servlet"))
        {
            entryList.add(entry);
        }
        else if (qName.equals("servlet-mapping"))
        {
            mappingList.add(mapping);
        }
    }

    @Override
    public void endDocument() throws SAXException
    {
        System.out.println("---解析文档结束---");
    }

    public List<Entry> getEntryList()
    {
        return entryList;
    }

    public List<Mapping> getMappingList()
    {
        return mappingList;
    }
}
