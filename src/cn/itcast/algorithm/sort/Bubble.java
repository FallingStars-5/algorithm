package cn.itcast.algorithm.sort;

/**冒泡排序
 * @author 落星
 */
public class Bubble {

    /**
     * 对数组a中的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){

        //定义boolean型变量，用于判断在一趟冒泡中是否存在元素交换
        boolean isChanged = false;

        //外层循环从最后一个元素到第二个元素（只剩一个元素时不需要再冒泡）遍历待排序数组
        for (int i = a.length-1;i>0;i--){

            //内层循环从第一个元素到第i个元素，从前往后冒泡，将本次冒泡中局部最大的元素放到第i个位置
            for (int j=0;j<i;j++){
                if (greater(a[j],a[j+1])){
                    exch(a,j,j+1);
                    isChanged = true;
                }
            }
            //判断在一趟冒泡中是否有元素的交换，如果没有则表示该数组已有序，跳出循环，排序结束
            if (!isChanged){
                break;
            }
        }
    }

    /**
     * 比较元素v是否大于元素
     * @param v
     * @param w
     * @return
     */
    public static boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }


    /**
     * 数组元素i和j交换位置
     * @param a
     * @param i
     * @param j
     */
    public static void exch(Comparable[] a,int i,int j){
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
}
