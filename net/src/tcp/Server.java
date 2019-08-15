package tcp;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * */
public class Server
{

    public static void main(String[] args) throws IOException
    {
        //指定端口号，创建服务端
        ServerSocket server = new ServerSocket(8080);

        //阻塞式建立连接accept
        Socket accept = server.accept();

        //获取输出流，读取数据
        DataInputStream dis = new DataInputStream(accept.getInputStream());
        String readUTF = dis.readUTF();
        System.err.println("接收数据为：" + readUTF);
        dis.close();

        //关闭连接
        server.close();
    }
}
