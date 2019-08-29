package com.moon.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.*;

/**
 * @author zgui
 * @function 请求内容封装
 * @createTime 2019/8/29 14:12
 */
public class Request
{
    private String requestContext;

    /** 请求方法*/
    private String method;
    /** 请求地址*/
    private String url;
    /** 请求参数*/
    private String paramString;

    private Map<String, List<String>> paramMap;

    private final String crlf = "\r\n";

    public Request (Socket client) throws IOException
    {
        this(client.getInputStream ());
    }

    public Request (InputStream inputStream)
    {
        paramMap = new HashMap<String, List<String>> ();
        byte[] datas = new byte [1024*1024];
        try
        {
            int read = inputStream.read (datas);
            requestContext = new String (datas, 0, read);
            System.err.println (requestContext);
            //解析请求内容
            this.parseContext ();
        }
        catch (IOException e)
        {
            e.printStackTrace ();
        }
    }

    private void parseContext()
    {
        method = requestContext.substring (0, requestContext.indexOf ("/")).trim ();
        String urlParam = requestContext.substring (requestContext.indexOf ("/") + 1, requestContext.indexOf ("HTTP/")).trim ();
        if (!urlParam.contains ("?"))
        {
            url = urlParam;
        }
        else
        {
            url = urlParam.substring (0, urlParam.indexOf ("?"));
            paramString = urlParam.substring (urlParam.indexOf ("?") + 1, urlParam.length ());
        }
        if (method.equals ("POST"))
        {
            paramString += "&" + requestContext.substring (requestContext.lastIndexOf (crlf) + crlf.length (), requestContext.length ());
        }
        paramString = paramString == null ? "" : paramString;
        System.err.println (method + "--->" + url + "--->" + paramString);
        initParamMap();
    }

    /**
     * 封装参数
     * */
    private void initParamMap()
    {
        if (paramString == null || paramString.length () == 0)
        {
            return;
        }
        String[] params = paramString.split ("&");
        for (String s : params)
        {
            String[] param = s.split ("=");
            param = Arrays.copyOf (param,2);
            String key = param[0];
            String value = param [1];
            if (!paramMap.containsKey (key))
            {
                paramMap.put (key, new ArrayList<String> ());
            }
            paramMap.get (key).add (value);
        }
    }

    public List<String> getValue(String key)
    {
        return paramMap.get (key);
    }

    public String getRequestContext ()
    {
        return requestContext;
    }

    public void setRequestContext (String requestContext)
    {
        this.requestContext = requestContext;
    }

    public String getMethod ()
    {
        return method;
    }

    public void setMethod (String method)
    {
        this.method = method;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    public String getParamString ()
    {
        return paramString;
    }

    public void setParamString (String paramString)
    {
        this.paramString = paramString;
    }

    public Map<String, List<String>> getParamMap ()
    {
        return paramMap;
    }

    public void setParamMap (Map<String, List<String>> paramMap)
    {
        this.paramMap = paramMap;
    }
}
