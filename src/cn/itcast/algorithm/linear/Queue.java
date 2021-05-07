package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * @author 落星
 */
public class Queue<T> implements Iterable<T> {
    /**
     * 记录首结点
     */
    private Node<T> head;

    /**
     * 当前栈的元素个数
     */
    private int N;

    /**
     * 记录最后一个结点
     */
    private Node<T> last;

    public Queue(){
        this.head = new Node<T>(null,null);
        this.last = null;
        this.N = 0;
    }

    /**
     * 判断队列是否为空
     * @return 为空则返回true；否则返回false
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 获取队列中元素的个数
     * @return
     */
    public int size(){
        return N;
    }

    /**
     * 从队列中拿出一个元素
     * @return
     */
    public T dequeue(){
        if (isEmpty()){
            return null;
        }
        Node<T> oldFirst = head.next;
        head.next = oldFirst.next;
        N--;
        //因为出队列是在删除元素，如果删除完了，需要重置last为null
        if (isEmpty()){
            last = null;
        }
        return oldFirst.item;
    }

    /**
     * 往队列中插入一个元素
     * @param t
     */
    public void enqueue(T t){
        //当前尾节点last为null

        if (last==null){
            last = new Node<>(t,null);
            head.next = last;
        }else {
            //尾结点不为null
            Node<T> oldLast = last;
            last = new Node<>(t,null);
            oldLast.next = last;
        }
        N++;
    }

    @Override
    public Iterator iterator() {
        return new QIterator();
    }

    private class QIterator implements Iterator<T>{

        private Node<T> n;

        public QIterator(){
            this.n = head;
        }

        @Override
        public boolean hasNext() {
            return n.next!=null;
        }

        @Override
        public T next() {
            n = n.next;
            return n.item;
        }
    }

    private static class Node<T>{
        /**
         * 存储数据
         */
        private T item;

        /**
         * 存储下一个结点的引用
         */
        private Node<T> next;

        public Node(T item, Node<T> next){
            this.item = item;
            this.next = next;
        }
    }
}
