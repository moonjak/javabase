package start;

/**
 *  继承Thread
 *  重写run
 * */
public class StartThread extends Thread{
    @Override
    public void run() {
        while (true)
        {
            System.out.println("写代码");
        }
    }
}
