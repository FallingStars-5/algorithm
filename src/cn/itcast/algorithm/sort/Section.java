package cn.itcast.algorithm.sort;

/**选择排序算法
 * @author 落星
 */
public class Section {

    /**
     * 对数组a中的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){
        //从一个元素到倒数第二个元素遍历待排序数组
        for (int i=0;i<=a.length-2;i++){
            //定义一个变量，记录最小元素所在索引，默认为第一个元素所在位置
            int minIndex = i;

            //从第i+1个元素到最后一个元素遍历数组，找到本次排序中局部最小值所在的索引，并和第i个位置的元素交换值
            for (int j=i+1;j<a.length;j++){
                //需要比较最小索引minIndex处的值和j索引处的值
                if (greater(a[minIndex],a[j])){
                    minIndex = j;
                }
            }
            //交换最小元素minIndex所在索引和索引i处的值
            exch(a,i,minIndex);

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
