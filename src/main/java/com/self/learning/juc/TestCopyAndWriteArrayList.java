package com.self.learning.juc;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 注意：添加操作多时，效率低，因为每次添加时都会进行复制操作，开销非常大。并发迭代操作多时可以选择
 */
public class TestCopyAndWriteArrayList {

    public static void main(String[] args) {
        CopyAndWriteArrayListDemo caw = new CopyAndWriteArrayListDemo();
        for (int i = 0; i < 10; i++) {
            new Thread(caw).start();
        }
    }
}

class CopyAndWriteArrayListDemo implements Runnable{
    //private static List<String> list = Collections.synchronizedList(new ArrayList<>());
    private static CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
    static {
        list.add("AA");
        list.add("BB");
        list.add("CC");
    }

    @Override
    public void run() {
        Iterator<String> iterator = list.iterator();
        for (Iterator<String> stringIterator = list.iterator(); stringIterator.hasNext(); ) {
            String element = stringIterator.next();
            System.out.println("element : " + element);
            list.add("AA");
        }
    }
}
