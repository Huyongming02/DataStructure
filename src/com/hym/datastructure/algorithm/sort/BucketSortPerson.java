package com.hym.datastructure.algorithm.sort;

/**
 * 桶排序
 */
public class BucketSortPerson {

    public static void sort(Record[] array, int bucketSize) {
        if (array == null || array.length < 2) {
            return;
        }
        //计算用多少个桶来装数据
        int min = array[0].money;
        int max = array[0].money;
        for (int i = 1; i < array.length; i++) {
            if (array[i].money < min) {
                min = array[i].money;
            } else if (array[i].money > max) {
                max = array[i].money;
            }
        }
        System.out.println("min:" + min);
        System.out.println("max:" + max);
        int bucketCount = (max - min) / bucketSize + 1;
        System.out.println("bucketCount:" + bucketCount);
        //申请桶空间
        Record[][] buckets = new Record[bucketCount][bucketSize];
        int[] indexArray = new int[bucketCount];
        //将数据装入桶里面
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = (array[i].money - min) / bucketSize;
            if (indexArray[bucketIndex] == buckets[bucketIndex].length) {// buckets[bucketIndex]满了，需要扩容
                ensureCapacity(buckets, bucketIndex);
            }
            buckets[bucketIndex][indexArray[bucketIndex]] = array[i];
            indexArray[bucketIndex]++;
        }
        //对每个桶进行排序
        int k = 0;
        for (int i = 0; i < bucketCount; i++) {
//            sort(buckets[i], 0, indexArray[i] - 1);//快排，不稳定
            sort2(buckets[i], indexArray[i]);//冒泡，稳定排序
            //合并桶中的数据
            for (int j = 0; j < indexArray[i]; j++) {
                array[k++] = buckets[i][j];
            }
        }
    }

    /**
     * 冒泡
     *
     * @param array
     */
    private static void sort2(Record[] array, int size) {
        if (array == null || array.length == 1) {
            return;
        }
        for (int i = 0; i < size; i++) {
            boolean isExchanged = false;
            for (int j = 0; j < size - i - 1; j++) {//这里的i表示经过了几次冒泡排序了，经过一次有在最后面多了一位已经排好序的元素，所以下一次要比较的范围也较少1
                if (array[j].money > array[j + 1].money) {//只有在后面的元素大于前面的元素的时候才交互，可以保证排序的稳定性
                    Record temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                    isExchanged = true;
                }
            }
            if (!isExchanged) {//当某一趟冒泡排序中没有交换发送的时候，说明序列已经有序了
                break;
            }
        }
    }

    /**
     * 快排
     *
     * @param a
     * @param left
     * @param right
     */
    private static void sort(Record[] a, int left, int right) {
        if (left < right) {
            int low = left;
            int hight = right;
            Record pivot = a[low];
            //找到分区点的位置
            while (low < hight) {//有元素之间的位置交换，所以不是稳定排序
                while (low < hight && a[hight].money >= pivot.money) {
                    hight--;
                }
                a[low] = a[hight];
                while (low < hight && a[low].money <= pivot.money) {
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

    private static void ensureCapacity(Record[][] buckets, int bucketIndex) {
        Record[] tempArr = buckets[bucketIndex];
        Record[] newArr = new Record[tempArr.length * 2];
        for (int j = 0; j < tempArr.length; j++) {
            newArr[j] = tempArr[j];
        }
        buckets[bucketIndex] = newArr;
    }

    public static class Record {
        private int money;
        private String name;

        public int getMoney() {
            return money;
        }

        public void setMoney(int money) {
            this.money = money;
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
                    "money=" + money +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
