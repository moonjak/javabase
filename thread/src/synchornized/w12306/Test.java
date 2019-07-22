package synchornized.w12306;

public class Test
{
    public static void main(String[] args) throws InterruptedException
    {
        Web12306 w = new Web12306(2);
        Buyer xiao = new Buyer(w,"xiao", 2);
        Buyer ming = new Buyer(w,"ming", 2);
        xiao.start();
        ming.start();
    }
}
