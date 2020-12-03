package com.hym.datastructure.algorithm.dynamicplan;

import org.junit.Test;

public class MaxFormDynamic2Test {

    @Test
    public void test() {
//        strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
        String[] strings = {"10", "0001", "111001", "1", "0"};
        int m = 5;
        int n = 3;
        int max = MaxFormDynamic2.findMaxForm(strings, m, n);
        System.out.println("max:" + max);
    }

    @Test
    public void test2() {
        //strs = ["10", "0", "1"], m = 1, n = 1
        String[] strings = {"10", "0", "1"};
        int m = 1;
        int n = 1;
        int max = MaxFormDynamic2.findMaxForm(strings, m, n);
        System.out.println("max:" + max);
    }

    @Test
    public void test3() {
        //strs = ["10", "0", "1"], m = 1, n = 1
//        ["011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"]
//        44
//        39
        String[] strings = {"011", "1", "11", "0", "010", "1", "10", "1", "1", "0", "0", "0", "01111", "011", "11", "00", "11", "10", "1", "0", "0", "0", "0", "101", "001110", "1", "0", "1", "0", "0", "10", "00100", "0", "10", "1", "1", "1", "011", "11", "11", "10", "10", "0000", "01", "1", "10", "0"};
        int m = 44;
        int n = 39;
        int max = MaxFormDynamic2.findMaxForm(strings, m, n);
        System.out.println("max:" + max);
    }


}
