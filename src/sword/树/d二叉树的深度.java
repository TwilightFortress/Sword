package sword.树;

/**
 * @author yuyang
 * @create 2019-08-10 10:48
 */
public class d二叉树的深度 {
    public int TreeDepth(TreeNode head) {
        if(head == null) return 0;
        return Math.max(TreeDepth(head.left),TreeDepth(head.right)) + 1;
    }
}

