package jianzhioffer;

import java.util.ArrayList;

/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，
 * 如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10
 * Created by lizhaoz on 2016/3/3.
 */

public class PrintMatrix {
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        if (matrix==null||matrix.length<=0){
            return null;
        }
        int row=matrix.length;
        int column=matrix[0].length;
        int start=0;
        ArrayList<Integer> arrayList=new ArrayList<Integer>();
        while (row>start*2&&column>start*2){
            print(matrix,row,column,start,arrayList);
            start++;
        }
        return arrayList;
    }

    private void print(int[][] matrix, int row, int column, int start,ArrayList<Integer> arrayList) {
        int endy=row-start-1;
        int endx=column-start-1;
        for (int i = start; i <=endx; i++) {
            arrayList.add(matrix[start][i]);
        }
        if (endy>start){
            for (int i = start+1; i <=endy ; i++) {
                arrayList.add(matrix[i][endx]);
            }
            if (endx>start){
                for (int i=endx-1;i>=start;i--){
                    arrayList.add(matrix[endy][i]);
                }
                if (endy>start+1){
                    for (int i=endy-1;i>=start+1;i--){
                        arrayList.add(matrix[i][start]);
                    }
                }
            }
        }


    }

    public static void main(String[] args) {

            PrintMatrix printMatrix=new PrintMatrix();
            int[][] matrix=new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
            printMatrix.printMatrix(matrix);

    }
}
