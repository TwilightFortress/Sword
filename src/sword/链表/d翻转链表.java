package sword.链表;

import static sword.链表.aa创建链表.CreateList1;
import static sword.链表.aa创建链表.printList;

/**
 * 走一步翻转一个
 * 1.标记下一个节点：              pNext = p.next;
 * 2.将当前节点next指向前一个节点： p.next = pPre;
 * 3.更改2个指针指向：pPre = p; p = pNext;
 * @author yuyang
 * @create 2019-08-08 13:58
 */
public class d翻转链表 {
    /**
     * 非递归
     * @param head
     * @return
     */
    public static ListNode ReverseList(ListNode head) {
        ListNode realHead = null;
        ListNode p = head;
        ListNode pre = null;
        while(p != null){
            ListNode pNext = p.next;
            if(pNext == null) realHead = p;
            p.next = pre;
            pre = p;
            p = pNext;
        }
        return realHead;
    }

    /**
     * 递归
     * @param head
     * @return
     */
    public static ListNode Reverse(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode node = Reverse(head.next);
        head.next.next = head;
        head.next = null;
        return node;
    }

    public static void main(String[] args) {
        ListNode head = CreateList1();
        printList(head);
        ListNode node = Reverse(head);
        printList(node);
    }
}