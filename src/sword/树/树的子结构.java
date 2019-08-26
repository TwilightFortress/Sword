package sword.树;

/**
 * 0.root1的先序遍历
 * 1.用root2的头结点和root1的全部节点比较
 * 2.相等就向下比较子结构
 * @author yuyang
 * @create 2019-08-10 10:45
 */
public class 树的子结构 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 != null)
            return false;
        //空树不是任意树子结构
        if (root2 == null)
            return false;

        boolean flag = false;
        // 遇到结点值相等，开始比较子结构
        if (root1.val == root2.val) {
            flag = isSubTree(root1, root2);
        }
        //上一个节点值相等，子树结构不同
        if (!flag) {
            //进入root1的左子树，比较
            flag = HasSubtree(root1.left, root2);
            if (!flag) {
                //进入root1的右子树比较
                flag = HasSubtree(root1.right, root2);
            }
        }
        return flag;
    }
    //判断root2是不是root1的子结构
    private boolean isSubTree(TreeNode root1, TreeNode root2) {

        //root1为空root2不为空说明root2树的规模超过了当前root1结构规模
        if (root1 == null && root2 != null)
            return false;

        //root2为空说明root2是root1的子结构
        if (root2 == null)
            return true;
        //两个节点都有值，比较值
        if (root1.val == root2.val) {
            return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
        } else {
            return false;
        }
    }
}