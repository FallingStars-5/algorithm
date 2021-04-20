package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Student;

/**
 * @author 落星
 */

public class TestComparable {

    public static void main(String[]args){
        //创建两个Student对象，并调用getMax方法完成测试
        Student s1 = new Student();
        s1.setUsername("张三");
        s1.setAge(18);

        Student s2 = new Student();
        s2.setUsername("李四");
        s2.setAge(20);

        Comparable max = getMax(s1,s2);

        System.out.println(max);
    }

    public static Comparable getMax(Comparable c1,Comparable c2){
        int result = c1.compareTo(c2);
        //如果result<0,则c1小于c2
        //如果result>0,则c1大于c2
        //如果result==0,则c1等于c2
        if (result>=0){
            return c1;
        }
        return c2;
    }
}
