package dataio;

import java.io.*;

public class DataIOTest {

    public static void main(String[] args) throws IOException {

        DataOutputStream bso = new DataOutputStream(new FileOutputStream("dataIO.txt"));
        bso.writeBoolean(true);
        bso.writeDouble(0d);
        DataInputStream dis = new DataInputStream(new FileInputStream("dataIO.txt"));
        System.err.println(dis.readBoolean());
        System.err.println(dis.readDouble());
        bso.close();
        dis.close();
    }
}