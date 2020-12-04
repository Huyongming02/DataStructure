package com.hym.datastructure.algorithm.dynamicplan;

/**
 * leetcode:300. 最长上升子序列
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 */
public class LISDynamic {
    /**
     * 动态规划解法
     * 1. 阶段划分：每个数字的选择
     * 2. 状态定义：包含当前数字的最长上升子序列长度
     * 3. 状态转移公式：dp[i]=max(dp[j])+1,其中0≤j<i且nums[j]<nums[i]
     * 4. 最长上升子序列长度：LISlength=max(dp[i]),其中0≤i<n
     */
    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        int max = 1;
        dp[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            int temp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]) {
                    if (dp[j] > temp) {
                        temp = dp[j];
                    }
                }
            }
            dp[i] = temp + 1;
            if (dp[i] > max) {
                max = dp[i];
            }
        }
        return max;
    }


}
