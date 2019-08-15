package udp.chat;

public class test1
{
    public static void main(String[] args) {
        Thread send  = new Thread(new UdpClient(8090, 8801));
        Thread receive  = new Thread(new UdpServer(8800));
        send.start();
        receive.start();
    }
}
