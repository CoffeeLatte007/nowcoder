package bookzuo;

/**
 * Created by lizhaoz on 2016/4/5.
 */

public class TXDP {
    public static void main(String[] args) {
        String str="BABCBAB";
        System.out.println(findLSP(str));
    }

    private static int findLSP(String str) {
        int n=str.length();
        char[] s=str.toCharArray();
        int dp[][]=new int[n][n];
        for (int i = 0; i <n ; i++) {
            dp[i][i]=1;
        }
         for (int len = 1; len <n ; len++) {
            for (int i = 0; i+len <n ; i++) {
                if (s[i]==s[i+len]){
                    dp[i][i+len]=dp[i+1][i+len-1]+2;
                }else {
                    dp[i][i+len]=Math.max(dp[i+1][i+len],dp[i][i+len-1]);
                }
            }
        }
        return dp[0][n-1];
    }
}
