package sword.链表;

/**
 * @author yuyang
 * @create 2019-08-24 13:55
 */
public class aa创建链表 {
    // 1->2->3->4->5->6->7->null
    public static ListNode CreateList1(){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        return head1;
    }

    public static ListNode CreateList2(){
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(5);
        head1.next.next.next = new ListNode(9);
        head1.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next = new ListNode(3);
        head1.next.next.next.next.next.next = new ListNode(2);
        return head1;
    }
    public static ListNode CreateList3(){
        ListNode head1 = new ListNode(9);
        head1.next = new ListNode(6);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(7);
        head1.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next = new ListNode(5);
        return head1;
    }

    public static void printList(ListNode head){
        while(head != null){
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

}
