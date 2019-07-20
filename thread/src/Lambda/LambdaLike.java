package Lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaLike
{
    public void like()
    {
//        LambdaTest1 lambdaTest1 = b ->{
//                System.err.println(b);
//        };

        LambdaTest1 lambdaTest1 = (b,a) ->b+a;
        lambdaTest1.like(1,1);
    }
    public static void main (String[] args)
    {
        new LambdaLike().like();

        List list = new ArrayList();
        list.forEach(a->System.err.println("as"));
    }
}
