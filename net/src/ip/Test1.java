package ip;

import java.net.*;
import java.util.Arrays;

public class Test1
{
    public static void main(String[] args) throws UnknownHostException, MalformedURLException
    {
        //返回本地主机。
        InetAddress localHost = InetAddress.getLocalHost();
        localHost.getHostAddress();
        localHost.getHostName();
        System.out.println(localHost.getHostName());
        System.out.println(localHost.getHostAddress());

        System.out.println(Arrays.toString(localHost.getAddress()));


        //端口
        InetSocketAddress inetSocketAddress = new InetSocketAddress("192.168.0.102", 808);
        inetSocketAddress.getHostName();
        System.out.println(inetSocketAddress.getHostName());


        URL url = new URL("https://baike.so.com/doc/162735-171954.html");
        url.getProtocol();
        System.out.println("协议：" + url.getProtocol());
        System.out.println("域名|ip：" + url.getHost());
        System.out.println("端口：" + url.getPort());
        System.out.println("请求资源：" + url.getFile());

    }

}
