package com.hym.datastructure.algorithm.sort;

import org.junit.Test;

import java.util.Random;

public class BucketSortRecordTest {
    @Test
    public void test() {
        int size = 5;
        BucketSortRecord.Record[] array = new BucketSortRecord.Record[size];
        for (int i = 0; i < size; i++) {
            BucketSortRecord.Record person = new BucketSortRecord.Record();
            person.setMoney(10 + new Random().nextInt(size));
            person.setId("record_" + i);
            array[i] = person;
        }
        print(array, "   org:");
        BucketSortRecord.sort(array, 2);
        print(array, "sorted:");
    }

    private static void print(BucketSortRecord.Record[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i].toString() + ",");
        }
        System.out.println(s + builder.toString());
    }
}
