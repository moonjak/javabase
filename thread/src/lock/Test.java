package lock;

public class Test
{
    public static Lock lock = new Lock();
    public static void main(String[] args) throws InterruptedException
    {
        lock.lock();
        doAdd();
        lock.unlock();
    }

    private static void doAdd() throws InterruptedException
    {
        lock.lock();
        System.out.println("23424");
        lock.unlock();
    }


}
