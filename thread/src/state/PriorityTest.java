package state;

public class PriorityTest
{
    public static void main(String[] args) throws InterruptedException
    {
        Thread thread = new Thread(()->{
            System.err.println("Priority优先级测试");
        });
        thread.setPriority(1);
    }

}
