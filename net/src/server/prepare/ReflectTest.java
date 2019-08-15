package server.prepare;


import java.lang.reflect.InvocationTargetException;

/**
 * 反射：把java类中的各种结构（方法、属性、构造器、类名）映射成一各个java对象。
 * 1、获取class对象
 * 三种方式：推荐Class.forName();
 * 2、创建对象
 */
public class ReflectTest
{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException
    {
        //三种方式
        //1.Object.getClass ();
        Object object = new Object();
        Class<?> aClass = object.getClass();

        //2.类.class
        Class<Object> aClass1 = Object.class;

        //3.Class.forName (类路径)
        Class<?> aClass2 = Class.forName("java.lang.Object");

        //创建对象
        Object o = aClass2.newInstance();//jdk9之前、不推荐
        aClass2.getConstructor().newInstance();//推荐

    }
}