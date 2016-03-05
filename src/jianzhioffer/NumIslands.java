package jianzhioffer;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 给一个01矩阵，求不同的岛屿的个数。

 0代表海，1代表岛，如果两个1相邻，那么这两个1属于同一个岛。我们只考虑上下左右为相邻。
 * Created by lizhaoz on 2016/3/3.
 */

public class NumIslands {
    public int numIslands(boolean[][] grid) {
        if (grid==null){
            return 0;
        }
        int n=0;
        int colum=grid[0].length;
        int row=grid.length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j]==true){
                    cleartrue(i,j,grid,colum,row);
                    n++;
                }
            }

        }
        return n;
    }

    private void cleartrue(int i, int j, boolean[][] grid, int colum, int row) {
        if (grid[i][j]!=true)
        return ;
        grid[i][j]=false;
        if (i-1>=0){
            cleartrue(i-1,j,grid,colum,row);
        }
        if (j-1>=0){
            cleartrue(i,j-1,grid,colum,row);
        }
        if (i+1<row){
            cleartrue(i+1,j,grid,colum,row);
        }
        if (j+1<colum)
            cleartrue(i,j+1,grid,colum,row);
    }
}
