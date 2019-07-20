package file;

import java.io.File;
import java.io.IOException;

public class Test1 {
    public static void main(String[] args) throws IOException {
        //创建文件对象
        File file = new File("F:\\IdeaProject\\JavaBase\\io\\file\\src\\file\\Test1.java");
        File subFile = new File(file, ".git.ignore");
        File subFile1 = new File("C:\\Users\\Administrator\\Desktop\\repository\\gittest\\ssm", ".git.ignore");

        System.err.println(System.getProperty("user.dir"));

        //绝对路径
        System.err.println(file.getAbsolutePath());
        System.err.println(subFile.getAbsolutePath());
        System.err.println(file.getPath());
        System.err.println(file.getCanonicalFile());
        System.err.println(file.getFreeSpace());



    }
}


