package cn.itcast.algorithm.sort;

/**
 * @author 落星
 */
public class Quick {

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

    /**
     * 对数组内的元素进行排序
     * @param a
     */
    public static void sort(Comparable[] a){

        int lo=0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }

    /**
     * 对数组a中从lo到hi之间的数据进行排序
     * @param a
     * @param lo
     * @param hi
     */
    private static void sort(Comparable[] a,int lo,int hi){

        //安全性校验
        if (lo>hi){
            return;
        }

        //需要对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）
        //返回分界值位置变换后的索引
        int partition = partition(a,lo,hi);
        //让左子组有序
        sort(a,lo,partition-1);
        //让右子组有序
        sort(a,partition+1,hi);
    }

    /**
     * 对数组a中，从索引lo到索引hi之间的元素进行分组，并返回分组界限对应的索引
     * @param a
     * @param lo
     * @param hi
     * @return
     */
    public static int partition(Comparable[] a,int lo, int hi){
        //确定分界值
        Comparable key = a[lo];
        //定义两个指针，分别指向待切分元素的最小索引处和最大索引处的下一个位置
        int left = lo;
        int right = hi + 1;

        //切分
        while (true){
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while (less(key,a[--right])){
                if (right==lo){
                    break;
                }
            }
            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while (less(a[++left],key)){
                if (left==hi){
                    break;
                }
            }
            //判断left>=right,如果是，则证明元素扫描完毕，结束循环；如果不是，则交换元素即可
            if (left>=right){
                break;
            }else {
                exch(a,left,right);
            }
        }
        //交换分界值
        exch(a,lo,right);
        return right;
    }

}
