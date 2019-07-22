package lock;

/**
 * 可重入锁
 * */
public class Lock
{
    private boolean locked = false;

    private Thread lockedBy;

    private int count = 0;

    public synchronized void lock () throws InterruptedException
    {
        Thread thread = Thread.currentThread();
        if (locked && lockedBy != thread)//是当前线程则可以重入
        {
            wait();
        }
        locked = true;
        lockedBy = thread;
        count++;
    }

    public synchronized void unlock () throws InterruptedException
    {
       locked = false;
        count--;
       notify();
    }
}
