package synchornized.produce;

/**
 * 并发协作：生产消费者（管程法）
 * */
public class Test
{
    public static void main (String [] arg) throws InterruptedException
    {
        Store store = new Store();

        Thread cooker = new Thread(new Cooker(store));
        Thread buyer = new Thread(new Buyer(store),"buyer");
        Thread buyer1 = new Thread(new Buyer(store),"buyer1");
        Thread buyer2 = new Thread(new Buyer(store),"buyer2");
        cooker.setPriority(2);
        cooker.start();
        buyer.start();
//        buyer1.start();
//        buyer2.start();

//        while (true)
//        {
//            Thread.sleep(1000);
//            System.out.println("----------------------");
//
//            System.out.println("buyer" + buyer.isAlive());
//            System.out.println("buyer1" + buyer1.isAlive());
//            System.out.println("buyer2" + buyer2.isAlive());
//
//        }
    }
}
