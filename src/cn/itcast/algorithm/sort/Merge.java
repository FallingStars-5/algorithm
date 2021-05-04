package cn.itcast.algorithm.sort;

/**
 * @author 落星
 */
public class Merge {

    /**
     * 辅助数组
     */
    private static Comparable[] assist;

    /**
     *  比较v元素是否小于w元素
     */
    private static boolean less(Comparable v,Comparable w){
        return v.compareTo(w)<0;
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

    public static void sort(Comparable[] a){
        //1.初始化辅助数组
        assist = new Comparable[a.length];
        //2.定义一个变量lo，hi分别记录数组中最小索引和最大索引
        int lo = 0;
        int hi = a.length-1;
        //3.调用sort重载方法完成a中从索引lo到索引hi的排序
        sort(a,lo,hi);
    }

    /**
     * 对数组a中从lo到hi的元素进行排序
     */
    private static void sort(Comparable[] a,int lo,int hi){
        //1.安全性校验
        if (hi<=lo){
            return;
        }

        //2.lo到hi之间的数据分为两个组
        int mid = lo+(hi-lo)/2;

        //3.分别对每一组数据进行排序
        sort(a,lo,mid);
        sort(a,mid+1,hi);

        //4.再把两个组中的数据进行归并
        merge(a,lo,mid,hi);

    }

    /**
     * 对数组中：从lo到mid为一组，从mid+1到hi为一组，对这两组数据进行归并
     */
    private static void merge(Comparable[] a,int lo,int mid,int hi){

        //定义3个指针
        int i = lo;
        int p1 = lo;
        int p2=mid+1;

        //遍历，移动p1指针和P2指针，比较对应索引处的值，将较小的一个放到辅助数组对应索引处
        while (p1<=mid&&p2<=hi){
            //比较对应索引的值
            if (less(a[p1],a[p2])){
                assist[i++] = a[p1++];
            }else {
                assist[i++] = a[p2++];
            }
        }

        //遍历，如果p1的指针没有遍历完，那么移动p1指针，把对应的元素放到辅助数组的对应索引处


        while (p1<=mid){
            assist[i++] = a[p1++];
        }
        //遍历，如果p2的指针没有遍历完，那么移动p2指针，把对应的元素放到辅助数组的对应索引处

        while (p2<=hi){
            assist[i++] = a[p2++];
        }
        //把辅助数组的元素拷贝到原数组中
        for (int index=lo;index<=hi;index++){
            a[index] = assist[index];
        }
    }
}
