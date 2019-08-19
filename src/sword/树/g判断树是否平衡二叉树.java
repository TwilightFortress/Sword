package sword.树;

/**
 * @author yuyang
 * @create 2019-08-10 10:49
 */
public class g判断树是否平衡二叉树 {
    int left = 0;
    int right = 0;
    public boolean IsBalanced_Solution(TreeNode root) {
        //空树为平衡二叉树
        if(root == null)
            return true;

        if(root != null)
            //左右子树深度差大于1不满足平衡二叉树
            if(IsBalance(root.left) - IsBalance(root.right)>1 ||IsBalance(root.left) - IsBalance(root.right)< -1)
                return false;
        return true;
    }
    //求树的深度
    public int IsBalance(TreeNode root){
        if(root == null) return 0;
        left = IsBalance(root.left);
        right = IsBalance(root.right);
        return Math.max(left,right) + 1;
    }
}
