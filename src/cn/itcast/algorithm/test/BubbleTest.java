package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Bubble;

import java.util.Arrays;
import java.util.List;

public class BubbleTest {

    public static void main(String[] args) {
        Integer[] arr = {4,5,6,1,2,3};

        Bubble.sort(arr);

        System.out.println(Arrays.toString(arr));
    }

}
