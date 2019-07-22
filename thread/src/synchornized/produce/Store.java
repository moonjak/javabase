package synchornized.produce;

/**
 * 仓库
 * */

public class Store
{
    //面包仓库，容量100
    private String [] bread = new String[100];

    //面包数计数
    private int count = 0;

    //仓库放入面包
    public synchronized void push()
    {
        //仓库满时，停止生产
        if (count == bread.length)
        {
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        bread[count] = new String();
        count ++;
        System.out.println("生产---面包，二维码：" + bread[count-1] + "面包数量--" + count);
        notifyAll();
    }

    //仓库拿出面包
    public synchronized void pop()
    {
        //面包不够时， 停止拿出面包，且通知生产
        if (count == 0)
        {
            try
            {
                this.wait();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName() + "消费--面包，二维码：" + bread[count-1] + "面包数量--" + (count-1));
        bread[--count] = null;
        this.notifyAll();
    }
}
