package company;

/**
 * Created by lizhaoz on 2016/4/9.
 */

public class LCSE {
    static int findLCS(String a,String b){
        int la=a.length();
        int lb=b.length();
        char[] al=a.toCharArray();
        char[] bl=b.toCharArray();
        int[][] dp=new int[la+1][lb+1];
        for (int i = 1; i <=la ; i++) {
            for (int j = 1; j <=lb; j++) {
                if (al[i-1]==bl[j-1]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[la][lb];
    }

    public static void main(String[] args) {
        String a="ABCDE";
        String b="A";
        System.out.println(findLCS(a,b));
    }
}
