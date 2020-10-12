package com.hym.datastructure.datastructure.array;

import org.junit.Test;

public class MyArrayListTest {
    @Test
    public void testAdd() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println("testAdd:" + builder.toString());
    }

    @Test
    public void testInsert() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println("org:" + builder.toString());
        //未越界
        list.add(3, 33);
        list.add(list.size(), 1000);
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder2.append(list.get(i) + ",");
        }
        System.out.println("insert:" + builder2.toString());
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
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println("org:" + builder.toString());
        //未越界
        list.set(1, 1000);
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder2.append(list.get(i) + ",");
        }
        System.out.println("set:" + builder2.toString());
        //越界
//        list.add(-1, 1000);
        list.add(list.size(), 2000);
    }

    @Test
    public void testRemoveIndex() {
        MyArrayList<Integer> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add(i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println("org:" + builder.toString() + ";size=" + list.size());
        //未越界
        list.remove(1);
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder2.append(list.get(i) + ",");
        }
        System.out.println("remove:" + builder2.toString() + ";size=" + list.size());
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
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println("org:" + builder.toString() + ";size=" + list.size());
        //在数组内
        System.out.println("remove str5:" + list.remove("str5"));
        //不在数组内
        System.out.println("remove str25:" + list.remove("str25"));
        StringBuilder builder2 = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder2.append(list.get(i) + ",");
        }
        System.out.println("remove:" + builder2.toString() + ";size=" + list.size());
    }

    @Test
    public void testContains() {
        MyArrayList<String> list = new MyArrayList<>();
        for (int i = 0; i < 20; i++) {
            list.add("str" + i);
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println("org:" + builder.toString() + ";size=" + list.size());

        System.out.println("contains str5:" + list.contains("str5"));
        System.out.println("contains str25:" + list.contains("str25"));
    }
}
