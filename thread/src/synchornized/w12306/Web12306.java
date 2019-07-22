package synchornized.w12306;

public class Web12306 implements Runnable
{
    //剩余位子
    private int seats;
    public Web12306 (int seats)
    {
        this.seats = seats;
    }
    @Override
    public synchronized void run()
    {
        Buyer buyer = (Buyer) Thread.currentThread();
        int count = buyer.getBuyseat();
        if (seats - count < 0)
        {
            System.err.println(buyer.getBuyname() + "买票失败，买票数：" + count + "---->剩余票数：" + seats);
            return;
        }
        try
        {
            Thread.sleep(2000);
        } catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        seats -= count;
        System.err.println(buyer.getBuyname() + "买票成功，买票数：" + count + "---->剩余票数：" + seats);

    }
}
