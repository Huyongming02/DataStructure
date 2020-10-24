package com.hym.datastructure.algorithm.sort;

public class RadixSort {
    /**
     * 什么是基数排序：
     * 基数排序是一种多关键字排序算法，通过对每个关键字使用其他线性排序算法依次进行排序，
     * 每个关键字都排完之后，整个序列就有序了。要求选用的线性排序算法能够保证稳定性
     * <p>
     * 基数排序的时间复杂度和空间复杂度
     * 1. 时间复杂度：O(n)
     * 2. 空间复杂度：O(n)
     * <p>
     * 基数排序是稳定排序
     *
     * @param array
     */
    public static void sort(int[] array) {
        // 从个位开始，对数组arr按"指数"进行排序
        for (int exp = 1; array[0] / exp > 0; exp *= 10) {
            countingSort(array, exp);
        }
    }

    private static void countingSort(int[] array, int exp) {
        if (array == null || array.length < 2) {
            return;
        }
        //1. 计算数据分别的区间，申请计数数组
        int[] c = new int[10];
        //2. 遍历待排序数组，计算每个元素的个数，存入计数数组的对应位置
        for (int i = 0; i < array.length; i++) {
            c[(array[i] / exp) % 10]++;
        }
        //3. 计算计算数组中元素在将来排好序的序列中的位置
        for (int i = 1; i < c.length; i++) {
            c[i] = c[i - 1] + c[i];
        }
        //4. 遍历待排序数组，结合计数数组，将待排序数据存入到存放有序序列的数组的对应位置
        int[] temp = new int[array.length];
        for (int i = array.length - 1; i >= 0; i--) {//倒序保证稳定性
            int cindex = (array[i] / exp) % 10;
            temp[c[cindex] - 1] = array[i];
            c[cindex]--;
        }
        for (int i = array.length - 1; i >= 0; i--) {
            array[i] = temp[i];
        }
    }
}
