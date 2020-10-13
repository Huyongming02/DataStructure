package com.hym.datastructure.datastructure.array;

import com.hym.datastructure.datastructure.array.MyArrayList;
import org.junit.Test;

public class MyArrayListTest {
    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        print(list, "testAdd:");
    }

    @Test
    public void testInsert() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        print(list, "org:");
        //未越界
        list.add(3, 33);
        list.add(list.size(), 1000);
        print(list, "insert:");
        //越界
//        list.add(-1,1000);
//        list.add(list.size()+1,2000);
    }

    @Test
    public void testSet() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        print(list, "org:");
        //未越界
        System.out.println("set 1:" + list.set(1, 1000));
        print(list, "set:");
        //越界
//        list.set(-1, 1000);
//        list.set(list.size(), 2000);
    }

    @Test
    public void testRemoveIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        print(list, "org:");
        //未越界
        list.remove(1);
        print(list, "remove:");
        //越界
//        list.remove(-1);
//        list.remove(list.size());
    }

    @Test
    public void testRemoveObject() {
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("str" + i);
        }
        print2(list, "org:");
        //在数组内
        System.out.println("remove str5:" + list.remove("str5"));
        //不在数组内
        System.out.println("remove str25:" + list.remove("str25"));
        print2(list, "remove:");
    }

    @Test
    public void testContains() {
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("str" + i);
        }
        print2(list, "org:");

        System.out.println("contains str5:" + list.contains("str5"));
        System.out.println("contains str25:" + list.contains("str25"));
    }

    private void print2(MyArrayList<String> list, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println(s + builder.toString() + ";size=" + list.size());
    }

    private void print(MyArrayList<Integer> list, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println(s + builder.toString() + ";size=" + list.size());
    }
}
