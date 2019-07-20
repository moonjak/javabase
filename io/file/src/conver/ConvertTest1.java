package conver;

import java.io.*;
import java.net.URL;

/**
 * InputStreamReader、OutputStreamWriter
 * 1、以字符流的形式操作字节流
 * 2、指定字符集
 *
 * */
public class ConvertTest1 {

    public static void main(String[] args) throws IOException {
        //操作网络流，下载百度的网页的源代码(可以解决乱码问题)
       InputStream is = new URL("http://www.baidu.com").openStream();
       BufferedReader bf = new BufferedReader(new InputStreamReader(is, "utf-8"));

       BufferedWriter bfw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.xml"), "utf-8"));
       for (String temp = ""; (temp = bf.readLine()) != null;)
       {
           bfw.write(temp);
       }
        bfw.close();
        bf.close();

    }


}
