package others;

import java.util.HashMap;

/**
 * @author yuyang
 * @create 2019-08-31 17:26
 */
class Node{
    int key;
    int value;
    Node next;
    Node pre;
    public Node(int key,int value,Node pre, Node next){
        this.key = key;
        this.value = value;
        this.pre = pre;
        this.next = next;
    }
}
public class LRU算法 {
    int capacity;
    int count;//cache size
    Node head;
    Node tail;
    HashMap<Integer,Node> hm;
    public LRU算法(int capacity) { //only initial 2 Node is enough, head/tail
        this.capacity = capacity+2;
        this.count = 2;
        this.head = new Node(-1,-1,null,null);
        this.tail = new Node(-2,-2,this.head,null);
        this.head.next = this.tail;
        hm = new HashMap<Integer,Node>();
        hm.put(this.head.key, this.head);
        hm.put(this.tail.key, this.tail);
    }

    public int get(int key) {
        int value = -1;
        if(hm.containsKey(key)){
            Node nd = hm.get(key);
            value = nd.value;
            detachNode(nd); //detach nd from current place
            insertToHead(nd); //insert nd into head
        }
        return value;
    }

    public void put(int key, int value) {
        if(hm.containsKey(key)){ //update
            Node nd = hm.get(key);
            nd.value = value;
            //move to head
            detachNode(nd); //detach nd from current place
            insertToHead(nd); //insert nd into head
        }else{ //add
            Node nodeNew = new Node(key,value,null,null);
            insertToHead(nodeNew);
            hm.put(key,nodeNew);
            if(this.count > capacity){
                removeNode();
            }

        }
    }
    //common func
    public void insertToHead(Node nd){
        nd.next = this.head.next;
        nd.next.pre = nd;
        this.head.next = nd;
        nd.pre = this.head;
        this.count++;
    }
    public void detachNode(Node nd){
        nd.pre.next = nd.next;
        nd.next.pre = nd.pre;
        nd.next = null;
        nd.pre = null;
        this.count--;
    }
    public void removeNode(){ //remove from tail
        if(count<=2)//只有头尾元素的时候不删除
            return;
        Node nd = this.tail.pre;
        detachNode(nd);
        hm.remove(nd.key);

    }

}
