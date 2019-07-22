package synchornized.produce;

public class Buyer implements Runnable
{
    private Store store;

    public Buyer(Store store)
    {
        this.store = store;
    }
    @Override
    public void run()
    {
        for (int i = 0; i < 120;i++)
        {
            store.pop();
        }
    }
}
