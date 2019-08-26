package sword.树;

import java.util.Stack;

import static sword.树.aa创建树.CreateBFS;

/**
 * 1.中序遍历
 * 2.记录中序遍历第k个，找到后依次返回递归就可以
 *
 * @author yuyang
 * @create 2019-08-10 10:54
 */
public class i二叉搜索树第k小节点 {
    int index = 0; //计数器

    /**
     * 递归方式
     * @param head
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode head, int k) {
        if (head != null) { //中序遍历寻找第k个
            TreeNode node = KthNode(head.left, k);
            //把递归找到的节点逐层的返回到最后一层
            if (node != null)
                return node;
            index++;
            if (index == k)
                return head;
            node = KthNode(head.right, k);
            //把递归找到的节点逐层的返回到最后一层
            if (node != null)
                return node;
        }
        return null;
    }

    /**
     * 非递归
     * @param head
     * @param k
     * @return
     */
    public static TreeNode fun(TreeNode head, int k) {
        if (head == null) throw new RuntimeException("Empty tree!");
        TreeNode node = null;
        int r = 0;
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || head != null) {
            if (head != null) {
                stack.add(head);
                head = head.left;
            } else {
                head = stack.pop();
                r++;
                if (r == k) {
                    node = head;
                }
                head = head.right;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        TreeNode node = CreateBFS();
        TreeNode p = fun(node, 4);
        System.out.println(p.val);
    }
}
