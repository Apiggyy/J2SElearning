package com.self.learning.collection;

public class MyArrayList<E> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] elementData ;

    private int size;

    public MyArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[initialCapacity];
    }

    public void add(E e) {
        if (size == elementData.length) {
            Object[] newElementData = new Object[size * 2 + 1];
            System.arraycopy(elementData, 0, newElementData, 0, elementData.length);
            elementData = newElementData;
        }
        elementData[size++] = e;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index:" + index + ",size:" + size);
        }
    }

    @SuppressWarnings("unchecked")
    public E get(int index) {
        rangeCheck(index);
        return elementData(index);
    }

    public E remove(int index) {
        rangeCheck(index);
        E oldValue = elementData(index);
        //1 2 3 4 5
        int numMoved = size - index - 1;
        System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        elementData[--size] = null;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public E elementData(int index) {
        return (E) elementData[index];
    }

    public static void main(String[] args) {
        MyArrayList<String> list = new MyArrayList<>();
        list.add("abc");
        list.add("123");
        list.add("456");
        list.add("sss");
        list.add("sdfsfd");
        list.add("sssdf");
        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(5));
        System.out.println(list.remove(5));
        System.out.println("-----------------");
        for (int i = 0; i < list.size; i++) {
            System.out.println(list.get(i));
        }
    }
}
