package cn.itcast.algorithm.test;

/**
 * @author 落星
 */
public class CircleListInTest {
    public static void main(String[] args) {
        //创建结点
        Node<String> first = new Node<String>("aa",null);
        Node<String> second = new Node<String>("bb",null);
        Node<String> third = new Node<String>("cc",null);
        Node<String> fourth = new Node<String>("dd",null);
        Node<String> fifth = new Node<String>("ee",null);
        Node<String> six = new Node<String>("ff",null);
        Node<String> seven = new Node<String>("gg",null);

        //完成结点之间的指向
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = six;
        six.next = seven;
        //产生环
        seven.next = third;

        //查找环的入口结点
        Node<String> entrance = getEntrance(first);
        System.out.println("first链表中环的入口结点元素为："+entrance.item);


        
    }

    /**
     * 用快慢指针找到环的入口结点:
     * 公理：当快慢指针相遇时，我们可以判断链表中有环，这时重新设定一个新指针temp指向链表的起点，
     * 且步长与慢指针一样为1，则慢指针与新指针相遇的地方就是环的入口。
     * @param first
     * @return
     */
    public static Node<String> getEntrance(Node<String> first){
        //定义快慢指针
        Node<String> fast = first;
        Node<String> slow = first;
        Node<String> temp = null;

        //遍历链表，先找到环（快慢指针相遇），准备一个临时指针指向链表的首结点，继续遍历，直到慢指针和临时指针相遇，相遇的地方就是环的入口
        while (fast!=null && fast.next!=null){
            //变换快慢指针
            fast = fast.next.next;
            slow = slow.next;

            //判断快慢指针是否相遇
            if (fast.equals(slow)){
                temp = first;
                continue;
            }
            //让临时结点变换
            if (temp!=null){
                temp = temp.next;
                //判断临时指针是否与慢指针相遇
                if (temp.equals(slow)){
                    break;
                }
            }
        }
        return temp;
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
        Node next;
        public Node(T item,Node next){
            this.item = item;
            this.next = next;
        }
    }
}
