package sword.树;

/**
 * @author yuyang
 * @create 2019-08-10 10:45
 */
public class e二叉树的镜像 {
    public void Mirror(TreeNode head){
        TreeNode tmp;
        if(head != null){
            //交换左右子树
            if(head.left != null || head.right != null){
                tmp = head.left;
                head.left = head.right;
                head.right = tmp;
            }
            Mirror(head.left);
            Mirror(head.right);
        }
    }
}
