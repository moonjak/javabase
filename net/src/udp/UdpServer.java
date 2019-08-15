package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备 封装容器DatagramPacket
 * 3、阻塞式接收包裹receive
 * 4、分析数据
 * */
public class UdpServer
{
    public static void main(String[] args) throws IOException
    {
        //创建接收端
        DatagramSocket server = new DatagramSocket(8887);
        System.out.println("接收方启动中");
        //准备 封装容器DatagramPacket
        byte[] bytes = new byte[2014];
        DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length);
        //阻塞式接收包裹
        server.receive(dp);
        //分析数据
        byte[] data = dp.getData();
        System.err.println(new String(data,0,data.length));
    }
}
