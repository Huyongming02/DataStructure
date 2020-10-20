package com.hym.datastructure.algorithm.sort;

public class MergeSort {
    /**
     * 归并排序原理：将要排序的区间平分成两个子区间，选对两个子区间进行排序，然后再将排好序的两个子区间合并成一个有序序列。
     * <p>
     * 归并排序的时间复杂度
     * 1. 最好：O(n*logn)
     * 2. 最坏：O(n*logn)
     * 3. 平均：O(n*logn)
     * <p>
     * 归并排序的空间复杂度
     * 1. O(n)，需要一个额外的空间来合并区间
     * <p>
     * 是否稳定排序
     * 1. 是
     */

    public static void sort(int[] a) {
        if (a == null || a.length == 0) {
            return;
        }
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int head, int tail) {
        /**
         * 递推公式：sort(a,head,tail)=merge(sort(a,head,m),sort(a,m+1,tail))
         * 退出条件：head=tail
         */
        if (head == tail) {
            return;
        }
        int mid = (head + tail) / 2;
        //对左右两个区间排序
        sort(a, head, mid);
        sort(a, mid + 1, tail);
        //将排序好的左右两个区间合并起来
        merge(a, head, tail, mid);
    }

    private static void merge(int[] a, int head, int tail, int mid) {
        //左边：head -- mid
        //右边：mid+1-- tail
        int temp[] = new int[tail - head + 1];
        int lstart = head;
        int rstart = mid + 1;
        int index = 0;
        while (lstart <= mid && rstart <= tail) {
            if (a[rstart] < a[lstart]) {//后面的小于前面的才先插入后面的，保证排序结果的稳定性
                temp[index] = a[rstart];
                rstart++;
            } else {
                temp[index] = a[lstart];
                lstart++;
            }
            index++;
        }
        while (lstart <= mid) {
            temp[index] = a[lstart];
            lstart++;
            index++;
        }
        while (rstart <= tail) {
            temp[index] = a[rstart];
            rstart++;
            index++;
        }
        for (int i = 0; i < temp.length; i++) {
            a[head + i] = temp[i];
        }
    }
}
