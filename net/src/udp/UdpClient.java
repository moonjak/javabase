package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

/**
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、准备数据 必须转成字节数组
 * 3、封装成DatagramPacket,需指定目的地
 * 4、发送包裹send(DatagramPacket packet)
 * 5、释放资源
 * */

public class UdpClient
{
    public static void main(String[] args) throws IOException
    {
        System.out.println("发送方启动中");

        //创建发送端
        DatagramSocket client = new DatagramSocket(8888);

        String msg = "udp学习";
        //准备数据 必须转成字节数组
        byte[] bytes = msg.getBytes("utf-8");
        //封装成DatagramPacket,需指定目的地
        DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost",8887));
        //发送包裹
        client.send(dp);
        System.out.println("发送数据：" + msg);
        //释放资源
        client.close();
    }
}
