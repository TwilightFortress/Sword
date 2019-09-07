package sword.链表;

import static sword.链表.aa创建链表.CreateList2;
import static sword.链表.aa创建链表.printList;

/**
 * 给一个链表，一个目标数，要求移动链表节点，不能赋值，将链表分成前面小于这个数，后面大于这个数
 * @author yuyang
 * @create 2019-08-28 15:24
 * 写的算法不健壮，这个值不能在链表中
 */
public class 移动链表的节点之一趟快排 {

    public static ListNode fun(ListNode node, int target) {

        ListNode p1 = null, p2 = null;
        if (node.val <= target) {
            p1 = node;
        } else {
            p2 = node;
        }
        ListNode h1 = p1;
        ListNode h2 = p2;
        ListNode p = node.next;
        ListNode pNext = null;
        while (p != null) {
            if (p.val <= target) {
                if (h1 == null) {
                    h1 = p;
                    p = p.next;
                    p1 = h1;
                }
                else {
                    pNext = p.next;
                    h1.next = p;
                    p = pNext;
                    h1 = h1.next;
                }
            } else {
                if(h2 == null){
                    h2 = p;
                    p = p.next;
                    p2 = h2;
                }
                else{
                    pNext = p.next;
                    h2.next = p;
                    p = pNext;
                    h2 = h2.next;
                }
            }
        }
        if(p1 != null){
            h2.next = null;
            h1.next = p2;
            return p1;
        }else
            return p2;

    }

    public static void main(String[] args) {
        //1 4 5 3 7 3 2
        ListNode head = CreateList2();
        ListNode p1 = fun(head, 6);
        printList(p1);
    }
}
