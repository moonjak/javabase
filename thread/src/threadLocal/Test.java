package threadLocal;


/**
 * ThreadLocal 线程本地存储
 * */
public class Test
{
    public static void main(String[] args)
    {
       ThreadLocal local = new ThreadLocal();
       local.set("s");
       local.get();
    }
}
