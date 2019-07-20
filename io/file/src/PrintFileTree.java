import java.io.File;
import java.io.IOException;
import java.util.Collections;

/**
 * 递归打印文件名称
 * */
public class PrintFileTree {
    public static void main(String[] args) throws IOException {
        print(new File("C:\\Users\\Administrator\\Desktop\\tt"), 1);
    }

    private static void print (File file, int level)
    {
        String replace = Collections.nCopies(level, "-").toString().replace(",", "").replace("[", "").replace("]", "");
        System.out.println(level + "-"+ file.getPath());
        if (file.isDirectory())
        {
            level++;
            File[] listFiles = file.listFiles();
            for (File subFile : listFiles)
            {
                print(subFile, level);
            }
        }
    }
}
