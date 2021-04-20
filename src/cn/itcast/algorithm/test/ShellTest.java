package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Shell;

import java.util.Arrays;

public class ShellTest {

    public static void main(String[] args) {
        Integer[] a = {13,688,214,9,3,980,241,2};

        Shell.sort(a);

        System.out.println(Arrays.toString(a));
    }
}
