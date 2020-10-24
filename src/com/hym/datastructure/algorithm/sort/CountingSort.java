package com.hym.datastructure.algorithm.sort;

public class CountingSort {
    /**
     * 计数排序的思想
     * 先计算待排序的数据的范围，假设为k，然后就申请k个桶，将数据映射到这k个桶中，每个桶中的数据都是一样的。然后再将这k个桶中的数据合并起来就排好序了
     * <p>
     * 计数排序的时间和空间复杂度
     * 1. 时间复杂度：O(n)
     * 2. 空间复杂度：O(n)
     * <p>
     * 计数排序是否是稳定排序：计数排序是稳定排序
     *
     * @param array
     */
    public static void sort(int[] array) {
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
        int min = array[0];
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            } else if (array[i] > max) {
                max = array[i];
            }
        }
        System.out.println("min:" + min);
        System.out.println("max:" + max);
        int interval = max - min;
        System.out.println("interval:" + interval);
        int[] c = new int[interval + 1];
        //2. 遍历待排序数组，计算每个元素的个数，存入计数数组的对应位置
        for (int i = 0; i < array.length; i++) {
            c[array[i] - min]++;
        }
        //3. 计算计算数组中元素在将来排好序的序列中的位置
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }
        //4. 遍历待排序数组，结合计数数组，将待排序数据存入到存放有序序列的数组的对应位置
        int[] temp = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int index = c[array[i] - min] - 1;
            temp[index] = array[i];
            c[array[i] - min]--;
        }
        for (int i = 0; i < array.length; i++) {
            array[i] = temp[i];
        }
    }
}
