package server.servlet;

import java.util.HashSet;
import java.util.Set;

/**
 * <servlet-mapping>
 *         <servlet-name>ServletName</servlet-name>
 *         <url-pattern>URL</url-pattern>
 *         <url-pattern>URL</url-pattern>
 * </servlet-mapping>
 * */
public class Mapping
{
    private String name;
    private Set<String> patternList;

    public Mapping()
    {
        patternList = new HashSet<String>();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Set<String> getPatternList()
    {
        return patternList;
    }

    public void setPatternList(Set<String> patternList)
    {
        this.patternList = patternList;
    }

    public void addPattern(String pattern)
    {
        this.patternList.add(pattern);
    }

    @Override
    public String toString()
    {
        return "Mapping{" +
                "name='" + name + '\'' +
                ", patternList=" + patternList +
                '}';
    }
}
