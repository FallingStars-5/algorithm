package cn.itcast.algorithm.linear;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author 落星
 */
public class SequenceList<T> implements Iterable {
    /**
     * 存储元素的数组
     */
    private T[] eles;

    /**
     * 记录当前顺序表中的元素个数
     */
    private int N;

    /**
     * 构造方法
     */
    public SequenceList(int capacity){
        //初始化数组
        this.eles =(T[] ) new Object[capacity];
        //初始化长度
        //this.N = capacity;
    }

    /**
     * 将一个线性表置为空表
     */
    public void clear(){
        this.N = 0;
        //this.eles = null;
    }

    /**
     * 判断当前线性表是否为空表
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 获取线性表的长度
     */
    public int length(){
        return N;
    }

    /**
     * 获取指定位置的元素
     */
    public T get(int i){

        if (i>=N){
            return null;
        }

        return eles[i];
    }

    /**
     * 向线性表中添加元素t
     */
    public void insert(T t){


        //先判断，扩容
        if (N==eles.length){
            //如果元素的个数等于数组的大小，则扩大数组容量为原来的2倍
            resize(2*eles.length);
        }

        eles[N++] = t;
    }

    /**
     * 在i元素处插入元素t
     */
    public void insert(int i, T t){

        if (i>=N){
            return;
        }

        //先判断，扩容
        if (N==eles.length){
            //如果元素的个数等于数组的大小，则扩大数组容量为原来的2倍
            resize(2*eles.length);
        }

        N++;
        //先把i索引处的元素和之后所有的元素依次向后移动一位
        for (int index = N-1;index>i;index--){
            eles[index] = eles[index-1];
        }

        eles[i] = t;
    }

    /**
     * 删除指定位置i处的元素，并返回该元素
     */
    public T remove(int i){

        if (i>=N){
            return null;
        }

        //记录索引i处的值
        T current = eles[i];
        //让索引i后面元素依次向后移动一位
        for (int index = i;index<N-1;index++){
            eles[index] = eles[index+1];
        }
        N--;

        //如果元素的个数小于数组容量的1/4，则缩小其容量为原来的1/2
        final int k = 4;
        if (N<eles.length/k){
            resize(eles.length/2);
        }
        return current;
    }

    /**
     * 查找t元素第一次出现的位置
     */
    public int indexOf(T t){
        for (int index = 0;index<N;index++){
            if (eles[index].equals(t)){
                return index;
            }
        }
        return -1;
    }

    /**
     * 根据参数newSize，重置eles的大小
     * @param newSize
     */
    public void resize(int newSize){
        //定义一个临时数组，指向原数组
        T[] temp = eles;
        //创建新数组
        eles=(T[]) new Object[newSize];
        //把原数组的数据拷贝到新数组中
        for (int i=0;i<N;i++){
            eles[i]=temp[i];
        }
    }

    @Override
    public Iterator iterator() {
        return new SIterator();
    }

    @Override
    public void forEach(Consumer action) {

    }

    @Override
    public Spliterator spliterator() {
        return null;
    }



    private class SIterator implements Iterator{

        private int cusor;
        public SIterator(){
            this.cusor=0;
        }
        @Override
        public boolean hasNext() {
            return cusor<N;
        }

        @Override
        public Object next() {
            return eles[cusor++];
        }

    }
}
