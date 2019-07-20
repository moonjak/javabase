package state;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class Join
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread1 thread1 = new Thread1();

        thread1.setName("join1");

        thread1.start();

        for (int a = 1; a < 10; a++)
        {
            if (a==5)
            {
                thread1.join();
            }
            System.err.println(Thread.currentThread().getName() + "----" + a);
        }
    }
}

class Thread1 extends Thread
{
    @Override
    public void run()
    {
        for (int a = 1; a < 10; a++)
        {
            System.err.println(Thread.currentThread().getName() + "----" + a);
        }
    }
}
