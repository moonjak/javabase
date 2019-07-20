package conver;

import org.apache.commons.io.FileUtils;

import java.io.*;

/**
 * InputStreamReader、OutputStreamWriter
 * 1、以字符流的形式操作字节流
 * 2、指定字符集
 *
 * */
public class ConvertTest {

    public static void main(String[] args) throws IOException {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        for (String keyCode = ""; !keyCode.equals("exits"); keyCode = bis.readLine())
        {
            bw.write(keyCode);
            bw.newLine();
            bw.flush();//刷新缓存
        }
        bw.close();

        bis.close();
    }


}
