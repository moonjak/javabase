package synchornized.produce;

/**
 * 厨师
 * */
public class Cooker implements Runnable
{
    private Store store;

    public Cooker(Store store)
    {
        this.store = store;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 310;i++)
        {
            store.push();
        }
    }
}
