package timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 定时任务调度 Timer与TimerTask
 * */
public class TimerTest
{
    public static void main(String[] args)
    {
       Timer timer = new Timer();
       timer.schedule(new MyTask(),1000, 3000);
    }
}

class MyTask extends TimerTask
{

    @Override
    public void run()
    {
        System.out.println("休息一会儿。。。");
    }
}
