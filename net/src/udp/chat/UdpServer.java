package udp.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * 1、使用DatagramSocket 指定端口 创建接收端
 * 2、准备 封装容器DatagramPacket
 * 3、阻塞式接收包裹receive
 * 4、分析数据
 * */
public class UdpServer implements Runnable
{
    private int port;

    public UdpServer(int port)
    {
        this.port = port;
    }

    @Override
    public void run()
    {
        DatagramSocket server = null;
        try
        {
            server = new DatagramSocket(port);
            System.out.println("接收方启动中");
            for (String receive = ""; receive != "out";)
            {
                //准备 封装容器DatagramPacket
                byte[] bytes = new byte[2014];
                DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length);
                //阻塞式接收包裹
                server.receive(dp);
                //分析数据
                byte[] data = dp.getData();
                receive = new String(data, 0, data.length);
                System.err.println("接收数据：" + receive);
            }
        } catch (SocketException e)
        {
            e.printStackTrace();

        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
