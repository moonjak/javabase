package start;

import jdk.nashorn.internal.objects.annotations.Where;

/**
 * 创建：实现Runnable , 重写run
 * 启动：new Thread (runnable).start();Thread代理启动
 *
 * */
public class StartRunnable implements Runnable
{
    @Override
    public void run()
    {
        while (true)
        {
            System.err.println("买守破离");
        }
    }

    public static void main(String[] args)
    {

        StartRunnable startRunnable = new StartRunnable();
        //创建代理对象性
        new Thread(startRunnable).start();
        while (true)
        {
            System.out.println("学习线程----------!");//main线程
        }
    }

}
