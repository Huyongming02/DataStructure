package com.hym.datastructure.algorithm.sort;

import org.junit.Test;

import java.util.Random;

public class CountingSortPersonTest {
    @Test
    public void test() {
        int size = 5;
        CountingSortPerson.Person[] array = new CountingSortPerson.Person[size];
        for (int i = 0; i < size; i++) {
            CountingSortPerson.Person person = new CountingSortPerson.Person();
            person.setAge(10 + new Random().nextInt(5));
            person.setName("name_" + i);
            array[i] = person;
        }
        print(array, "   org:");
        CountingSortPerson.sort(array);
        print(array, "sorted:");
    }

    private static void print(CountingSortPerson.Person[] array, String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            builder.append(array[i].toString() + ",");
        }
        System.out.println(s + builder.toString());
    }
}
