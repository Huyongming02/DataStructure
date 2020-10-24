package com.hym.datastructure.algorithm.sort;

import org.junit.Test;

import java.util.Random;

public class BucketSortPersonTest {
    @Test
    public void test() {
        int size = 10;
        BucketSortPerson.Record[] array = new BucketSortPerson.Record[size];
        for (int i = 0; i < size; i++) {
            BucketSortPerson.Record person = new BucketSortPerson.Record();
            person.setMoney(10 + new Random().nextInt(size));
            person.setName("record_" + i);
            array[i] = person;
        }
        print(array, "   org:");
        BucketSortPerson.sort(array, 2);
        print(array, "sorted:");
    }

    private static void print(BucketSortPerson.Record[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i].toString() + ",");
        }
        System.out.println(s + builder.toString());
    }
}
