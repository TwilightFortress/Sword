package sword.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 1.第一层的最后一个节点已知
 * 2.每层的最后一个可以决定下层的最后一个
 * @author yuyang
 * @create 2019-08-10 10:53
 */
public class c二叉树打印多行 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode head) {

        if(head == null) return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();
        TreeNode last = head;
        TreeNode nLast = null;
        queue.add(head);
        while(!queue.isEmpty()){
            head = queue.poll();
            list.add(head.val);
            if(head.left != null){
                queue.add(head.left);
                nLast = head.left;
            }
            if(head.right != null){
                queue.add(head.right);
                nLast = head.right;
            }
            if(head == last){
                listAll.add(new ArrayList<Integer>(list));
                list.clear();
                last = nLast;
            }
        }
        return listAll;
    }

    public static void main(String[] args) {
        TreeNode head = new TreeNode(10);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(14);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(8);
        TreeNode node5 = new TreeNode(12);
        TreeNode node6 = new TreeNode(16);
        head.left = node1;
        head.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        ArrayList<ArrayList<Integer>> list = Print(head);
    }
}
