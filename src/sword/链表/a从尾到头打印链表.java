package sword.链表;

import java.util.ArrayList;

/**
 * 打印当前节点时，先打印当前节点的下一个节点
 * @author yuyang
 * @create 2019-08-08 13:55
 */
public class a从尾到头打印链表 {
    ArrayList<Integer> contraryList = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode != null){
            printListFromTailToHead(listNode.next);
            contraryList.add(listNode.val);
        }
        return contraryList;
    }
}