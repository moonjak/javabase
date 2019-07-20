package start;

import java.util.concurrent.*;
/**
 * 实现Callable
 * */
public class StartCallable implements Callable<Object>
{
    @Override
    public Object call() throws Exception
    {
        System.err.println("学习线程。。。");
        return null;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException
    {
        StartCallable sc = new StartCallable();
        //创建服务
        ExecutorService  service = Executors.newFixedThreadPool(1);
        Future<Object> result = service.submit(sc);

        //获取结果
        Object o = result.get();

        //关闭服务
        service.shutdownNow();
    }
}
