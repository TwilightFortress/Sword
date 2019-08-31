package sword.链表;

import java.util.ArrayList;
import java.util.List;

import static sword.链表.aa创建链表.CreateList2;
import static sword.链表.aa创建链表.printList;

/**
 * @author yuyang
 * @create 2019-08-30 16:31
 */
public class 无序链表拆分两个有序奇偶链表 {

    public static void main(String[] args) {
        //1 4 5 9 7 3 2
        ListNode head = CreateList2();
        ArrayList<ListNode> list = fun(head);
        printList(list.get(0));
        printList(list.get(1));
    }

    public static ArrayList<ListNode> fun(ListNode head){
        ArrayList<ListNode> list = new ArrayList<>();
        ListNode h1 = null;
        ListNode h2 = null;
        ListNode h = null;
        if((head.val & 1) == 1){
            h1 = head;
            h = head.next;
            h1.next = null;

        }else{
            h2 = head;
            h = head.next;
            h2.next  = null;
        }
        while(h!= null){

            //1 h为奇数插入h1
            if((h.val & 1) == 1){
                insert(h1, h);
            }
            //2 h为偶数插入h2
            else{
                insert(h2, h);
            }
            h = h.next;
        }
        list.add(h1);
        list.add(h2);
        return list;
    }
    /**
     * 有序插入，调整头指针
     * @param h1
     * @param h
     */
    private static void insert(ListNode h1, ListNode h) {
        ListNode hNext = h.next;
        if(h1 == null){
          h1 = h;
          h = h.next;
        }

        while(h.val < h1.val){
            h.next = h1;
            h1 = h;
            h = hNext;
        }
        while(h.val > h1.val){
            h1.next = h;
            h.next = null;
            h = hNext;
        }
    }
}
