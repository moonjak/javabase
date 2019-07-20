package synchornized;

/**
 * 账户
 * */
public class Account
{
    //余额
    private int money;

    public Account(int money)
    {
        this.money = money;
    }

    public int getMoney()
    {
        return money;
    }

    public void setMoney(int money)
    {
        this.money = money;
    }
}
