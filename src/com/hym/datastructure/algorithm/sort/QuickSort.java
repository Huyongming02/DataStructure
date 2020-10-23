package com.hym.datastructure.algorithm.sort;

public class QuickSort {
    /**
     * 快速排序的原理：在要排序的区间选择任意一个值作为分区点，
     * 遍历区间，使分区点左边的数据都小于等于分区点，
     * 分区点右边的数据都大于等于分区点，这样分区点的位置就确定了。
     * 然后已相同的方式对左右两个区间进行排序
     * <p>
     * 快速排序的时间复杂度
     * 1. 最好：O(n*logn)
     * 2. 最坏：O(n^2)
     * 3. 平均：O(n*logn)
     * <p>
     * 空间复杂度：
     * 1. O(1)
     * <p>
     * 是否是稳定排序
     * 1. 不是：每轮排序中交换分区点两边的元素的时候，可能把值相等的前面一个交换到后面去了
     */
    public static void sort(int a[]) {
        if (a == null || a.length == 0) {
            return;
        }
        sort(a, 0, a.length - 1);
    }

    private static void sort(int[] a, int left, int right) {
        /**
         * 递推公式：sort(a,p,r)=sort(a,p,m-1)+sort(a,m+1,r)
         * 结束条件：head>=tail
         */
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

    /**
     * 在O(n)的时间复杂度内找出无序数组中的第K大数
     *
     * @param array
     * @param k
     */
    public static int getMaxK(int[] array, int k) {
        if (array == null || array.length < k) {
            return Integer.MIN_VALUE;
        }
        return sort(array, 0, array.length - 1, array.length - k);//计算第k大数在序列中的位置：array.length - k
    }

    private static int sort(int[] a, int left, int right, int index) {
        if (left < right) {
            int low = left;
            int hight = right;
            int pivot = a[low];
            //找到分区点的位置
            while (low < hight) {
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
            if (low == index) {//分区点的位置就是要查找的第K大数
                return pivot;
            } else if (low < index) {//分区点的位置在要查找的位置的左边
                return sort(a, low + 1, right, index);
            } else if (low > index) {//分区点的位置在要查找的位置的右边
                return sort(a, left, low - 1, index);
            }
        }
        return a[left];
    }
}
