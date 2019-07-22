package synchornized.w12306;

/**
 * 乘客
 */

public class Buyer extends Thread
{
    private int buyseat;
    private String buyname;
    public Buyer (Runnable web, String name, int seat)
    {
        super(web,name);
        this.buyname = name;
        this.buyseat = seat;
    }

    public int getBuyseat()
    {
        return buyseat;
    }

    public void setBuyseat(int buyseat)
    {
        this.buyseat = buyseat;
    }

    public String getBuyname()
    {
        return buyname;
    }

    public void setBuyname(String buyname)
    {
        this.buyname = buyname;
    }
}
