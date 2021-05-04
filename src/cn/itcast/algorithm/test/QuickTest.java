package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Quick;

import java.util.Arrays;

/**
 * @author 落星
 */
public class QuickTest {
    public static void main(String[] args) {
        Integer[] a = {13,6,2,7,2,889,244};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
