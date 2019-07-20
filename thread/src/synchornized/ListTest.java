package synchornized;

import java.util.ArrayList;
import java.util.List;

public class ListTest
{
    public static void main (String [] arg) throws InterruptedException
    {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < 10000; i++)
        {
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }

        Thread.sleep(2000);
        System.err.println(list.size());
    }
}
