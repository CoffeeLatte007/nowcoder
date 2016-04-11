package company;

/**
 * 现在有一个城市销售经理，需要从公司出发，去拜访市内的商家，已知他的位置以及商家的位置，
 * 但是由于城市道路交通的原因，他只能在左右中选择一个方向，在上下中选择一个方向，现在问他有多少种方案
 * 到达商家地址。
 给定一个地图map及它的长宽n和m，其中1代表经理位置，2代表商家位置，-1代表不能经过的地区，
 0代表可以经过的地区，请返回方案数，保证一定存在合法路径。保证矩阵的长宽都小于等于10。
 * Created by lizhaoz on 2016/4/9.
 */

public class countPath {
    /**
     * step1:先找到经理和商家的位置，用(x1,y1)记录经理,用(x2,y2)记录商家
     * step2:判断行走方向,两条行走方向副对角线和主对角线
     * @param map
     * @param n
     * @param m
     * @return
     */
    public int countPath(int[][] map, int n, int m) {
        int x1=0,x2 = 0,y1 = 0,y2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j=0;j<m;j++){
                if (map[i][j]==1){
                    x1=i;y1=j;
                }else if(map[i][j]==2){
                    x2=i;y2=j;
                }
            }
        }
        //如果经理和商店位置相同 就不需要走
        if (x1==x2&&y1==y2){
            return 1;
        }
        //这里用x1保存X坐标较小的一个方便计算
        if (x1>x2){
            x1 = x1^x2^(x2=x1);//用异或提升速度
            y1 = y1^y2^(y2=y1);
        }
        int dp[][]=new int[n][m];
        //在主对角线
        if(y1<y2){// 两点处在主对角线上
            dp[x1][y1] = 1;
            //先把外圈的赋值防止数组越界
            for (int i = x1+1; i<=x2; i++) {
                dp[i][y1] = map[i][y1]==-1?0:dp[i-1][y1];
            }
            for (int j = y1+1; j <=y2; j++) {
                dp[x1][j] = map[x1][j]==-1?0:dp[x1][j-1];
            }
            for (int i = x1+1; i <= x2; i++) {
                for (int j = y1+1; j <=y2; j++) {
                    dp[i][j] = map[i][j]==-1?0:dp[i-1][j]+dp[i][j-1];
                }
            }
        }else{// 两者处在副对角线上
            dp[x1][y1] = 1;
            for (int i = x1+1; i<=x2; i++) {
                dp[i][y1] = map[i][y1]==-1?0:dp[i-1][y1];
            }
            for (int j = y1-1; j >=y2; j--) {
                dp[x1][j] = map[x1][j]==-1?0:dp[x1][j+1];
            }
            for (int i = x1+1; i <= x2; i++) {
                for (int j = y1-1; j >=y2; j--) {
                    dp[i][j] = map[i][j]==-1?0:dp[i-1][j]+dp[i][j+1];
                }
            }
        }
        return dp[x2][y2];
    }
}
