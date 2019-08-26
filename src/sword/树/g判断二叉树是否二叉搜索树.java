package sword.树;

import java.util.Stack;
import static sword.树.aa创建树.CreateBFS;
import static sword.树.aa创建树.CreateTree;

/**
 * @author yuyang
 * @create 2019-08-23 9:41
 */
public class g判断二叉树是否二叉搜索树 {

    /**
     * 递归方式
     */
    int last = Integer.MIN_VALUE;
    public boolean isTree(TreeNode root){
        if(root == null)
            return true;
        if(!isTree(root.left))
            return false;
        if(root.val <= last)
            return false;
        last=root.val;
        if(!isTree(root.right))
            return false;
        return true;
    }

    /**
     * 非递归方式
     * @param node
     * @return
     */
    public static boolean fun(TreeNode node){
        if(node != null){
            TreeNode pre = null;
            Stack<TreeNode> stack = new Stack<>();
            while(!stack.isEmpty() || node != null){
                if(node != null){
                    stack.add(node);
                    node = node.left;
                }else{
                    node = stack.pop();
                    if(pre != null && (pre.val > node.val)) return false;
                    pre = node;
                    node = node.right;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode head = CreateTree();
        System.out.println(fun(head));
        TreeNode head1 = CreateBFS();
        System.out.println(fun(head1));
    }
}
