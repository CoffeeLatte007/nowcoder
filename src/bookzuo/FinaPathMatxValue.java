package bookzuo;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by lizhaoz on 2016/4/6.
 *
 */
class mydp{
    public int value;
    public String path="";

    public mydp(int value,String path) {
        this.value = value;
        this.path=path;
    }

    public void setPath(String path) {
        this.path += (path+" ");
    }
}
public class FinaPathMatxValue {
    public static void main(String[] args) {
        int[][] test=new int[][]{{3,8,7,2},{4,3,1,5},{7,4,3,1},{5,1,6,4}};
        System.out.println(findPathMaxValue(test).path);
    }

    private static mydp findPathMaxValue(int[][] test) {
        mydp[][] dp=new mydp[test.length][test[0].length];
        dp[0][0]=new mydp(test[0][0],String.valueOf(test[0][0]));
        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                if (i==0&&j==0){
                    continue;
                }

                else if (j==0){
                    dp[i][j]=new mydp((dp[i-1][j].value+test[i][j]),dp[i-1][j].path+" "+String.valueOf(test[i][j]));
                }
                else if (i==0){
                    dp[i][j]=new mydp((dp[i][j-1].value+test[i][j]),dp[i][j-1].path+" "+String.valueOf(test[i][j]));
                }
                else {
                    if (dp[i-1][j].value>dp[i][j-1].value){
                        dp[i][j]=new mydp((dp[i-1][j].value+test[i][j]),dp[i-1][j].path+" "+String.valueOf(test[i][j]));
                    }else {
                        dp[i][j]=new mydp((dp[i][j-1].value+test[i][j]),dp[i][j-1].path+" "+String.valueOf(test[i][j]));
                    }

                }
            }
        }
        return dp[test.length-1][test[0].length-1];
    }
}
