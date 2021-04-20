package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Insertion;

import java.util.Arrays;

public class InsertionTest {

    public static void main(String[] args) {
        Integer[] arr = {12,457,112,8799,11,4,3};

        Insertion.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
