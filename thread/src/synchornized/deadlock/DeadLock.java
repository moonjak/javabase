package synchornized.deadlock;


import synchornized.w12306.Buyer;
import synchornized.w12306.Web12306;

class Mouse {}
class Key{}
/**
 * 模拟小红小明，使用键盘鼠标场景
 * 使用完其中一个紧接使用另外一个
 * */
public class DeadLock implements Runnable
{
    private static Mouse mouse = new Mouse();
    private static Key key = new Key();
    /** 现在使用键盘或鼠标 ： 1键盘，2鼠标*/
    private int chose;
    public DeadLock (int chose)
    {
        this.chose = chose;
    }

    @Override
    public void run()
    {
        if (chose == 1)
        {
            synchronized (mouse)
            {
                System.err.println(Thread.currentThread().getName() + "使用鼠标");
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                synchronized (key)
                {
                    System.err.println(Thread.currentThread().getName() + "使用键盘");
                }
            }
        }
        else
        {
            synchronized (key)
            {
                System.err.println(Thread.currentThread().getName() + "使用键盘");
                try
                {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                synchronized (mouse)
                {
                    System.err.println(Thread.currentThread().getName() + "使用鼠标");
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
       Thread xiaoming = new Thread(new DeadLock(1),"xiaoming");
        Thread xiaohong = new Thread(new DeadLock(2), "xiaohong");
        xiaohong.start();
        xiaoming.start();

    }
}
