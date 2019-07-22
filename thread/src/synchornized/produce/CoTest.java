package synchornized.produce;

/**
 * 模拟看电视，电视里演员一边输出内容， 观众一边接收内容
 * */
public class CoTest
{
    public static void main (String [] arg) throws InterruptedException
    {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();

    }
}

class Tv
{
    private String context;

    private boolean fl = true;


    public synchronized void show (String context)
    {
        if (!fl)
        {
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        this.context = context;
        System.out.println("演员表演：" + context);

        this.notifyAll();
        fl = !fl;
    }


    public synchronized void watch ()
    {
        if (fl)
        {
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println("观众看到：" + context);
        this.notifyAll();
        fl = !fl;
    }
}

/** 表演者*/
class Player extends Thread
{
    private Tv tv;

    public Player(Tv tv)
    {
        this.tv = tv;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 20;i++)
        {
           if (i%2==0)
           {
               tv.show("唱歌");
           }
           else
           {
               tv.show("铁门槛");
           }
        }
    }
}

/** 观众*/
class Watcher extends Thread
{
    private Tv tv;

    public Watcher(Tv tv)
    {
        this.tv = tv;
    }

    @Override
    public void run()
    {
        for (int i = 0; i < 20;i++)
        {
            tv.watch();
        }
    }
}
