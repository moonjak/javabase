import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Vector;

public class Main {

    public static void main(String[] args) throws IOException {

        System.err.println(System.getProperty("user.dir"));//获取当前文件路径

        File file = new File("C:\\Users\\Administrator\\Desktop\\file.txt");
        System.err.println("file是否存在：" + file.exists());
        System.err.println("file文件名：" + file.getName());
        System.err.println("file是否是目录：" + file.isDirectory());
        System.err.println("file是否是文件：" + file.isFile());

        System.err.println("file最后修改时间：" + new Date(file.lastModified()));
        System.err.println("file文件大小：" + file.length());
        System.err.println("file文件路径：" + file.getPath());
        System.err.println("file文件路径：" + file.getAbsolutePath());
        System.err.println("file文件路径：" + file.getCanonicalPath());

        /**
         * mkdir 与 mkdirs创建目录
         * mkdir文件目录有一个不存在，就不会创建
         * mkdirs会根据路径创建文件目录， 不管路径存不存在
         * */
        File file1 = new File("C:\\Users\\Administrator\\Desktop\\tt\\aa\\stt\\a.txt");
        boolean mkdir = file1.mkdir();
        boolean mkdirs = file1.mkdirs();
        //

    }
}
