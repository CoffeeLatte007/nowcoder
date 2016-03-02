package sort;

/**
 * 有一个只由0，1，2三种元素构成的整数数组，请使用交换、原地排序而不是使用计数进行排序。

 给定一个只含0，1，2的整数数组A及它的大小，请返回排序后的数组。保证数组大小小于等于500。
 测试样例：
 * Created by lizhaoz on 2016/1/10.
 */

public class ThreeColor {
    public static int[] sortThreeColor(int[] A, int n) {
        int i=0,j=n-1;
        for (int k = 0; k < n; k++) {
            if (k>j)break;
            if(A[k]==0) exch(A,k,i++);
            if (A[k]==2)exch(A,k--,j--);
        }
        return A;
    }
    private static void exch(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }
    private static void show(int[] a){
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] A=new int[]{1,2,0,2};
        sortThreeColor(A,4);
        show(A);
    }
}
