package company;

/**
 * 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。比如，
 * 对于直方图[2,7,9,4],它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。
 测试样例：[2,7,9,4,1],5
 返回：14
 * Created by lizhaoz on 2016/4/11.
 */

public class MaxInnerRec {
    /**
     * 思路动态规化，dp计算。
     * dp[i][j]的意思是i到j之间的最大矩形面积，这样就容易理解
     * @param A
     * @param n
     * @return
     */
    public int countArea(int[] A, int n) {
        if (A==null){
            return 0;
        }
        int dp[][]=new int[n][n];
        //赋值初值
        for (int i = 0; i < n; i++) {
            dp[i][i]=A[i];
        }
        for (int k = 1; k <=n ; k++) {
            for (int i = 0; (i+k) <n ; i++) {
                //先算出最小值
                int min=A[i];
                for (int j = i+1; j <= i+k; ++j) {
                    min = Math.min(min, A[j]);
                }
                dp[i][i+k]=Math.max(dp[i][i+k-1], dp[i+1][i + k]);
                dp[i][i+k]=Math.max(min*(k+1),dp[i][i+k]);
            }
        }
        return dp[0][n-1];
    }
}
