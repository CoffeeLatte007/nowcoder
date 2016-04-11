package company;

/**
 * Created by lizhaoz on 2016/4/9.
 */

public class LCST {
        public static int[][] getdp(String str1,String str2){
            int la=str1.length();
            int lb=str2.length();
            char[] str1array=str1.toCharArray();
            char[] str2array=str2.toCharArray();
            int[][] dp=new int[la+1][lb+1];//防止溢出
            for (int i = 1; i <=la ; i++) {
                for (int j = 1; j <=lb ; j++) {
                    if (str1array[i-1]==str2array[j-1]){
                        dp[i][j]=dp[i-1][j-1]+1;
                    }
                }
            }
            return dp;
        }

    public static String lcst1(String str1,String str2){
        if (str1==null||str2==null||str1.equals("")||str2.equals("")){
            return "";
        }
        int[][]dp=getdp(str1,str2);
        int end=0;
        int max=0;
        for (int i = 1; i <=str1.length() ; i++) {
            for (int j = 1; j <=str2.length() ; j++) {
                if (dp[i][j]>max){
                    end=i;
                    max=dp[i][j];
                }
            }
        }
        return str1.substring(end-max,end);
    }

    public static void main(String[] args) {
        String str1="abcde";
        String str2="bebcd";
        System.out.println(lcst2(str1, str2));
    }

    private static String lcst2(String str1, String str2) {
        if (str1==null||str2==null||str1.equals("")||str2.equals("")){
            return "";
        }
        int la=str1.length();
        int lb=str2.length();
        char[] str1array=str1.toCharArray();
        char[] str2array=str2.toCharArray();
        int row=0;//斜线开始位置的行
        int col=lb-1;//斜线开始位置的列
        int max=0;//记录最大长度
        int end=0;//记录最大长度结尾的位置
        while (row<la){
            int i=row;
            int j=col;
            int len=0;//记录初始的值
            //从(i,j)向右下方遍历
            while (i<la&&j<lb){
                if (str1array[i]!=str2array[j]){
                    len=0;
                }else {
                    len++;
                }
                //记录最大值，以及结束字符的位置
                if (len>max){
                    end=i;
                    max=len;
                }
                i++;
                j++;
            }
            if (col>0){ //斜线左移
                col--;
            }else { //斜线下移
                row++;
            }
        }
        return str1.substring(end-max+1,end+1);
    }
}
