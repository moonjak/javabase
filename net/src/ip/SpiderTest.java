package ip;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 网络盘爬虫原理 + 模拟浏览器（有些网站不能直接获取连接，需模拟浏览器）
 * */
public class SpiderTest
{
    public static void main(String[] args) throws IOException
    {
        //获取url
        URL url = new URL("https://www.tmall.com/");

        //模拟浏览器
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("user-agent","Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/63.0.3239.132 Safari/537.36");
        InputStream inputStream1 = conn.getInputStream();
        //获取输出流
        InputStream inputStream = url.openStream();
        BufferedReader bf = new BufferedReader(new InputStreamReader(inputStream1));

        for (String temp = "" ; (temp = bf.readLine()) != null;)
        {
            System.out.println(temp);
        }
    }
}
