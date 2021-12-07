package com.chuansen.system.base.util.concurrent;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyOnWriteArrayListDemo {

    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<String>();
        list.add("one");
        list.add("two");
        list.add(1, "three");
        System.out.println(list.get(1));
        if (list.contains("three")) {
            Iterator<String> value = list.iterator();
            while (value.hasNext()) {
                System.out.println(value.next());
            }

        }
    }
}
