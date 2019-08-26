package sword.树;


import java.util.ArrayList;
import java.util.Stack;

import static sword.树.aa创建树.CreateTree;

/**
 * @author yuyang
 * @create 2019-08-21 21:34
 */
public class 之字形打印二叉树 {
    public static ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        if (pRoot == null) return null;
        int layer = 1;
        //s1存奇数层节点
        Stack<TreeNode> s1 = new Stack<TreeNode>();
        s1.push(pRoot);
        //s2存偶数层节点
        Stack<TreeNode> s2 = new Stack<TreeNode>();

        while (!s1.empty() || !s2.empty()) {
            //奇数层
            if (layer % 2 != 0) {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s1.empty()) {
                    TreeNode node = s1.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        if(node.left != null)
                        s2.push(node.left);
                        if(node.right != null)
                        s2.push(node.right);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
                //偶数层
            } else {
                ArrayList<Integer> temp = new ArrayList<Integer>();
                while (!s2.empty()) {
                    TreeNode node = s2.pop();
                    if (node != null) {
                        temp.add(node.val);
                        System.out.print(node.val + " ");
                        if(node.right != null)
                        s1.push(node.right);
                        if(node.left != null)
                        s1.push(node.left);
                    }
                }
                if (!temp.isEmpty()) {
                    list.add(temp);
                    layer++;
                    System.out.println();
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode head = CreateTree();
        ArrayList<ArrayList<Integer>> list = Print(head);
    }

}