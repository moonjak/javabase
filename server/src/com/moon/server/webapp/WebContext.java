package com.moon.server.webapp;

import com.moon.server.Servlet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分析url与clz关系
 * */
public class WebContext
{
    private List<Entry> entryList;
    private List<Mapping> mappingList;

    /** key:name,value:clz*/
    private Map <String,String> entryMap = new HashMap<String,String>();
    /** key:pattern,value:name*/
    private Map <String,String> patternMap = new HashMap<String,String>();

    public WebContext (List<Entry> entryList, List<Mapping> mappingList)
    {
        this.entryList = entryList;
        this.mappingList = mappingList;

        for (Entry entry : entryList)
        {
            entryMap.put(entry.getName(), entry.getClz());
        }
        for (Mapping mapping : mappingList)
        {
            for (String pattern : mapping.getPatternList())
            {
                patternMap.put(pattern, mapping.getName());
            }
        }
    }

    /**
     * 根据url获取类路径clz
     * */
    public String getClzByUrl (String url)
    {
        String name = patternMap.get(url);
        return entryMap.get(name);
    }


}
