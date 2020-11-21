package com.hym.datastructure.algorithm.traceback;

/**
 * 计算n皇后问题
 */
public class CalQueen {
    /**
     * 寻找一种摆放方式
     *
     * @param size
     * @return
     */
    public static int[] calculate(int size) {
        int locations[] = new int[size];//记录每一列上皇后的位置
        for (int i = 0; i < size; i++) {
            locations[i] = -1;
        }
        queens(locations, 0, size);
        return locations;
    }

    /**
     * 我们按列来摆放皇后，queens()方法判断某一列上的皇后可以摆放在哪个行上
     *
     * @param locations
     * @param current
     * @param size
     */
    private static boolean queens(int[] locations, int current, int size) {
        if (current == size) {
            return true;
        }
        for (int i = 0; i < size; i++) {//i表示每一列上，皇后可选的位置
            if (isOk(locations, current, i)) {//判断当前这个皇后是否可以摆放在这个位置
                locations[current] = i;
                if (queens(locations, current + 1, size)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean isOk(int[] locations, int current, int location) {
        if (current == 0) {
            return true;
        }
        //不再同一列(按列遍历，自然不会在同一列上)
        //不在同一行(temp == locations[i] )
        //不在一条斜边上(current - i == Math.abs(temp - locations[i]))
        for (int i = 0; i < current; i++) {
            if (location == locations[i] || current - i == Math.abs(location - locations[i])) {
                return false;
            }
        }
        return true;
    }

    private static int mSum = 0;

    /**
     * 计算总共有多少种解
     * @param size
     * @return
     */
    public static int countSum(int size) {
        int locations[] = new int[size];//记录每一列上皇后的位置
        for (int i = 0; i < size; i++) {
            locations[i] = -1;
        }
        mSum = 0;
        queens2(locations, 0, size);
        return mSum;
    }

    private static void queens2(int[] locations, int current, int size) {
        if (current == size) {
            mSum++;
        }
        for (int i = 0; i < size; i++) {//i表示每一列上，皇后可选的位置
            if (isOk(locations, current, i)) {//判断当前这个皇后是否可以摆放在这个位置
                locations[current] = i;
                queens2(locations, current + 1, size);
            }
        }
    }

}
