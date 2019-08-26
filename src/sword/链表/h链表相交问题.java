package sword.链表;

import static sword.链表.aa创建链表.CreateList1;

/**
 * @author yuyang
 * @create 2019-08-08 10:44
 * 链表相交一系列问题：1、判断链表是否有环 2、无环链表相交，返回相交点 3、有环链表相交，返回相交点
 * 1.链表有环至少三个节点
 * 2.快慢指针的定义从头结点下一个开始
 * 3.相遇后快指针回到起始位置
 */
public class h链表相交问题 {


    //主函数
    public static ListNode getIntersectNode(ListNode head1, ListNode head2) {
        //边界：只要有空链表，则没有相交可能
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode loop1 = getLoopNode(head1);
        ListNode loop2 = getLoopNode(head2);
        //两个都没有环
        if (loop1 == null && loop2 == null) {
            return noLoop(head1, head2);
        }
        //两个都有环
        if (loop1 != null && loop2 != null) {
            return bothLoop(head1, loop1, head2, loop2);
        }
        return null;
    }

    /**
     * 判断链表是否有环，返回入环节点。
     * 1.边界：链表有环至少三个节点
     * 2.快慢指针初始：慢指针为头结点后一个指针，快指针为头结点后两个指针
     * 3.while判断，条件为两个指针不相等，如果有指针变为null，说明没有环，有环自动结束while循环。
     * 4.返回入环节点：快指针回到头结点，两个指针一起移动，相遇时节点为入环点
     * @param head
     * @return
     */
    public static ListNode getLoopNode(ListNode head) {
        //链表有环最少三个节点，少于三个节点直接返回null
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        //注意：第一个指针为头结点下一个节点
        ListNode n1 = head.next; // n1 -> slow
        ListNode n2 = head.next.next; // n2 -> fast
        //遍历链表的过程：循环条件为两个指针不相等
        while (n1 != n2) {
            //循环过程中如果有快慢指针有指向null的情况，说明链表无环
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        //返回入环节点：快指针回到头结点，两个指针一起移动，相遇时节点为入环点
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }

    /**
     * 判断两个无环链表是否相交，返回相交节点：
     * 1.分别遍历两个链表，走到表尾，定义一个变量n = 0，第一个链表走变量++，第二个链表走变量--，n为两个链表的长度差值。
     * 2.走到最后如果两个链表节点不是同一个，不相交，是同一个相交。
     * 3.长的链表先走n,然后一起走，走到相等的节点，为相交节点
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode noLoop(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        ListNode cur1 = head1;
        ListNode cur2 = head2;
        int n = 0; //两个链表长度的差值
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        if (cur1 != cur2) {
            return null;
        }
        //让cur1指向长的链表
        cur1 = n > 0 ? head1 : head2;
        cur2 = cur1 == head1 ? head2 : head1;
        n = Math.abs(n);
        //长的先走，短的后走
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        //相交返回
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    //两个链表都有环是否相交：判断loop点是否相等：分两种情况

    /**
     * 两个链表都有环是否相交,返回相交节点。
     * 1.判断连个链表的入环点是否相等，相等则变成无环链表相交问题。
     * 2.入环点不相等，选择一个入环点，绕环一周，如果能遇到第二个入环点，相交，遇不到不相交，相交点返回任意一个入环点。
     * @param head1
     * @param loop1
     * @param head2
     * @param loop2
     * @return
     */
    public static ListNode bothLoop(ListNode head1, ListNode loop1, ListNode head2, ListNode loop2) {
        ListNode cur1 = null;
        ListNode cur2 = null;
        //入环点相等：变成有环相交问题
        if (loop1 == loop2) {
            cur1 = head1;
            cur2 = head2;
            int n = 0;
            while (cur1 != loop1) {
                n++;
                cur1 = cur1.next;
            }
            while (cur2 != loop2) {
                n--;
                cur2 = cur2.next;
            }
            cur1 = n > 0 ? head1 : head2;
            cur2 = cur1 == head1 ? head2 : head1;
            n = Math.abs(n);
            while (n != 0) {
                n--;
                cur1 = cur1.next;
            }
            while (cur1 != cur2) {
                cur1 = cur1.next;
                cur2 = cur2.next;
            }
            return cur1;
            //选择一个入环点，绕环一周，如果能遇到第二个入环点，相交，遇不到不相交
        } else {
            cur1 = loop1.next;
            while (cur1 != loop1) {
                if (cur1 == loop2) {
                    return loop1;
                }
                cur1 = cur1.next;
            }
            return null;
        }
    }

    public static void main(String[] args) {
        // 1->2->3->4->5->6->7->null
        ListNode head1 = CreateList1();

        // 0->9->8->6->7->null
        ListNode head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).val);

        // 1->2->3->4->5->6->7->4...
        head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next = new ListNode(6);
        head1.next.next.next.next.next.next = new ListNode(7);
        head1.next.next.next.next.next.next = head1.next.next.next; // 7->4

        // 0->9->8->2...
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next; // 8->2
        System.out.println(getIntersectNode(head1, head2).val);

        // 0->9->8->6->4->5->6..
        head2 = new ListNode(0);
        head2.next = new ListNode(9);
        head2.next.next = new ListNode(8);
        head2.next.next.next = head1.next.next.next.next.next; // 8->6
        System.out.println(getIntersectNode(head1, head2).val);
    }
}
