package com.moon.collection;

import java.util.*;

public class IteratorTest {
    public static void main(String[] arg) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        ListIterator<String> listIterator = list.listIterator();
        for (Iterator<String> ite =list.iterator(); ite.hasNext();)
        {
            String temp = ite.next();
            System.out.println(temp);
        }


        HashMap<String, String> map = new HashMap<String, String>();
        Set<Map.Entry<String, String>> entrySet = map.entrySet();

    }
}
