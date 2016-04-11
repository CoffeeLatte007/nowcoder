package company;

/**
 * 有一个长为n的数组A，求满足0≤a≤b<n的A[b]-A[a]的最大值。
 给定数组A及它的大小n，请返回最大差值。
 测试样例：
 * Created by lizhaoz on 2016/4/9.
 */

public class GetDis {
    /**
     * 思路用min来记录数组当前遍历最小值，每次减去当前最小的，用一个值来记录最大,遍历一次 O（n）算法
     * @param A
     * @param n
     * @return
     */
    public int getDis(int[] A, int n) {
        int res=0;
        if (n>1){
            int min=A[0];
            for (int i = 1; i <n ; i++) {
                if (A[i]-min>res){
                    res=A[i]-min;
                }
                if (A[i]<min){
                    min=A[i];
                }
            }
        }
        return res;
    }
}
