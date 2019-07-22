package synchornized.seemoive;

import java.util.ArrayList;
import java.util.List;

/**
 * 电影院
 * */
public class Cinema
{
    /** 座位*/
    private List <Integer> seats;
    /** 电影院名称*/
    private String name;

    public Cinema(List<Integer> seats, String name)
    {
        this.seats = seats;
        this.name = name;
    }

    /** 卖票*/
    public boolean sellTicket (List <Integer> delSeats)
    {
        List<Integer> copy = new ArrayList<>();

        synchronized (this)
        {
            copy.addAll(seats);
            try
            {
                Thread.sleep(2000);//买票延迟
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            copy.removeAll(delSeats);

            if ((seats.size() - copy.size()) != delSeats.size())
            {
                return false;
            }
            seats = copy;
            return true;
        }
    }

    public List<Integer> getSeats()
    {
        return seats;
    }

    public void setSeats(List<Integer> seats)
    {
        this.seats = seats;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }
}
