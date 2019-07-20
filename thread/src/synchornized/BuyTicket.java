package synchornized;

public class BuyTicket implements Runnable
{
    //票数
    private int total = 10;
    @Override
    public synchronized void run()
    {
        while (total > 0)
        {
            try
            {
                Thread.sleep(100);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            buy();
            System.err.println(Thread.currentThread().getName() + "买票，剩余票数：" + total);
        }
    }

    private void buy ()
    {
        total --;
    }


    public static void main(String[] args) throws InterruptedException
    {
        BuyTicket buyTicket = new BuyTicket ();
        Thread thread = new Thread(buyTicket,"黄牛a");
        Thread thread1 = new Thread(buyTicket,"黄牛b");
        thread.start();
        thread1.start();

    }
}
