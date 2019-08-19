package sword.链表;

/**
 * 1->2->3->3->4->4->5 处理后为 1->2->5
 * 1.使用cur.next.val考虑cur.next是否为空
 * 2.考虑从第一个节点开始删除的情况，即使pre == null,直接让head指向当前节点。
 * @author yuyang
 * @create 2019-08-07 10:32
 */


public class f删除链表中重复的节点 {
    public ListNode deleteDuplication(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            boolean needDelete = false;
            //判断当前节点是否删除：当前节点值等于下一个节点的值，则当前节点需要删除
            if (cur.next != null && cur.val == cur.next.val)
                needDelete = true;
            //不删除指针的移动
            if (!needDelete) {
                pre = cur;
                cur = cur.next;
            } else {
                //从当前节点向后判断有多少个节点的值相等，cur标记到不相等的节点上
                int dupValue = cur.val;
                while (cur != null && cur.val == dupValue) {
                    cur = cur.next;
                }
                //pre如果为空，当前节点标记为头节点，前面的都相等，包括原来的头结点
                if (pre == null) {
                    head = cur;
                } else {
                    //中间相等节点全部跳过
                    pre.next = cur;
                }
            }
        }
        return head;
    }
}
