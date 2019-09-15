package sword.树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * @author yuyang
 * @create 2019-09-14 19:38
 */
/*
G,K,B,A,C,null,A
AKCGBA
 */
class Node {
    Node left;
    Node right;
    String val;

    public Node(String val) {
        this.val = val;

    }
}

public class 文本层序反序列化成树 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        Node node = reconByLevelString(str);
        if(node == null) {
            System.out.print("null");
            return;
        }
        inOrderRecur(node);
    }

    public static Node reconByLevelString(String levelStr) {
        String[] values = levelStr.split(",");
        int len = values.length;
        int index = 0;
        Node head = generateNodeByString(values[index++]);
        Queue<Node> queue = new LinkedList<Node>();
        if (head != null) {
            queue.offer(head);
        }
        Node node = null;
        while (!queue.isEmpty()) {
            node = queue.poll();
            if (index == len) break;
            node.left = generateNodeByString(values[index++]);
            node.right = generateNodeByString(values[index++]);
            if (node.left != null) {
                queue.offer(node.left);
            }
            if (node.right != null) {
                queue.offer(node.right);
            }
        }
        return head;
    }

    public static Node generateNodeByString(String val) {
        if (val.equals("null")) {
            return null;
        }
        return new Node(val);
    }

    public static void inOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        inOrderRecur(head.left);
        System.out.print(head.val);
        inOrderRecur(head.right);
    }

    public static void preOrderRecur(Node head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val);
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }
}
