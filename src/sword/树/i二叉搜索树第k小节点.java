package sword.树;

/**
 * 1.中序遍历
 * 2.记录中序遍历第k个，找到后依次返回递归就可以
 * @author yuyang
 * @create 2019-08-10 10:54
 */
public class i二叉搜索树第k小节点 {
    int index = 0; //计数器

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
}
