package start;

/**
 * runnable共享资源
 * 买票案列
 *
 * */
public class MaiPiao implements Runnable
{
    /**/
    private int count = 100;
    @Override
    public void run()
    {
        for (;count>0;count--)
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            System.err.println(Thread.currentThread().getName() + "买到票，剩余票数：" + count);
        }
    }

    public static void main(String[] args)
    {
        MaiPiao maiPiao = new MaiPiao();
        new Thread(maiPiao,"a").start();
        new Thread(maiPiao,"b").start();
        new Thread(maiPiao,"c").start();
    }
}
