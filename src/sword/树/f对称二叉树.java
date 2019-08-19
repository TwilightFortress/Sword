package sword.树;

/**
 * @author yuyang
 * @create 2019-08-10 10:50
 */
public class f对称二叉树 {
    boolean isSymmetrical(TreeNode pRoot)
    {
        if(pRoot == null){
            return true;
        }
        return comRoot(pRoot.left, pRoot.right);
    }
    private boolean comRoot(TreeNode left, TreeNode right) {
        // 左右子树为空，不为空的情况。
        if(left == null) return right==null; //左空右空 左空右不空
        if(right == null) return false;      //左不空右空
        //左不空右不空
        if(left.val != right.val) return false;
        return comRoot(left.right, right.left) && comRoot(left.left, right.right);
    }
}
