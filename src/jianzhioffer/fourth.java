package jianzhioffer;


/**
 * Created by lizhaoz on 2016/2/29.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
public class fourth {
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre==null||in==null){
            return null;
        }
        return re(pre,0,pre.length-1,in,0,in.length-1);
    }

    private TreeNode re(int[] pre, int prestart, int preend, int[] in, int instart, int inend) {
        if(prestart>preend||instart>inend)
            return null;
        TreeNode root=new TreeNode(pre[prestart]);//得到了顶点
        //遍历中序遍历的每个点
        for(int i=instart;i<=inend;i++){
            if (pre[prestart]==in[i])
            {
                root.left=re(pre,prestart+1,prestart+i-instart,in,instart,i-1);
                root.right=re(pre,prestart+i-instart+1,preend,in,i+1,inend);
            }
        }
        return root;
    }
}
