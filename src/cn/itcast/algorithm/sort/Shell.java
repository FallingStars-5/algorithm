package cn.itcast.algorithm.sort;

/**
 * @author 落星
 */
public class Shell {

    /**
     * 对数组a中的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){
        //1.根据数组a的长度确定增长量h的大小

        //为何是这个规则
        int h = 1;
        while (h<a.length/2){
            h=2*h+1;
        }
        //2.希尔排序
        while (h>=1){
            //排序
            //2.1 找到待插入的元素
            for (int i=h;i<a.length;i++){
                //2.2 把待插入的元素插入到有序序列中
                for (int j=i;j>=h;j -= h){
                    //待插入元素a[j]，比较a[j]和a[j-h]
                    if (greater(a[j-h],a[j])){
                        exch(a,j-h,j);
                    }else {
                        break;
                    }
                }
            }
            //减小h的值
            h = h/2;
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
