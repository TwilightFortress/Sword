package sword.链表;

/**
 * （每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点）
 * 返回结果为复制后复杂链表的head。
 * @author yuyang
 * @create 2019-08-08 15:20
 */
public class g复杂链表的复制 {
    public static RandomListNode Clone(RandomListNode head)
    {
        if(head == null) return null;
        RandomListNode p = head;
        RandomListNode pNext = null;
        //第一步：在链表中，每个节点复制一个放到原链表中节点位置后面 1-2-3-4 ： 1-1-2-2-3-3-4-4
        while(p != null){
            pNext = p.next;
            RandomListNode node = new RandomListNode(p.label);
            p.next = node;
            node.next = pNext;
            p = pNext;
        }
        //第二步：复制链表中新添加节点的随机指针，p1的随机指针等于p的随机指针的next
        p = head;
        RandomListNode p1 = null;
        while(p != null){
            p1 = p.next;
            if(p.random != null)
                p1.random = p.random.next;
            p = p.next.next;
        }
        //第三步：拆解两个链表：四个指针，p是原链表，p1是复制的链表
        p = head;
        RandomListNode realHead = p.next;
        p1 = p.next;
        RandomListNode p1Next = null;
        while(p != null){
            pNext = p.next.next;
            //使用p1.next.next注意p1.next是否为空
            p1Next = p1.next != null ? p1.next.next: null;
            p.next = pNext;
            p1.next = p1Next;
            p = pNext;
            p1 = p1Next;
        }
        return realHead;
    }
}