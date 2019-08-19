package sword.链表;

/**
 * 1.比较当前两个链表的头结点值，谁小返回谁，作为合并链表的头节点。
 * 2.当前节点的next为，原链表中当前节点的next和另一个节点比较小的值（递归调用）
 * @author yuyang
 * @create 2019-08-08 14:31
 */
public class b合并两个排序链表 {

    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.val < list2.val) {
            list1.next = Merge(list1.next, list2);
            return list1;
        } else {
            list2.next = Merge(list1, list2.next);
            return list2;
        }
    }
}
