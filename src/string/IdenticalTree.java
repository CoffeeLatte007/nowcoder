package string;

import java.util.*;

/**
 *

 对于两棵彼此独立的二叉树A和B，请编写一个高效算法，检查A中是否存在一棵子树与B树的拓扑结构完全相同。

 给定两棵二叉树的头结点A和B，请返回一个bool值，代表A中是否存在一棵同构于B的子树。
 把二叉树转换成字符串
 采用kmp算法进行运算
 */


public class IdenticalTree {
    public boolean chkIdentical(TreeNode A, TreeNode B) {
        String t1Str = serialByPre(A);
        String t2Str = serialByPre(B);
        KMPSearch kmpSearch=new KMPSearch(t2Str);
        if (kmpSearch.search(t1Str)!=-1)return true;
        return false;
    }
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;
        public TreeNode(int val) {
            this.val = val;
        }
    }
    public String serialByPre(TreeNode head) {
        if (head == null) {
            return "#!";
        }
        String res = head.val + "!";
        res += serialByPre(head.left);
        res += serialByPre(head.right);
        return res;
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