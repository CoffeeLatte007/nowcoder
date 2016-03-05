package jianzhioffer;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * Created by lizhaoz on 2016/3/5.
 */

public class FindPath {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        ArrayList<Integer> path=new ArrayList<Integer>();
        ArrayList<ArrayList<Integer>> resutList=new ArrayList<ArrayList<Integer>>();
        find(path,resutList,root,target);
        return resutList;
    }

    private void find(ArrayList<Integer> path, ArrayList<ArrayList<Integer>> resutList, TreeNode root, int target) {
        if (root==null)
            return;
        path.add(root.val);
        if (root.left!=null)
            find(path,resutList,root.left,target);
        if (root.right!=null)
            find(path,resutList,root.right,target);
        if (root.left==null&&root.right==null){
            int sum=0;
            Iterator<Integer> integerIterator=path.iterator();
            while (integerIterator.hasNext()){
                sum+=integerIterator.next();
            }
            if (sum==target)
                resutList.add((ArrayList<Integer>) path.clone());
        }
        path.remove(path.size()-1);
    }

}
