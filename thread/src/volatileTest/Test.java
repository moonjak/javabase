package volatileTest;

public class Test
{
    private volatile static int a = 0;
    public static void main (String[] args) throws InterruptedException
    {
        new Thread(()->{
            while (a==0) {}
        }).start();

        Thread.sleep(1000);
        a = 1;
    }

}
