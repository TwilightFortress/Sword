package sword.树;

import java.util.LinkedList;
import java.util.Queue;

import static sword.树.aa创建树.CreateBFS;

/**
 * @author yuyang
 * @create 2019-08-21 14:21
 */
public class c二叉树的宽度 {

    public static int Print(TreeNode head) {
        if (head == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        int MaxLength = 1;
        int length = 0;
        TreeNode last = head;
        TreeNode nLast = null;
        queue.add(head);
        while (!queue.isEmpty()) {
            head = queue.poll();
            if (head.left != null) {
                queue.add(head.left);
                nLast = head.left;
                length++;
            }
            if (head.right != null) {
                queue.add(head.right);
                nLast = head.right;
                length++;
            }
            if (head == last) {
                MaxLength = Math.max(length, MaxLength);
                length = 0;
                last = nLast;
            }
        }
        return MaxLength;
    }

    public static void main(String[] args) {
        TreeNode head = CreateBFS();
        System.out.println(Print(head));
    }
}

