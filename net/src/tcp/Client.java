package tcp;


import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 * */
public class Client
{
    public static void main(String[] args) throws IOException
    {
        //指定地址，端口号建立连接
        Socket client = new Socket("localhost", 8080);
        //获取输出流输出数据
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF("学习网络编程");

        //释放资源
        dos.close();
        client.close();
    }
}
