package string;

/**
 *

 如果对于一个字符串A，将A的前面任意一部分挪到后边去形成的字符串称为A的旋转词。比如A="12345",A的旋转词有"12345","23451","34512","45123"和"51234"。对于两个字符串A和B，请判断A和B是否互为旋转词。

 给定两个字符串A和B及他们的长度lena，lenb，请返回一个bool值，代表他们是否互为旋转词。
 测试样例：

 "cdab",4,"abcd",4

 返回：true


 * Created by lizhaoz on 2016/1/28.
 */

public class Rotation {
    public boolean chkRotation(String A, int lena, String B, int lenb) {
        A=A+A;
        KMPSearch kmpSearch=new KMPSearch(B);
        if (kmpSearch.search(A)!=-1)return true;
        return false;
    }
    private class KMPSearch {
        private String pat;
        private int[][] dfa;
        public int search(String txt){
            //模拟DFA处理文本txt时的操作
            int i,j,N=txt.length(),M=pat.length();
            for (i = 0,j=0; i <N&&j<M ; i++) {
                j=dfa[txt.charAt(i)][j];
            }
            if (j==M) return i-M;//找到匹配
            else return -1;//未找到匹配
        }
        public KMPSearch(String pat){
            //由模式字符串构造DFA
            this.pat=pat;
            int M=pat.length();
            int R=256;
            dfa =new int[R][M];
            dfa[pat.charAt(0)][0]=1;
            for (int X = 0,j=1 ;j<M ; j++) {
                //计算dfa[][j]
                for (int c=0;c<R;c++)
                    dfa[c][j]=dfa[c][X];//复制匹配失败情况下的值
                dfa[pat.charAt(j)][j]=j+1;//设置匹配成功情况下的值
                X=dfa[pat.charAt(j)][X];//更新重启状态
            }
        }
    }
}
