package sword.树;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yuyang
 * @create 2019-08-23 10:02
 */
public class aa创建树 {

    /**
     * 创建一个普通的树
     */
    public static TreeNode CreateTree(){
        TreeNode head = new TreeNode(5);
        head.left = new TreeNode(3);
        head.right = new TreeNode(8);
        head.left.left = new TreeNode(2);
       // head.left.right = new TreeNode(4);
        head.left.right = new TreeNode(20);
        head.left.left.left = new TreeNode(1);
        head.right.left = new TreeNode(7);
        head.right.left.left = new TreeNode(6);
        head.right.right = new TreeNode(10);
        head.right.right.left = new TreeNode(9);
        head.right.right.right = new TreeNode(11);
        return head;
    }
    /**
     * 创建二叉搜索树
     */
    public static TreeNode CreateBFS(){
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
        return head;
    }

    public static void printList(ArrayList<ArrayList<Integer>> lists){
        for (List<Integer> list : lists) {
            for (int i = 0; i < list.size(); i++) {
                System.out.print(list.get(i) + " ");
            }
            System.out.println();
        }
    }
}
