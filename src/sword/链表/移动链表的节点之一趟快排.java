package sword.链表;

import java.util.Scanner;

import static sword.链表.aa创建链表.CreateList2;
import static sword.链表.aa创建链表.CreateList3;
import static sword.链表.aa创建链表.printList;

/**
 * 给一个链表，一个目标数，要求移动链表节点，不能赋值，将链表分成前面小于这个数，后面大于这个数
 *
 * @author yuyang
 * @create 2019-08-28 15:24
 * 写的算法不健壮，这个值不能在链表中
 */
public class 移动链表的节点之一趟快排 {

    public static ListNode partition(ListNode head, int m) {
        if (head == null) return head;
        ListNode p1 = null, p2 = null;
        if (head.val <= m) {
            p1 = head;
        } else {
            p2 = head;
        }
        ListNode h1 = p1;
        ListNode h2 = p2;
        ListNode p = head.next;
        ListNode pNext = null;
        while (p != null) {
            if (p.val <= m) {
                if (h1 == null) {
                    h1 = p;
                    p = p.next;
                    p1 = h1;
                } else {
                    pNext = p.next;
                    h1.next = p;
                    p = pNext;
                    h1 = h1.next;
                }
            } else {
                if (h2 == null) {
                    h2 = p;
                    p = p.next;
                    p2 = h2;
                } else {
                    pNext = p.next;
                    h2.next = p;
                    p = pNext;
                    h2 = h2.next;
                }
            }
        }
        if (p1 != null) {
            if(h2 != null){
                h2.next = null;
                h1.next = p2;
                return p1;
            }else
                return p1;

        } else
            return p2;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ListNode head = null;
        ListNode node = null;
        int m = in.nextInt();
        int v = in.nextInt();
        if (head == null) {
            node = new ListNode(v);
            head = node;
        } else {
            node.next = new ListNode(v);
            node = node.next;
        }
        head = partition(head, m);
        if (head != null) {
            System.out.print(head.val);
            head = head.next;
            while (head != null) {
                System.out.print(",");
                System.out.print(head.val);
                head = head.next;
            }
        }
        System.out.println();
    }
}
