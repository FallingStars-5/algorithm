package cn.itcast.algorithm.linear;

import java.util.Iterator;

/**
 * @author 落星
 */
public class LinkList<T> implements Iterable{

    /**
     * 记录头结点
     */
    private Node head;

    /**
     * 记录链表的长度
     */
    private int N;

    @Override
    public Iterator iterator() {
        return new LIterator();
    }

    private class LIterator implements Iterator{

        private Node n;
        public LIterator(){
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

    private class Node{
        /**
         * 存储数据
         */
        T item;

        /**
         * 下一个结点
         */
        Node next;

        public Node(T item, Node next){
            this.item = item;
            this.next = next;
        }
    }

    public LinkList(){
        //初始化头结点
        this.head = new Node(null,null);
        //初始化元素个数
        this.N = 0;
    }

    /**
     * 清空链表
     */
    public void clear(){
        head.next = null;
        this.N = 0;
    }

    /**
     * 获取链表的长度
     */
    public int length(){
        return N;
    }

    /**
     * 判断链表是否为空
     */
    public boolean isEmpty(){
        return N==0;
    }

    /**
     * 获取指定位置i处的元素
     */
    public T get(int i){
        if (i>=N){
            return null;
        }

        Node n = head.next;
        //通过循环从头结点开始往后找，依次找i次，就可以找到对应的元素
        for (int index = 0;index<i;index++){
            n = n.next;
        }
        return n.item;
    }

    /**
     * 向链表中添加元素t
     */
    public void insert(T t){
        //找到当前最后一个结点
        Node n = head;
        while (n.next!=null){
            n = n.next;
        }
        //创建一个新结点保存元素t
        Node newNode = new Node(t,null);

        //让当前最后一个结点指向新结点
        n.next = newNode;
        //元素的个数加1
        N++;
    }

    /**
     * 向链表指定位置i处添加元素t
     */
    public void insert(int i, T t){
        //找到i位置前1个结点
        Node pre = head;
        for (int index=0;index<=i-1;index++){
            pre = pre.next;
        }

        //找到i位置的结点
        Node curr = pre.next;

        //创建新结点，并且新结点需要指向原来i位置的结点
        Node newNode = new Node(t,curr);

        //原来i位置的前一个结点指向新结点
        pre.next=newNode;

        //元素个数加1
        N++;
    }

    /**
     * 删除指定位置i处的元素，并返回被删除的元素
     */
    public T remove(int i){
        if (i>=N){
            return null;
        }
        //找到i位置的前一个结点
        Node pre = head;
        for (int index=0;index<=i-1;i++){
            pre = pre.next;
        }

        //要找到i位置的结点
        Node curr = pre.next;

        //找到i位置的下一个结点
        Node nextNode = curr.next;

        //前一个结点指向下一个结点
        pre.next = nextNode;

        //元素个数减1
        N--;
        return curr.item;
    }

    /**
     * 查找元素t在链表中第一次出现的位置
     */
    public int indexOf(T t){
        //从头结点开始，依次找到每一个结点，取出item和t比较，如果相等，则找到
        Node n = head;
        for (int i=0;n.next!=null;i++){
            n = n.next;
            if (n.item.equals(t)){
                return i;
            }
        }
        return -1;
    }

    /**
     * 用来反转整个链表
     */
    public void reverse(){

        //判断当前链表是否为空，如果是，则结束运行；否则调用重载的reverse()方法，完成反转
        if (isEmpty()){
            return;
        }

        reverse(head.next);
    }

    /**反转某节点，并返回反转后的结点
     *
     * @param curr
     * @return
     */
    public Node reverse(Node curr){

        if (curr.next==null){
            head.next = curr;
            return curr;
        }
        //递归地反转下一个结点;返回值就是链表反转后当前结点的上一个结点
        Node pre = reverse(curr.next);

        //让返回的结点的下一个结点变为当前结点
        pre.next = curr;

        //把当前结点的下一个结点变为null
        curr.next = null;

        return curr;
    }
}