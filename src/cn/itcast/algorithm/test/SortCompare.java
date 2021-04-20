package cn.itcast.algorithm.test;

import cn.itcast.algorithm.sort.Insertion;
import cn.itcast.algorithm.sort.Shell;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

/**
 * @author 落星
 */

public class SortCompare {

    /**
     * 调用不同的排序方法，完成测试
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //向文本文件中写入数据
        File file = null;
        FileWriter fw = null;
        file = new File("\\test_date.txt");
        try{
            if (!file.exists()){
                file.createNewFile();
            }
            fw = new FileWriter(file);
            for (int i=100000;i>0;i--){
                fw.write(i+"\n");
                fw.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if (fw!=null){
                try{
                    fw.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }


        //1.创建一个ArrayList集合，保存读取出的待排序数据
        ArrayList<Integer> list = new ArrayList<>();

        //2.创建缓存读取流BufferReader，读取数据并存储的ArrayList中
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = reader.readLine())!=null){
            int i = Integer.parseInt(line);
            list.add(i);
        }
        reader.close();
//        for (int i=100000;i>0;i--){
//            list.add(i);
//        }

        //3.把ArrayList集合转换成数组
        Integer[] a = new Integer[list.size()];
        list.toArray(a);
        //4.调用测试代码完成测试
        testInsertion(a);
        testShell(a);
    }

    /**
     * 测试希尔排序
     * @param a
     */
    public static void testShell(Integer[] a){
        //1.获取执行前的时间
        long start = System.currentTimeMillis();

        //2.执行算法代码
        Shell.sort(a);
        //3.获取执行后的时间
        long end = System.currentTimeMillis();

        //4.算出程序执行的时间并输出
        System.out.println("希尔排序执行的时间为："+(end - start)+"毫秒");
    }

    /**
     * 测试插入排序
     * @param a
     */
    public static void testInsertion(Integer[] a){
        //1.获取执行前的时间
        long start = System.currentTimeMillis();

        //2.执行算法代码
        Insertion.sort(a);
        //3.获取执行后的时间
        long end = System.currentTimeMillis();

        //4.算出程序执行的时间并输出
        System.out.println("插入排序执行的时间为："+(end - start)+"毫秒");
    }


}
