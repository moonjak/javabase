package PrintIO;

import java.io.*;

/**
 * 打印流
 * */
public class PrintIOTest {

    public static void main(String[] args) throws IOException {

        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        PrintStream ps = new PrintStream(new BufferedOutputStream (new FileOutputStream("print.txt")), true);
        for (String temp; !(temp = reader.readLine()).equals("out");)
        {
            ps.println(temp);
        }

        //输出打印流重定向（原来为控制台输出， 现在转为print.txt）
        System.setOut(ps);
        System.out.println("输出重定向");
        ps.close();
        reader.close();
        //重定向为控制台
        System.setOut(new PrintStream(new BufferedOutputStream (new FileOutputStream(FileDescriptor.out)),true));
        System.out.println("输出重定向控制台");


    }
}