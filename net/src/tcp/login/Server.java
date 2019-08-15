package tcp.login;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务端
 * */
public class Server
{
    private static String user = "xia";
    private static String pw = "xia";

    public static void main(String[] args) throws IOException
    {

        //指定端口号，创建服务端
        ServerSocket server = new ServerSocket(8080);

        //阻塞式建立连接accept
        Socket accept = server.accept();

        //获取输出流，读取数据
        DataInputStream dis = new DataInputStream(accept.getInputStream());
        String readUTF = dis.readUTF();
        String[] split = readUTF.split("&");
        String loguser = "";
        String logpw = "";
        for (String s : split)
        {
            String[] split1 = s.split("=");
            if (split1 [0].equals("user"))
            {
                loguser = split1 [1];
            }
            if (split1 [0].equals("pw"))
            {
                logpw = split1 [1];
            }
        }
        DataOutputStream dos = new DataOutputStream(accept.getOutputStream());

        if (loguser.equals(user) && pw.equals(logpw))
        {
            System.err.println("登录成功");
            dos.writeUTF("登录成功");
        }
        else
        {
            System.err.println("登录失败");
            dos.writeUTF("登录失败");
        }
        System.err.println("接收数据为：" + readUTF);
        dos.close();
        dis.close();
        //关闭连接
        server.close();
    }
}
