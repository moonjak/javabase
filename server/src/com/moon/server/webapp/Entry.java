package com.moon.server.webapp;

/**
 *  <servlet>
 *         <servlet-name>ServletName</servlet-name>
 *         <servlet-class>FullyQualifiedName</servlet-class>
 *  </servlet>
 */

public class Entry
{
    private String name;
    private String clz;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getClz()
    {
        return clz;
    }

    public void setClz(String clz)
    {
        this.clz = clz;
    }

    @Override
    public String toString()
    {
        return "Entry{" +
                "name='" + name + '\'' +
                ", clz='" + clz + '\'' +
                '}';
    }
}
