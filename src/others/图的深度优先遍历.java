package others;

import sword.树.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author yuyang
 * @create 2019-08-31 16:23
 */
public class 图的深度优先遍历 {
    public class Solution {
        public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
            ArrayList<Integer> lists=new ArrayList<Integer>();
            if(root==null)
                return lists;
            Stack<TreeNode> stack=new Stack<TreeNode>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode tree=stack.pop();
              //先往栈中压入右节点，再压左节点，这样出栈就是先左节点后右节点了。
                if(tree.right!=null)
                    stack.push(tree.right);
                if(tree.left!=null)
                    stack.push(tree.left);
                lists.add(tree.val);
            }
            return lists;
        }
    }
}
