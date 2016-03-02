package sort;

/**
 * 对于一个数组，请设计一个高效算法计算需要排序的最短子数组的长度。

 给定一个int数组A和数组的大小n，请返回一个二元组，代表所求序列的长度。(原序列位置从0开始标号,若原序列有序，返回0)。保证A中元素均为正整数。
 测试样例：

 [1,4,6,5,9,10],6

 返回：2
 * Created by lizhaoz on 2016/1/10.
 */

public class Subsequence {
    public static int shortestSubsequence(int[] A, int n) {
        int i=up(A,n);
        int j=low(A,n);
        if(i>j)return i-j+1;
        return 0;
    }

    private static int low(int[] a, int n) {

        int m=0;
        int min=a[n-1];
        for (int i = n-2; i >=0; i--) {
            if(a[i]<=min){
                min=a[i];
            }
            else {
                m=i;
            }
        }
        return m;
    }

    private static int up(int[] a, int n) {
        int m=0;
        int max=a[0];
        for (int i = 1; i <n; i++) {
            if(a[i]>=max){
                max=a[i];
            }
            else {
                m=i;
            }
        }
        return m;
    }
    private static void exch(int[] a,int i,int j){
        int t=a[i];
        a[i]=a[j];
        a[j]=t;
    }

    public static void main(String[] args) {
        System.out.println(shortestSubsequence(new int[]{1,2,3,3,8,9},6));
    }
}
