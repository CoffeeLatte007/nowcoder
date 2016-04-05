package bookzuo;

import java.util.HashMap;

/**
 * Created by lizhaoz on 2016/4/5.
 */

public class randNode {
    private  class Node{
        public int value;
        public Node next;
        public Node rand;
        public Node(int data){
            this.value=data;
        }
    }

    /**
     * 普通解法利用HashMap
     * @param head
     * @return
     */
    public Node copyListWithRand1(Node head){
        HashMap<Node,Node> map=new HashMap<Node, Node>();
        Node cur=head;
        //遍历第一次链表
        while (cur!=null){
            map.put(cur,new Node(cur.value));
            cur=cur.next;
        }
        cur=head;
        //遍历第二次，设置next和rand
        while (cur!=null){
            map.get(cur).next=map.get(cur.next);
            map.get(cur).rand=map.get(cur.rand);
            cur=cur.next;
        }
        //返回头
        return map.get(head);
    }

    /**
     * 进阶解法不利用HashMap
     * @param head
     * @return
     */
    public Node copyListWithRand2(Node head){
        if (head==null){
            return null;
        }
        Node cur=head;
        Node next=null;
        //遍历一次,复制并链接每一个节点
        while (cur!=null){
            next=cur.next;
            cur.next=new Node(cur.value);
            cur.next.next=next;
            cur=next;
        }
        cur=head;
        Node curCopy=null;
        //设置复制节点的rand指针
        while (cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            curCopy.rand=cur.rand!=null?cur.rand.next:null;
            cur=next;
        }
        Node res=head.next;
        cur=head;
        //拆分
        while (cur!=null){
            next=cur.next.next;
            curCopy=cur.next;
            cur.next=next;
            curCopy.next=next!=null?next.next:null;
            cur=next;
        }
        return res;
    }

    public static void main(String[] args) {
        int i=0,j=1;
        String s="s";
        if ((i!=0)&(j/i==1)){

        }
        if ((i==0)||(j/i==1)){
            System.out.println();
        }
    }
}
