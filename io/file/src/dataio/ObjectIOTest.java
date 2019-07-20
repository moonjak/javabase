package dataio;

import java.io.*;

public class ObjectIOTest {
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        ObjectOutputStream bso = new ObjectOutputStream(new FileOutputStream("objIO.txt"));
        bso.writeBoolean(true);
        bso.writeDouble(0d);
        //对象实现serializable才能被实列化
        bso.writeObject(new People("小米", 12 , "好好敲代码"));
        ObjectInputStream dis = new ObjectInputStream(new FileInputStream("objIO.txt"));
        System.err.println(dis.readBoolean());
        System.err.println(dis.readDouble());

        //对象反序列化
        System.err.println(dis.readObject());

        bso.close();
        dis.close();
    }
}
