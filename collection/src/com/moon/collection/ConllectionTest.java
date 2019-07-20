package com.moon.collection;

import java.util.*;

public class ConllectionTest {

    public static void main(String[] arg) {
        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        Collections.shuffle(list);
        Collections.reverse(list);
        System.err.println(list);
    }
}
