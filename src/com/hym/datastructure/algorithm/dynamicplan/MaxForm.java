package com.hym.datastructure.algorithm.dynamicplan;

/**
 * leetcode：474. 一和零
 * <p>
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 * <p>
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 * <p>
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 * <p>
 * <p>
 * 回溯+备忘录
 */
public class MaxForm {

    private static int mMax = 0;

    public static int findMaxForm(String[] strs, int m, int n) {
        mMax = 0;
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int size = strs.length;
        int[] oneSums = new int[size];
        int[] zeroSums = new int[size];
        for (int i = 0; i < size; i++) {
            String str = strs[i];
            if (str != null) {
                int oneSum = 0;
                int zeroSum = 0;
                for (int j = 0; j < str.length(); j++) {
                    if (str.charAt(j) == '1') {
                        oneSum++;
                    }
                    if (str.charAt(j) == '0') {
                        zeroSum++;
                    }
                }
                oneSums[i] = oneSum;
                zeroSums[i] = zeroSum;
            }
        }
        int[][][] flags = new int[size + 1][m + 1][n + 1];
        search(0, size, oneSums, zeroSums, 0, 0, m, n, 0, flags);
        return mMax;
    }

    private static void search(int index, int size, int[] oneSums, int[] zeroSums, int cm, int cn, int m, int n, int sum, int[][][] flags) {
        if (index == size || (cm == m && cn == n)) {
            if (sum > mMax) {
                mMax = sum;
            }
            return;
        }
        if (flags[index + 1][cm][cn] == 0 || flags[index + 1][cm][cn] < sum) {//flags[index + 1][cm][cn]==0表示这个节点之前没有计算过
            flags[index + 1][cm][cn] = sum;
            search(index + 1, size, oneSums, zeroSums, cm, cn, m, n, sum, flags);
        }
        if (cn + oneSums[index] <= n && cm + zeroSums[index] <= m) {
            if (flags[index + 1][cm + zeroSums[index]][cn + oneSums[index]] == 0 || flags[index + 1][cm + zeroSums[index]][cn + oneSums[index]] < sum + 1) {
                flags[index + 1][cm + zeroSums[index]][cn + oneSums[index]] = sum + 1;
                search(index + 1, size, oneSums, zeroSums, cm + zeroSums[index], cn + oneSums[index], m, n, sum + 1, flags);
            }
        }
    }
}
