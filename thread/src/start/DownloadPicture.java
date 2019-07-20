package start;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.net.URL;

public class DownloadPicture extends Thread
{
    //网站
    private String url;
    //文件路径
    private String filepath;

    public DownloadPicture(String name,String url, String filepath)
    {
        super(name);
        this.url = url;
        this.filepath = filepath;
    }

    @Override
    public void run()
    {
        try
        {
            FileUtils.copyURLToFile(new URL(url), new File(filepath));
        } catch (IOException e)
        {
            e.printStackTrace();
        }
        //down();
    }

    private void down ()
    {
        BufferedInputStream bi = null;
        BufferedOutputStream bo = null;
        try
        {
            bi = new BufferedInputStream(new URL(url).openStream());
            bo = new BufferedOutputStream(new FileOutputStream(filepath));
            byte [] temp = new byte[100];
            for (int len = -1;(len = bi.read(temp))!=-1;)
            {
                bo.write(temp,0,len);
                try
                {
                    sleep(5l);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                System.err.println(getName() + "下载中");
            }
            bo.flush();
            System.err.println(getName() + "下载完成-------------------------------");


        } catch (IOException e)
        {
            e.printStackTrace();
        }
        finally
        {
            try
            {
                if (bo!=null)
                {
                    bo.close();
                }
                if (bi!=null)
                {
                    bi.close();
                }
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args)
    {
        DownloadPicture dp1 = new DownloadPicture("图片1","https://p0.ssl.qhimgs1.com/sdr/400__/t01bfff72e2b7cfd5b0.jpg","tp1.png");
        DownloadPicture dp2 = new DownloadPicture("图片2","https://ps.ssl.qhmsg.com/sdr/400__/t01a23a171024dd2105.jpg","tp2.png");
        DownloadPicture dp3 = new DownloadPicture("图片3","https://ps.ssl.qhmsg.com/sdr/400__/t01b2f2ee7855b66177.jpg","tp3.png");
        dp1.start();
        dp2.start();
        dp3.start();
    }
}
