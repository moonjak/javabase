package encode;


import java.io.IOException;
import java.util.Arrays;

/**
 * 编码：字符---》字节
 * 解码：字节---》字符
 * */
public class ContentEncode {
    public static void main(String[] args) throws IOException {
        String msg = "性命生命使命";
        //编码字节数组
        byte[] bytes = msg.getBytes();
        System.err.println(bytes.length + Arrays.toString(bytes));

        //编码其他字符集
        byte[] gbks = msg.getBytes("gbk");
        System.err.println(gbks.length + Arrays.toString(gbks));

        /************************/
        //解码    public String(byte bytes[], int offset, int length, String charsetName)
        String gbk = new String(gbks, 0, gbks.length, "utf-8");
        System.err.println(gbk);


    }
}
