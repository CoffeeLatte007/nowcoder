package jianzhioffer;

/**
 * Created by lizhaoz on 2016/4/4.
 */
class Node{
    public int value;
    public Node next;
    public Node(int data){
        this.value=data;
    }
}
public class quicklist {
    public Node listPartition1(Node head,int privot){
        if (head==null){
            return head;
        }
        Node cur=head;
        int i=0;
        //先遍历一遍获得链表的
        while(cur!=null){
            i++;
            cur=cur.next;
        }
        Node[] nodeArr=new Node[i];
        i=0;
        cur=head;
        for (i = 0; i !=nodeArr.length ; i++) {
            nodeArr[i]=cur;
            cur=cur.next;
        }
        //调整在数组中的顺序
        arrPartion(nodeArr,privot);
        //调整赋值
        for (i = 0; i != nodeArr.length; i++) {
            nodeArr[i-1].next=nodeArr[i];//
        }
        nodeArr[i-1].next=null;
        return nodeArr[0];
    }

    /**
     * 三向切分快排一趟交换，需要三个记录量
     * @param nodeArr
     * @param privot
     */
    private void arrPartion(Node[] nodeArr, int privot) {
        int small=-1;
        int big=nodeArr.length;
        int index=0;
        while (index!=big){
            if (nodeArr[index].value<privot){
                swap(nodeArr,++small,index++);
            }else if (nodeArr[index].value==privot){
                index++;
            }else {
                swap(nodeArr,--big,index);
            }
        }
    }

    private void swap(Node[] nodeArr, int i, int j) {
        Node tmp=nodeArr[i];
        nodeArr[i]=nodeArr[j];
        nodeArr[j]=tmp;
    }
}
