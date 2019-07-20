package start;

public class Test
{
    public static void main(String[] args)
    {

        StartThread startThread = new StartThread();
        startThread.start();//启动学习线程
        while (true)
        {
            System.out.println("学习线程----------!");//main线程
        }
    }

}
