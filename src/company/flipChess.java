package company;

/**
 * 在4x4的棋盘上摆满了黑白棋子，黑白两色的位置和数目随机其中左上角坐标为(1,1),右下角坐标为(4,4),
 * 现在依次有一些翻转操作，要对一些给定支点坐标为中心的上下左右四个棋子的颜色进行翻转，请计算出翻转后
 * 的棋盘颜色。
   给定两个数组A和f,分别为初始棋盘和翻转位置。其中翻转位置共有3个。请返回翻转后的棋盘。
 * Created by lizhaoz on 2016/4/9.
 */

public class flipChess {
    public static int[][] flipChess(int[][] A, int[][] f) {
        for (int i = 0; i < f.length; i++) {
            int m=f[i][0]-1;
            int n=f[i][1]-1;
            filp(A,m,n);
        }
        return A;
    }

    private static void filp(int[][] a, int m, int n) {
        if (m>0){
            a[m-1][n]=(a[m-1][n]==0?1:0);
        }
        if (m<a.length-1){
            a[m+1][n]=(a[m+1][n]==0?1:0);
        }
        if (n>0){
            a[m][n-1]=(a[m][n-1]==0?1:0);
        }
        if (n<a[m].length-1){
            a[m][n+1]=(a[m][n+1]==0?1:0);
        }
    }

    public static void main(String[] args) {
        int[][] A=new int[][]{{0,1,0,0},{1,0,1,0},{1,1,0,0},{1,0,0,1}};
        int[][] B=new int[][]{{2,3},{4,2},{2,3}};
        flipChess(A,B);
    }
}
