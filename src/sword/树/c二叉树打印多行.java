package sword.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import static sword.树.aa创建树.CreateBFS;
import static sword.树.aa创建树.printList;

/**
 * 1.第一层的最后一个节点已知
 * 2.每层的最后一个可以决定下层的最后一个
 *
 * @author yuyang
 * @create 2019-08-10 10:53
 */
public class c二叉树打印多行 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode head) {
        if (head == null) return null;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<ArrayList<Integer>> listAll = new ArrayList<>();

        TreeNode last = head;
        TreeNode nLast = null;

        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            list.add(head.val);
            if (head.left != null) {
                queue.add(head.left);
                nLast = head.left;
            }
            if (head.right != null) {
                queue.add(head.right);
                nLast = head.right;
            }
            if (head == last) {
                listAll.add(new ArrayList<>(list));
                list.clear();
                last = nLast;
            }
        }
        return listAll;
    }

    public static void main(String[] args) {
        TreeNode head = CreateBFS();
        ArrayList<ArrayList<Integer>> list = Print(head);
        printList(list);
    }
}
