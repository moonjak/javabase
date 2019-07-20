package synchornized;

/**
 * 取钱
 * */
public class GetMoney implements Runnable
{
    private Account account;
    //取钱
    private int cost;

    public GetMoney (Account account, int cost)
    {
        this.account = account;
        this.cost = cost;
    }
    @Override
    public void run()
    {
        subMoney ();
    }

    private void subMoney()
    {
        synchronized (account)
        {
            if (account.getMoney() - cost < 0)
            {
                return;
            }
            try
            {
                Thread.sleep(200);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

            account.setMoney(account.getMoney() - cost);
        }
        System.err.println(Thread.currentThread().getName() + "取钱：" + cost + "余额：" + account.getMoney());

    }

    public static void main(String[] args) throws InterruptedException
    {
        Account account = new Account(100);
        Thread thread1 = new Thread(new GetMoney(account, 50), "xili");
        Thread thread2 = new Thread(new GetMoney(account, 80), "llx");
        thread2.start();
        thread1.start();

    }
}
