package com.hym.datastructure.algorithm.backtrack;

public class MaxWeight {
    private static int mMaxWeight = 0;

    public static int countMax(int[] goods, int max) {
        mMaxWeight = 0;
        countMax(goods, max, 0, 0);
        return mMaxWeight;
    }

    private static void countMax(int[] goods, int max, int current, int currentWeight) {
        if (current == goods.length) {//所有商品的选择都做完了
            if (currentWeight > mMaxWeight) {
                mMaxWeight = currentWeight;
            }
            return;
        }
        //不选当前商品
        countMax(goods, max, current + 1, currentWeight);
        //选择当前商品
        if (currentWeight + goods[current] <= max) {//选择当前商品之后，没有超过最大重量
            countMax(goods, max, current + 1, currentWeight + goods[current]);
        } else {//选择当前商品之后，超过了最大重量
            if (currentWeight > mMaxWeight) {
                mMaxWeight = currentWeight;
            }
        }
    }

}
