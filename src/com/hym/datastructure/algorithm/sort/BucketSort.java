package com.hym.datastructure.algorithm.sort;

/**
 * 桶排序
 */
public class BucketSort {
    /**
     * 桶排序的思想：
     * 将待排序的数据拆分到多个有序的桶中（桶与桶之间的数据是有大小关系的），
     * 然后单独对每个桶进行排序，所有的桶都排完序之后，
     * 按照桶之间的顺序依次将数据合并到一起就得到了有序的序列
     *
     * 桶排序对数据的要求：
     * 1. 数据必须能够容易的拆分到n个桶中，且桶与桶之间必须天然有序
     * 2. 数据在各个桶之间的分布要比较均匀，避免某个桶的数据特别多，使得算法的时间复杂度退化到比较排序
     *
     * 桶排序的时间复杂度和空间复杂度
     * 1. 时间复杂度：O(n)
     * 2. 空间复杂度：O(n)
     *
     * 桶排序是否是稳定排序：取决于选用的桶内排序算法
     *
     * @param array
     * @param bucketSize
     */
    public static void sort(int[] array, int bucketSize) {
        if (array == null || array.length < 2) {
            return;
        }
        //计算用多少个桶来装数据
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
        int bucketCount = (max - min) / bucketSize + 1;
        System.out.println("bucketCount:" + bucketCount);
        //申请桶空间
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArray = new int[bucketCount];
        //将数据装入桶里面
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = (array[i] - min) / bucketSize;
            if (indexArray[bucketIndex] == buckets[bucketIndex].length) {// buckets[bucketIndex]满了，需要扩容
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArray[bucketIndex]] = array[i];
            indexArray[bucketIndex]++;
        }
        //对每个桶进行排序
        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
            sort(buckets[i], 0, indexArray[i] - 1);
            //合并桶中的数据
            for (int j = 0; j < indexArray[i]; j++) {
                array[k++] = buckets[i][j];
            }
        }
    }

    private static void sort(int[] a, int left, int right) {
        if (left < right) {
            int low = left;
            int hight = right;
            int pivot = a[low];
            //找到分区点的位置
            while (low < hight) {//有元素之间的位置交换，所以不是稳定排序
                while (low < hight && a[hight] >= pivot) {
                    hight--;
                }
                a[low] = a[hight];
                while (low < hight && a[low] <= pivot) {
                    low++;
                }
                a[hight] = a[low];
            }
            a[low] = pivot;
            //对左右两个分区进行排序
            if (left + 1 < low) {
                sort(a, left, low - 1);
            }
            if (right - 1 > low) {
                sort(a, low + 1, right);
            }
        }
    }

    private static void ensureCapacity(int[][] buckets, int bucketIndex) {
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }
}
