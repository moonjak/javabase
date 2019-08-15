package udp.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 1、使用DatagramSocket 指定端口 创建发送端
 * 2、准备数据 必须转成字节数组
 * 3、封装成DatagramPacket,需指定目的地
 * 4、发送包裹send(DatagramPacket packet)
 * 5、释放资源
 * */

public class UdpClient implements Runnable
{
    private int port;
    private int localport;

    public UdpClient(int localport, int port)
    {
        this.port = port;
        this.localport = localport;
    }

    @Override
    public void run()
    {
        System.out.println("发送方启动中");
        try
        {
            //创建发送端
            DatagramSocket client =  new DatagramSocket(localport);
            for ( String msg = ""; msg != "out";)
            {
                BufferedReader bfr = new BufferedReader(new InputStreamReader(System.in));
                msg = bfr.readLine();
                //准备数据 必须转成字节数组
                byte[] bytes = msg.getBytes("utf-8");
                //封装成DatagramPacket,需指定目的地
                DatagramPacket dp = new DatagramPacket(bytes, 0, bytes.length, new InetSocketAddress("localhost", port));
                //发送包裹
                client.send(dp);
               // System.out.println("发送数据：" + msg);
            }
            //释放资源
            client.close();
        } catch (SocketException e)
        {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        } catch (IOException e)
        {
            e.printStackTrace();
        }


    }
}
