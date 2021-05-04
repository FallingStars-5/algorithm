package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.LinkList;

/**
 * @author 落星
 */
public class LinkListTest2 {

    public static void main(String[] args) {
        //创建单向列表对象

        LinkList<String> sl = new LinkList<>();

        //测试插入
        sl.insert("姚明");
        sl.insert("科比");
        sl.insert("麦迪");
        sl.insert(1,"詹姆斯");

        for (Object s : sl){
            System.out.println(s);
        }

        sl.reverse();

        for (Object s : sl){
            System.out.println(s);
        }

    }
}
