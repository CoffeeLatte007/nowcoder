package jianzhioffer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 * Created by lizhaoz on 2016/3/5.
 */

public class VerifySquenceOfBST {
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence==null||sequence.length<=0)
            return false;
        return verify(sequence,0,sequence.length-1);
    }

    /**
     * 判断sequence在start和end之间是不是后续遍历的结果
     * @param sequence
     * @param start
     * @param end
     * @return
     */
    private boolean verify(int[] sequence, int start, int end) {
        //先找到左边大于根的数,在start到i-1之间

        int i=0,j=0;
        if (start>=end)
            return true;
        for ( i= start; i < end; i++) {
            if (sequence[i]>sequence[end])
                break;
        }
        for (j=i;j<end;j++){
            if (sequence[j]<sequence[end])
                return false;
        }
        boolean left=true;
        if (i>start){
            left=verify(sequence,start,i-1);
        }
        boolean right=true;
        if (i<end){
            right=verify(sequence,i,end-1);
        }
        return left&&right;
    }
}
