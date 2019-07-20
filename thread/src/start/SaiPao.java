package start;

import java.util.concurrent.*;

/**
 * 模拟龟兔赛跑， 跑完100步，比赛结束
 *
 * */
public class SaiPao implements Callable<String>
{
    private String winner;
    @Override
    public String call()
    {
        for (int speed = 1; speed <= 100;speed++)
        {
            System.err.println(Thread.currentThread().getName() + "跑步数：" + speed);
            boolean isover = seeResult(speed);//比赛是否结束
            if (isover)
            {
                return winner;
            }
        }
        return winner;
    }

    private boolean seeResult(int speed)
    {
        if (winner != null)
        {
            System.err.println("比赛结束，获胜者是" + winner);
            return true;
        }
        if (speed == 100)
        {
            winner = Thread.currentThread().getName();
            return true;
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        SaiPao saiPao = new SaiPao();
        ExecutorService service = Executors.newFixedThreadPool(2);
        Future<String> r1 = service.submit(saiPao);
        Future<String> r2 = service.submit(saiPao);
        String winner = r1.get();
        String winner2 = r2.get();
        System.err.println(winner);
        System.err.println(winner2);

        service.shutdownNow();

    }

}
