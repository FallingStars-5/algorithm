package cn.itcast.algorithm.test;

/**
 * @author 落星
 */
public class JosephTest {
    public static void main(String[] args) {
        //1.构建循环链表，包含41个结点，分别存储1-41之间的值
        //用来记录首结点
        Node<Integer> first = null;
        //用来记录前一个结点
        Node<Integer> pre = null;

        //总人数
        final int sum = 41;

        for (int i=1;i<=sum;i++){
            //如果是第一个结点
            if (i==1){
                first = new Node<>(i,null);
                pre = first;
                continue;
            }

            //如果不是第一个结点
            Node<Integer> newNode = new Node<>(i,null);
            pre.next = newNode;
            pre = newNode;

            //如果是最后一个结点，那么需要让最后一个结点的下一个结点变为first,生成了循环链表
            if (i==sum){
                pre.next = first;
            }
        }

        //2.需要count计数器，模拟报数
        int count = 0;


        //3.遍历循环链表
        //记录每次遍历拿到的结点
        Node n = first;
        //记录当前结点的上一个结点
        Node before = null;
        while (n!=n.next){
            //模拟报数
            count++;

            //判断当前报数是否为3

            if (count==3){
                //如果是3，则把当前结点删除，打印当前结点，重置count=0，让当前结点n后移
                assert before != null;
                before.next = n.next;
                System.out.print(n.item+",");
                count=0;
            }else {
                //如果不是3，让before变为当前结点让当前结点后移
                before=n;
            }
            n=n.next;
        }
        //打印最后一个元素
        System.out.println(n.item);
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
