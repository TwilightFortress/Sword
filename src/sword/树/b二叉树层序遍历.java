package sword.树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author yuyang
 * @create 2019-08-10 10:46
 */
public class b二叉树层序遍历 {
    //辅助结构
    Queue<TreeNode> queue = new LinkedList<>();
    //存储数据
    ArrayList<Integer> list = new ArrayList<Integer>();

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode head) {
        TreeNode tmp;
        //头结点入队列
        if (head != null)
            queue.add(head);
        //队列不为空
        while (!queue.isEmpty()) {
            //出队
            tmp = queue.poll();
            list.add(tmp.val);
            //左子树不为空左子树入队
            if (tmp.left != null) {
                queue.add(tmp.left);
            }
            //右子树不为空右子树入队
            if (tmp.right != null) {
                queue.add(tmp.right);
            }
        }
        return list;
    }
}
