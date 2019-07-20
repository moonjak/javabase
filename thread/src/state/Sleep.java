package state;

public class Sleep implements Runnable
{
    @Override
    public void run()
    {
        for (int i = 0; i< 10 ;i++)
        {
            System.err.println("运行中。。。");
            try
            {
                Thread.sleep(100);//睡眠，延时导致阻塞
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
