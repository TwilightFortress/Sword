package sword.链表;

import sword.链表.ListNode;

import java.util.ArrayList;

/**
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。
 * 请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 */
public class 链表拆分成奇数偶数两个链表 {

    public ArrayList<ListNode> oddEvenList(ListNode head)
    {
        ArrayList<ListNode> list = new ArrayList<>();
        if(head==null)
            return null;
        if(head.next==null||head.next.next==null)
            return list;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode evenhead=even;//此处的evenhead是链表奇偶化之后偶半链的第一个节点，在下买你的while循环中，evenhead一直处于无前驱节点状态
        while(odd.next!=null&&even.next!=null){
            odd.next=odd.next.next;
            even.next=even.next.next;
            odd=odd.next;
            even=even.next;
        }//经过while循环之后，实际上链表已经被切成两半了，一般是奇链表，一半是偶链表，其中保留了两个指针，一个是odd奇链表的最后一个元素，evenhead是偶链表的第一个节点。
        //odd.next=evenhead;//将奇偶链表连接起来

        list.add(head);
        list.add(evenhead);
        return list;
    }
}
