package cn.itcast.algorithm.test;

import cn.itcast.algorithm.linear.Queue;

/**
 * @author 落星
 */
public class PageFoldingTest {
    public static void main(String[] args) {
        //模拟折纸的过程产生树
        Node<String> tree = createTree(2);

        //遍历树，打印结果
        printTree(tree);
    }

    /**
     * 通过模拟对折N次折纸产生树
     * @param N
     * @return
     */
    public static Node<String> createTree(int N){
        //定义根节点
        Node<String> root = null;
        for (int i=0;i<N;i++){
            //1、当前树是第一次对折:空树
            if (i==0){
                root = new Node<>("down",null,null);
                continue;
            }
            //2.当前不是第一次对折
            //定义一个辅助队列，通过层序遍历的思想，找到叶子结点，叶子节点添加子节点
            Queue<Node<String>> queue = new Queue<>();
            queue.enqueue(root);

            //遍历循环队列
            while (!queue.isEmpty()){
                //从队列中弹出一个结点
                Node<String> tmp = queue.dequeue();

                //如果有左字节点，则把左子节点放入到队列中
                if (tmp.left!=null){
                    queue.enqueue(tmp.left);
                }

                //如果有右子结点，则把右子节点放入到队列中
                if (tmp.right!=null){
                    queue.enqueue(tmp.right);
                }

                //如果同时没有左子结点和右子节点，那么该节点是叶子节点，只需要给该节点添加左子节点和右子节点
                if (tmp.right==null&&tmp.left==null){
                    tmp.left = new Node<String>("down",null,null);
                    tmp.right = new Node<String>("up",null,null);
                }
            }
        }
        return root;
    }

    /**
     * 打印树中每个结点到控制台
     * @param root
     */
    public static void printTree(Node<String> root){
        //需要使用中序遍历完成
        if (root==null){
            return;
        }

        //打印左子树的每个结点
        if (root.left!=null){
            printTree(root.left);
        }

        //打印当前结点
        System.out.print(root.item+" ");

        //打印右子树的每个结点
        if (root.right!=null){
            printTree(root.right);
        }
    }

    /**
     * 结点类
     * @param <T>
     */
    public static class Node<T>{
        /**
         * 存储元素
         */
        public T item;

        public Node<T> right;
        public Node<T> left;

        private Node(T item, Node<T> left, Node<T> right){
            this.item = item;
            this.left = left;
            this.right = right;
        }
    }
}
