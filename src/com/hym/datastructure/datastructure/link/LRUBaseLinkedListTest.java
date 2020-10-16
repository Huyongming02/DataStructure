package com.hym.datastructure.datastructure.link;

import java.util.Scanner;

public class LRUBaseLinkedListTest {
    public static void main(String[] args) {
        LRUBaseLinkedList<Integer> list = new LRUBaseLinkedList<>();
        Scanner sc = new Scanner(System.in);
        while (true) {
            list.add(sc.nextInt());
            list.printAll();
        }
    }
}
