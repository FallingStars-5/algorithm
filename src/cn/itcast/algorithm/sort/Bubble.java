package cn.itcast.algorithm.sort;

/**
 * @author 落星
 */
public class Bubble {

    /**
     * 对数组a中的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){

        boolean isChanged = false;
        for (int i = a.length-1;i>0;i--){
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
