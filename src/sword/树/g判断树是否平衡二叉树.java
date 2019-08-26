package sword.树;

/**
 * @author yuyang
 * @create 2019-08-10 10:49
 */
public class g判断树是否平衡二叉树 {
    int left = 0;
    int right = 0;
    public boolean IsBalanced_Solution(TreeNode head) {
        //空树为平衡二叉树
        if(head == null)
            return true;

        if(head != null)
            if(Math.abs(IsBalance(head.left) - IsBalance(head.right)) > 1)
                return false;
        return true;
    }
    //求树的深度
    public int IsBalance(TreeNode head){
        if(head == null) return 0;
        left = IsBalance(head.left);
        right = IsBalance(head.right);
        return Math.max(left,right) + 1;
    }
}
