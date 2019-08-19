package sword.链表;

/**
 * 两个指针，前面的先走k步
 * 1.考虑链表长度不足k的情况，即先移动的指针直接返回null
 * @author yuyang
 * @create 2019-08-08 13:57
 */
public class e链表倒数k个节点 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k <= 0) {
            return null;
        }
        ListNode l = head;
        ListNode r = head;
        //先走k步，连带着空的情况也判断了
        for (int i = 1; i < k; i++) {
            if (l.next != null) {
                l = l.next;
            } else {
                return null;
            }
        }
        while (l.next != null) {
            l = l.next;
            r = r.next;
        }
        return r;
    }
}