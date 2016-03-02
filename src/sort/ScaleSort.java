package sort;

import java.util.Scanner;

/**
 * 小范围排序,使用改进的堆排序每个移动不超过k
 * Created by lizhaoz on 2016/1/10.
 */

public class ScaleSort {
    public static void sort(int[] pq) {
        int N = pq.length;
        int k=5;
        int flag=k;
        //把最小的在跟顶
        while (flag<=N) {
            for (int i = k / 2; i >= 1; i--)
                sink(pq, i, k, flag - k);//构造
            flag++;
        }
        flag-=k;
        for (int i = k-1; i >=2 ; i--) {
            for (int j = i / 2; j >= 1; j--)
            sink(pq,j,i,flag);
            flag++;
        }
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private static void sink(int[] pq, int k, int N,int flag) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && !less(pq, j+flag, j+flag+1)) j++;
            if (less(pq, k+flag, j+flag)) break;
            exch(pq, k+flag, j+flag);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(int[] pq, int i, int j) {
        return pq[i-1]<(pq[j-1]) ;
    }

    private static void exch(int[] pq, int i, int j) {
        int swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }

    // is v < w ?


    /***************************************************************************
     *  Check if array is sorted - useful for debugging.
     ***************************************************************************/

    private static void show(int[] a){
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }
    /**
     * Reads in a sequence of strings from standard input; heapsorts them;
     * and prints them to standard output in ascending order.
     */
    public static void main(String[] args) {
        int[] numbers=new int[10];
        Scanner in=new Scanner(System.in);
        for (int i = 0; i < 10; i++) {
            numbers[i]=in.nextInt();
        }
        sort(numbers);
        show(numbers);
    }
}
