package com.hym.datastructure.algorithm.dynamicplan;

/**
 * 类似杨辉三角的图形，求从顶点到最底边的最短路径
 *                  1
 *                 / \
 *               6      2
 *              / \    / \
 *           4      1      2
 *          / \    / \    / \
 *        5      5      2      1
 *       / \    / \    / \    / \
 *    6      3      4      3      7
 */
public class YangHuiTriangular {
    /**
     * 状态转移公式：values[i][k]=Math.min(valuse[i-1][k-1],valuse[i-1][k])+weights[i][k]
     */
    public static int count(int[][] weights) {
        if (weights == null || weights.length == 0 || weights[0].length == 0) {
            return Integer.MIN_VALUE;
        }
        int size = weights.length;
        int values[][] = new int[size][];
        values[0] = new int[1];
        values[0][0] = weights[0][0];

        for (int i = 1; i < size; i++) {
            values[i] = new int[i + 1];
            for (int k = 0; k <= i; k++) {
                int tempValue;
                if (k == 0) {
                    tempValue = values[i - 1][k];
                } else if (k == i) {
                    tempValue = values[i - 1][k - 1];
                } else {
                    tempValue = Math.min(values[i - 1][k - 1], values[i - 1][k]);
                }
                values[i][k] = tempValue + weights[i][k];
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (values[size - 1][i] < min) {
                min = values[size - 1][i];
            }
        }
        return min;
    }
}
