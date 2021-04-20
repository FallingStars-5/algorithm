package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Section;

import java.util.Arrays;

public class SectionTest {
    public static void main(String[] args) {

        Integer[] a = {2,6,56,21,989,211,67};

        Section.sort(a);

        System.out.println(Arrays.toString(a));
    }
}
