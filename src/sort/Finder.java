package sort;

/**
 * 现在有一个行和列都排好序的矩阵，请设计一个高效算法，快速查找矩阵中是否含有值x。

 给定一个int矩阵mat，同时给定矩阵大小nxm及待查找的数x，请返回一个bool值，代表矩阵中是否存在x。所有矩阵中数字及x均为int范围内整数。保证n和m均小于等于1000。
 测试样例：

 [[1,2,3],[4,5,6],[7,8,9]],3,3,10
 * Created by lizhaoz on 2016/1/10.
 */

public class Finder {
    public static boolean findX(int[][] mat, int n, int m, int x) {
        return find(mat, mat.length, mat[0].length, x,0,mat[0].length-1);
    }

    private static boolean find(int[][] mat, int n, int m, int x, int i, int m1) {
        if (i>=n||m1<0){
            return false;
        }
        else if(mat[i][m1]==x) return true;
        else if(mat[i][m1]<x){
            return find(mat,n,m,x,i+1,m1);
        }
        else {
            return find(mat,n,m,x,i,m1-1);
        }
    }

    public static void main(String[] args) {
        int[][] mat=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(findX(mat,3,3,9));
    }


}
