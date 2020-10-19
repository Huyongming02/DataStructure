package com.hym.datastructure.algorithm.sort;

/**
 * 选择排序
 */
public class SelectSort {
    /**
     * 选择排序的思想：
     * 选择排序也是将序列分为两个序列：一个有序，一个无序。然后从无序序列中选择最小的元素放到有序序列的最后（和无序序列中的第一个元素交换位置），直到无序序列中没有元素
     * <p>
     * 选择排序的时间复杂度：
     * 1. 最好：O(n^2)
     * 2. 最差：O(n^2)
     * 3. 平均：O(n^2)
     * 为啥都是一样能？因为每次选择最小的元素都要经过n次比较，最后时间复杂度就是：n*（n-1）/2，所以就是O(n^2)
     * <p>
     * 选择排序的空间复杂度
     * 1. O(1)，原地排序
     * <p>
     * 选择排序的稳定性
     * 1. 不是稳定的：因为选择排序每次都要找到无序队列中的最小元素，然后和无序序列的第一个元素交换位置
     */

    public static void sort(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int size = array.length;
        for (int i = 0; i < size - 1; i++) {
            //从无序序列中找到最小的元素
            int index = i;
            for (int j = i + 1; j < size; j++) {
                if (array[index] > array[j]) {
                    index = j;
                }
            }
            //无序序列中的最小值和无序序列中的第一个元素交换位置（因为这里的交互元素的位置，所以选择排序不是稳定排序）
            int temp = array[i];
            array[i] = array[index];
            array[index] = temp;
        }
    }

}
