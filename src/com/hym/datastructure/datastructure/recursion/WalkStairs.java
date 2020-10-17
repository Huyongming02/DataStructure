package com.hym.datastructure.datastructure.recursion;

import org.junit.Test;

/**
 * 上楼梯的走法问题：假如有n个台阶，每次你可以跨1个台阶或者2个台阶。请问走这n个台阶总共有多少中走法
 */
public class WalkStairs {

    @Test
    public void test1() {
        System.out.println("walk sum 1:" + fun(1));
        System.out.println("walk sum 2:" + fun(2));
        System.out.println("walk sum 3:" + fun(3));
        System.out.println("walk sum 10:" + fun(10));
    }

    @Test
    public void test2() {
        int n = 10;//测试fun2的正确性，n依次取值：1,2，3,10,15
        System.out.println("fun:" + fun(n));
        System.out.println("fun2:" + fun2(n));
    }

    @Test
    public void compare() {
        int n = 40;//对比分析两种计算方式消耗的时间
        long start1 = System.currentTimeMillis();
        System.out.println("fun:" + fun(n));
        System.out.println("fun time:" + (System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        System.out.println("fun2:" + fun2(n));
        System.out.println("fun2 time:" + (System.currentTimeMillis() - start2));
    }


    /**
     * 未过滤重复计算的方式
     *
     * @param n
     * @return
     */
    public int fun(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return fun(n - 1) + fun(n - 2);
    }

    /**
     * 过滤重复计算的方式
     *
     * @param n
     * @return
     */
    public int fun2(int n) {
        int[] arrays = new int[n + 1];
        return fun(arrays, n);
    }

    private int fun(int[] arrays, int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        int count1 = arrays[n - 1] > 0 ? arrays[n - 1] : fun(arrays, n - 1);
        int count2 = arrays[n - 2] > 0 ? arrays[n - 2] : fun(arrays, n - 2);
        int count = count1 + count2;
        arrays[n] = count;
        return count;
    }


}
