package udp.chat;

public class test2
{
    public static void main(String[] args) {
        Thread send  = new Thread(new UdpClient(8091, 8800));
        Thread receive  = new Thread(new UdpServer(8801));
        send.start();
        receive.start();
    }
}
