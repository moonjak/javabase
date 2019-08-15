package tcp.login;


import java.io.*;
import java.net.Socket;

/**
 * 客户端
 * */
public class Client
{
    public static void main(String[] args) throws IOException
    {
        Socket client = new Socket("localhost", 8080);
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String user = bf.readLine();
        BufferedReader bf1 = new BufferedReader(new InputStreamReader(System.in));
        String pw = bf1.readLine();
        dos.writeUTF("user=" + user + "&" + "pw=" + pw);

        DataInputStream dis = new DataInputStream(client.getInputStream());
        System.err.println(dis.readUTF());
        dis.close();
        dos.close();
        client.close();
    }
}
