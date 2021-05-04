package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * @author 落星
 */
public class Stack<T> implements Iterable<T> {
    /**
     * 记录首结点
     */
    private Node<T> head;
    /**
     * 栈中元素的个数
     */
    private int N;

    public Stack(){
        this.head = new Node<>(null,null);
        this.N = 0;
    }

    /**
     * 判断当前栈中元素个数是否为0
     * @return
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 获取栈中元素的个数
     * @return
     */
    public int size() {
        return N;
    }

    /**
     * 把t元素入栈
     * @param t
     */
    public void push(T t){
        //找到首结点指向的第一个结点
        Node oldFirst = head.next;

        //创建新结点
        Node newNode = new Node(t,null);

        //让首结点指向新结点
        head.next = newNode;

        //让新结点指向原来的第一个结点
        newNode.next = oldFirst;

        //元素个数加1
        N++;
    }

    /**
     * 弹出栈顶元素
     * @return
     */
    public T pop(){

        //找到首结点指向的第一个结点
        Node<T> oldFirst = head.next;

        if (oldFirst==null){
            return null;
        }
        //让首结点指向原来第一个结点的下一个结点
        head.next = oldFirst.next;

        //元素个数减1
        N--;

        return oldFirst.item;
    }

    @Override
    public Iterator<T> iterator() {
        return new SIterator();
    }

    private class SIterator implements Iterator{

        private Node<T> n;

        public SIterator(){
            this.n = head;
        }
        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public Object next() {
            n = n.next;
            return n.item;
        }
    }

    /**
     * 结点类
     */
    private static class Node<T> {
        /**
         * 存储数据
         */
        private T item;
        /**
         * 下一个结点
         */
        Node<T> next;
        public Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }
}
