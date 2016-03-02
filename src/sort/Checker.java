package sort;

import java.util.Scanner;

/**
 * 判断是否有重复值
 * Created by lizhaoz on 2016/1/10.
 */

public class Checker {
    public boolean checkDuplicate(int[] a, int n) {
        sort(a);
        int count=0;
        for (int i = 1; i < a.length; i++) {
            if (a[i]==a[i-1])
                count++;
        }
        if (count==0) return false;
        return true;
    }
    public static void sort(int[] pq) {
        int N = pq.length;
        for (int k = N/2; k >= 1; k--)
            sink(pq, k, N);//构造
        show(pq);
        while (N > 1) {
            exch(pq, 1, N--);
            sink(pq, 1, N);
        }
    }

    /***************************************************************************
     * Helper functions to restore the heap invariant.
     ***************************************************************************/

    private static void sink(int[] pq, int k, int N) {
        while (2*k <= N) {
            int j = 2*k;
            if (j < N && less(pq, j, j+1)) j++;
            if (!less(pq, k, j)) break;
            exch(pq, k, j);
            k = j;
        }
    }

    /***************************************************************************
     * Helper functions for comparisons and swaps.
     * Indices are "off-by-one" to support 1-based indexing.
     ***************************************************************************/
    private static boolean less(int[] pq, int i, int j) {
        return pq[i-1]<pq[j-1];
    }

    private static void exch(int[] pq, int i, int j) {
        int swap = pq[i-1];
        pq[i-1] = pq[j-1];
        pq[j-1] = swap;
    }




    private static void show(int[] a){
        for (int i = 0; i <a.length ; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
