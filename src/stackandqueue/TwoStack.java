package stackandqueue;

import java.util.Arrays;
import java.util.Stack;

/**
 *

 编写一个类,只能用两个栈结构实现队列,支持队列的基本操作(push，pop)。
 给定一个操作序列ope及它的长度n，其中元素为正数代表push操作，为0代表pop操作，
 保证操作序列合法且一定含pop操作，请返回pop的结果序列。
 测试样例：
 [1,2,3,0,4,0],6
 返回：[1,2]
 * Created by lizhaoz on 2016/2/3.
 */
public class TwoStack {
    public int[] twoStack(int[] ope, int n) {
        Stack<Integer> dataStack=new Stack<Integer>();
        Stack<Integer> queueStack=new Stack<Integer>();
        int[] result=new int[n];
        int k=0;
        for (int i=0;i<n;i++){
            if (ope[i]==0){
                while (dataStack.size()!=0){
                    queueStack.push(dataStack.pop());
                }
                result[k++]=queueStack.pop();
                while (queueStack.size()!=0){
                    dataStack.push(queueStack.pop());
                }
            }
            else dataStack.push(ope[i]);
        }

         int[] resul=new int[k];
        for (int i = 0; i < resul.length; i++) {
            resul[i]=result[i];
        }
        return resul;
    }
}