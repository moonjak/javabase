package synchornized.seemoive;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BuyMoveTicket implements Runnable
{
    private Cinema cinema;

    private List <Integer> buySeats;

    public BuyMoveTicket(Cinema cinema, List<Integer> buySeats)
    {
        this.cinema = cinema;
        this.buySeats = buySeats;
    }

    @Override
    public void run()
    {
        if (cinema.sellTicket(buySeats))
        {
            System.err.println(Thread.currentThread().getName() + "买位置：" + buySeats +"--买票成功---->剩余位置" + cinema.getSeats());
        }
        else
        {
            System.err.println(Thread.currentThread().getName() + "买位置：" + buySeats +"--买票失败---->剩余位置" + cinema.getSeats());
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        Cinema cinema = new Cinema(Arrays.asList(1,2,3,4,5,6,7,8,9), "巨幕影院");

        Thread xiaoMing = new Thread(new BuyMoveTicket(cinema, Arrays.asList(1,2,3,4,5)), "xiaoMing");
        Thread xiaoHong = new Thread(new BuyMoveTicket(cinema, Arrays.asList(5,6,7)), "xiaoHong");
        xiaoHong.setPriority(10);
        xiaoMing.start();
        xiaoHong.start();
    }
}
