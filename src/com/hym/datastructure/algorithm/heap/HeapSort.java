package com.hym.datastructure.algorithm.heap;

public class HeapSort {
    /**
     * 构建堆
     */

    public static void createHeap(int[] a, int n) {
        /**
         * 构建过程：从最后一个非叶子节点开始，从后往前，对每个节点进行自上而下的堆化
         */
        for (int i = n / 2; i >= 1; i--) {
            heapify(a, n, i);
        }
    }

    /**
     * 堆化根节点：找出当前节点的左右孩子中较大的一个，和根节点比较，符合顺序则结束；不符合顺序，则交换并继续比较
     *
     * @param a
     * @param n
     * @param i
     */
    private static void heapify(int[] a, int n, int i) {
        int current = i;
        while (true) {
            int maxPos = -1;
            int left = current * 2;//左孩子的位置
            int right = left + 1;//右孩子的位置
            if (right <= n) {
                if (a[left] < a[right]) {
                    maxPos = right;
                } else {
                    maxPos = left;
                }
            } else if (left <= n) {
                maxPos = left;
            }
            if (maxPos == -1) {//没有子孩子
                break;
            }
            if (a[current] >= a[maxPos]) {//根节点比子孩子大
                break;
            } else {//和子孩子交换位置，继续比较
                int temp = a[maxPos];
                a[maxPos] = a[current];
                a[current] = temp;
                current = maxPos;
            }
        }
    }

    /**
     * 堆排序
     */

    public static void sort(int[] a, int n) {
        //将堆顶元素和最后一个元素交互位置，然后自上而下堆化前面n-1个元素；重复这个过程直到堆中只有一个元素
        if (n == 1) {
            return;
        }
        createHeap(a, n);
        for (int i = n; i >= 2; i--) {
            int temp = a[i];
            a[i] = a[1];
            a[1] = temp;
            heapify(a, i - 1, 1);
        }
    }
}
