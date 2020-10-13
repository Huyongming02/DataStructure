package com.hym.datastructure.datastructure.link;


import org.junit.Test;

public class MyLinkedListTest {

    @Test
    public void testAdd() {
        MyLinkedList<String> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add("str" + i);
        }
        print(list, "add:");
    }

    @Test
    public void testInsert() {
        MyLinkedList<String> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add("str" + i);
        }
        print(list, "org:");
        //未越界
        list.add(list.size() - 1, "1000");
        list.add(list.size() - 1, "1001");
        list.add(list.size() - 1, "1002");
        list.add(list.size(), "end");
        list.add(3, "3000");
        list.add(0, "0000");
        list.add(0, "0001");
        list.add(0, "0002");
        print(list, "insert:");
        //越界
//        list.add(-1,"-1");
//        list.add(list.size() + 1, "end");
    }

    @Test
    public void testSet() {
        MyLinkedList<String> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add("str" + i);
        }
        print(list, "org:");
        //未越界
        System.out.println("set 3:" + list.set(3, "3000"));
        print(list, "set:");
        //越界
//        list.set(-1,"-1");
//        list.set(list.size(),"end");
    }

    @Test
    public void testRemoveIndex() {
        MyLinkedList<String> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            list.add("str" + i);
        }
        print(list, "org:");
        //从开头开始完全删除
        while (list.size() > 0) {
            System.out.println("remove index=:" + (list.size() - 1) + ";item:" + list.remove(list.size() - 1));
        }
        list.add(list.size(), "new1");
        list.add(list.size(), "new2");
        list.add(list.size(), "new3");
        list.add(list.size(), "new4");
        print(list, "remove from end:");

        //从结束开始完全删除
        while (list.size() > 0) {
            System.out.println("remove index=:" + 0 + ";item:" + list.remove(0));
        }
        list.add(list.size(), "new11");
        list.add(list.size(), "new22");
        list.add(list.size(), "new33");
        list.add(list.size(), "new44");
        print(list, "remove from start:");
        //删除中间节点
        while (list.size() > 2) {
            System.out.println("remove index=:" + 2 + ";item:" + list.remove(2));
        }
        list.add(list.size(), "end");
        print(list, "remove mid:");
        //越界
//        list.remove(-1);
//        list.remove(list.size());
    }

    @Test
    public void testRemoveObject() {
        MyLinkedList<String> list = new MyLinkedList<>();
        for (int i = 0; i < 10; i++) {
            if (i % 3 == 0) {
                list.add(null);
            } else {
                list.add("str" + i);
            }
        }
        print(list, "org:");
        //删除非空元素
        System.out.println("remove str0:" + list.remove("str0"));//没有这个元素，返回false
        System.out.println("remove str1:" + list.remove("str1"));
        System.out.println("remove str2:" + list.remove("str2"));
        print(list, "remove:");
        //删除空元素
        System.out.println("remove null:" + list.remove(null));
        System.out.println("remove null:" + list.remove(null));
        System.out.println("remove null:" + list.remove(null));
        System.out.println("remove null:" + list.remove(null));
        System.out.println("remove null:" + list.remove(null));//所有的null都删除了，返回false
        print(list, "remove:");
    }

    private void print(MyLinkedList<String> list, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            builder.append(list.get(i) + ",");
        }
        System.out.println(s + builder.toString() + ";size=" + list.size());
    }
}
