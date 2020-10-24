package com.hym.datastructure.algorithm.sort;

public class CountingSortPerson {
    public static void sort(Person[] array) {
        /**
         * 计数排序的的步骤
         * 1. 计算数据分别的区间，申请计数数组
         * 2. 遍历待排序数组，计算每个元素的个数，存入计数数组的对应位置
         * 3. 计算计算数组中元素在将来排好序的序列中的位置
         * 4. 遍历待排序数组，结合计数数组，将待排序数据存入到存放有序序列的数组的对应位置
         */
        if (array == null || array.length < 2) {
            return;
        }
        //1. 计算数据分别的区间，申请计数数组
        int min = array[0].age;
        int max = array[0].age;
        for (int i = 1; i < array.length; i++) {
            if (array[i].age < min) {
                min = array[i].age;
            } else if (array[i].age > max) {
                max = array[i].age;
            }
        }
        System.out.println("min:" + min);
        System.out.println("max:" + max);
        int interval = max - min;
        System.out.println("interval:" + interval);
        int[] c = new int[interval + 1];
        //2. 遍历待排序数组，计算每个元素的个数，存入计数数组的对应位置
        for (int i = 0; i < array.length; i++) {
            c[array[i].age - min]++;
        }
        //3. 计算计算数组中元素在将来排好序的序列中的位置
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }
        //4. 遍历待排序数组，结合计数数组，将待排序数据存入到存放有序序列的数组的对应位置
        Person[] temp = new Person[array.length];
        for (int i = array.length - 1; i >= 0; i--) {
            int index = c[array[i].age - min] - 1;
            temp[index] = array[i];
            c[array[i].age - min]--;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = temp[i];
        }
    }

    public static class Person {
        private int age;
        private String name;

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "{" +
                    "age=" + age +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
