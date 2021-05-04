package cn.itcast.algorithm.test;

/**
 * @author 落星
 */
public class CircleListCheckTest {
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
        seven.next = first;

        boolean isCircle = isCircle(first);

        if (isCircle){
            System.out.println("该链表中有环！");
        }else {
            System.out.println("该链表中无环！");
        }


        
    }

    /**判断一个链表中是否有环
     * @param first 链表首结点
     * @return true为有环，false为无环
     */
   public static boolean isCircle(Node<String> first){
       //定义快慢指针
       Node<String> fast = first;
       Node<String> slow = first;

       //遍历链表，如果快慢指针指向了同一个结点，证明有环
       while (fast!=null&&fast.next!=null){
           //变换fast和slow
           fast = fast.next.next;
           slow = slow.next;

           if (fast.equals(slow)){
               return true;
           }
       }
        return false;
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
