package state;

public class DaemonTest
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(()->{
            System.err.println("守护线程");
        });
        thread.setDaemon(true);
    }
}
