package com.hym.datastructure.algorithm.sort;

/**
 * 冒泡排序
 */
public class MaoPaoSort {
    /**
     * 冒泡排序的原理：
     * 比较相邻两个元素的大小，如果满足大小关系，则用第二个元素和下一个元素继续比较；
     * 如果不满足大小关系，则交换两个元素的位置，然后用交换后的第二个元素和下一个元素继续比较，依次比较到最后一个元素。
     * 通过这样一轮冒泡排序之后，最大的元素就到了最后的那个位置上。再次重复这个过程将次大的元素排好，重复n次则所有的元素都排好了
     * <p>
     * 优化：如果某一轮冒泡排序中，没有元素需要交换，则整个带排序的数据已经有序了
     * <p>
     * 冒泡排序的时间复杂度
     * 1. 最好：O(n)，原来的序列已经有序
     * 2. 最坏：O(n^2),原来的序列逆序
     * 3. 平均：O(n^2),
     * <p>
     * 冒泡排序的空间复杂度
     * 1. O(1),原地排序
     * <p>
     * 冒泡排序的稳定性：
     * 1. 稳定排序
     * <p>
     * 其他概念：
     * 1. 有序度：（5,6,7,8），（5,6），（5,7）（5,8），（6,7），（6,8），（7,8）共6个，所以有序度为6
     * 2. 满序度：n(n-1)/2,四个元素的满序读4*(4-1)/2=6
     * 3. 逆序度：满序度-有序度
     */

    public static void sort(int[] array) {
        num = 0;
        if (array == null || array.length == 1) {
            return;
        }
        int size = array.length;
        for (int i = 0; i < size; i++) {
            boolean isExchanged = false;
            for (int j = 0; j < size - i - 1; j++) {//这里的i表示经过了几次冒泡排序了，经过一次有在最后面多了一位已经排好序的元素，所以下一次要比较的范围也较少1
                if (array[j] > array[j + 1]) {//只有在后面的元素大于前面的元素的时候才交互，可以保证排序的稳定性
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isExchanged = true;
                    num++;
                }
            }
            if (!isExchanged) {//当某一趟冒泡排序中没有交换发送的时候，说明序列已经有序了
                break;
            }
        }
        System.out.println("MaoPaoSort num:" + num);
    }

    public static int num;//交换元素的次数等=逆序度
}
