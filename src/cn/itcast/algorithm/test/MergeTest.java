package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Merge;

import java.util.Arrays;

public class MergeTest {

    public static void main(String[] args) {
        Integer[] a = {56,27,22,1,8,67,9};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }

}
