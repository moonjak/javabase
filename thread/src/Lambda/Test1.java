package Lambda;

import java.util.ArrayList;
import java.util.List;

public class Test1
{
    public static void main (String[] args)
    {
        List list = new ArrayList();
        list.add("asdas");
        list.forEach(System.err::println);
    }
}
