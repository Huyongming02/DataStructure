package com.hym.datastructure.algorithm.sort;

/**
 * 插入排序
 */
public class InsertSort {
    /**
     * 插入排序的原理：
     * 插入排序的思想是将序列分为两个：一个有序序列，一个无需序列；
     * 然后从无序序列中取出元素插入到有序序列中的合适位置，是的有序序列依然有序，
     * 所有无序序列中的元素都插入了，则整个序列就有序了
     * <p>
     * 插入排序的时间复杂度
     * 1. 最好：O(n),序列原来有序，向有序序列插入元素时从后向前比较
     * 2. 最坏：O(n^2)，序列逆序，向有序序列插入元素时从后向前比较
     * 3. 平均：O(n^2)
     * <p>
     * 插入排序的空间复杂度
     * 1. O(1),原地排序
     * <p>
     * 插入排序是稳定排序吗
     * 1. 是
     */

    public static void sort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        int size = a.length;
        for (int i = 1; i < size; i++) {
            int temp = a[i];
            int index = i - 1;
            while (index >= 0 && temp < a[index]) {//从后向前比较，寻找插入元素的位置,只有小于的时候，才移动原来的序列，保证排序的稳定性
                a[index + 1] = a[index];
                index--;
            }
            a[index + 1] = temp;
        }
    }

    public static int num;//移动元素的次数=逆序度
}
