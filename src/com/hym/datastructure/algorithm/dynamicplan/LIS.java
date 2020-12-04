package com.hym.datastructure.algorithm.dynamicplan;

/**
 * 最长上升子序列
 */
public class LIS {
    private static int mMaxLength;

    public static int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        mMaxLength = 0;
        int[][] flags = new int[nums.length + 1][nums.length + 1];
        for (int i = 0; i <= nums.length; i++) {
            for (int j = 0; j <= nums.length; j++) {
                flags[i][j] = -1;
            }
        }
        search(nums, flags, 0, -1, 0);
        return mMaxLength;
    }

    private static void search(int[] nums, int[][] flags, int index, int lastIndex, int length) {
        if (index == nums.length) {
            if (length > mMaxLength) {
                mMaxLength = length;
            }
            return;
        }
        if (lastIndex >= 0) {
            if (nums[index] > nums[lastIndex]) {
                //选
                if (length + 1 > flags[index + 1][index + 1]) {
                    flags[index + 1][index + 1] = length + 1;
                    search(nums, flags, index + 1, index, length + 1);
                }
            }
            //不选
            if (length > flags[index + 1][lastIndex + 1]) {
                flags[index + 1][lastIndex + 1] = length;
                search(nums, flags, index + 1, lastIndex, length);
            }
        } else {
            //选
            if (length + 1 > flags[index + 1][index + 1]) {
                flags[index + 1][index + 1] = length + 1;
                search(nums, flags, index + 1, index, length + 1);
            }
            //不选
            if (length > flags[index + 1][lastIndex + 1]) {
                flags[index + 1][lastIndex + 1] = length;
                search(nums, flags, index + 1, lastIndex, length);
            }
        }
    }
}
